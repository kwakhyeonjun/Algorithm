package AlgoStudy.Week02;

import java.util.Locale;

public class NewID {
    public static void main(String[] args) {
        System.out.println(solution("..........."));
    }

    /**
     * 조건
     * 1. 아이디의 길이는 3자 이상 15자 이하
     * 2. 아이디는 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 문자만 사용가능
     * 3. 마침표는 처음과 끝에 사용할 수 없으며, 연속으로 사용 불가능
     *
     * 과정
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     * @param new_id
     * @return
     */
    public static String solution(String new_id) {
        // 1단계
        String id_1 = new_id.toLowerCase();
        // 2단계
        String id_2 = "";
        for(int i = 0; i < id_1.length(); i++){
            if(isRight(id_1.charAt(i))) id_2 += id_1.charAt(i);
        }
        // 3단계
        String id_3 = "";
        int dotIdx = 0;
        for(int i = 0; i < id_2.length(); i++){
            if(id_2.charAt(i) == '.'){
                if(i + 1 >= id_2.length()) {
                    id_3 += id_2.charAt(i);
                    break;
                }
                for(int j = i + 1; j < id_2.length(); j++){
                    if(id_2.charAt(j) != '.'){
                        dotIdx = j;
                        break;
                    }else{
                        if(j == id_2.length() - 1){
                            dotIdx = id_2.length();
                        }
                    }
                }
                id_3 += '.';
                i = dotIdx - 1;
            }else{
                id_3 += id_2.charAt(i);
            }
        }
        // 4단계
        String id_4 = "";
        for(int i = 0; i < id_3.length(); i++){
            if((i ==0 || i == id_3.length() - 1) && id_3.charAt(i) == '.') continue;
            else id_4 += id_3.charAt(i);
        }
        //5단계
        if(id_4.equals("")) id_4 += 'a';

        //6단계
        String id_6 = "";
        if(id_4.length() > 15){
            for(int i = 0; i < 15; i++){
                if(i == 14 && id_4.charAt(i) == '.') continue;
                id_6 += id_4.charAt(i);
            }
        }else{
            id_6 = id_4;
        }

        //7단계
        if(id_6.length() <= 2){
            while(id_6.length() < 3){
                id_6 += id_6.charAt(id_6.length() - 1);
            }
        }
        return id_6;

    }

    private static boolean isRight(char c){
        if((c >= 'a' && c <= 'z' ) || (c >= '0' && c <= '9' ) || c == '-' || c == '_' || c == '.') return true;
        else return false;
    }
}
