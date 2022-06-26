package Programmers.SkillCheck;


public class SkillCheck2_2_1 {
    public static void main(String[] args) {
        SkillCheck2_2_1 sol = new SkillCheck2_2_1();
        String s = "ababcdcdababcdcd";
        System.out.println(sol.solution(s));
    }

    public int solution(String s) {
        int answer = s.length();

        // 압축할 개수
        for (int t = 1; t <= s.length() / 2; t++) {
            StringBuilder sb = new StringBuilder();
            char cur;
            String prev = "";
            int count = 1;
            for (int i = 0; i < s.length(); i++) {
                if(i + 2 * t > s.length()) {
                    if(count > 1) {
                        sb.append(count);
                        sb.append(prev);
                    }else{
                        sb.append(s, i, s.length());
                    }
                    break;
                }
                cur = s.charAt(i);
                if(s.substring(i, i + t).equals(s.substring(i + t, i + 2 * t))){
                    prev = s.substring(i, i + t);
                    i += t - 1;
                    count++;
                } else {
                    if(count == 1) sb.append(cur);
                    else {
                        sb.append(count);
                        sb.append(prev);
                        i += t - 1;
                    }
                    count = 1;
                }
                if(i == 0 && count == 1) {
                    sb.append(s);
                    break;
                }
            }
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

    public int solution2(String s) {
        int answer = s.length();    // 압축하기 전 문자열 길이로 초기화

        for(int i = 1; i <= s.length() / 2; i++){
            int zipLevel = 1;                           // 현재 압축정도
            String zipStr = s.substring(0, i);          // 압축할 문자
            StringBuilder result = new StringBuilder(); // 압축완료한 문자를 저장할 StringBuilder

            for(int j = i; j <= s.length(); j += i){
                // 다음 문자 추출
                String next = s.substring(j, Math.min(j + i, s.length()));
                // 다음 문자와 현재 문자가 같으면 zipLevel증가
                if(zipStr.equals(next)) zipLevel++;
                    // 다음 문자와 현재 문자가 다를 경우
                else{
                    // (압축이 안됬을 경우는 공백, 압축이 됬을경우 zipLevel을 붙여줌) + 압축할 문자를 넣어줌,
                    result.append(zipLevel != 1 ? zipLevel : "").append(zipStr);
                    zipStr = next;      // 다음 문자를 압축할 문자로 지정
                    zipLevel = 1;       // 압축 정도 1로 초기화
                }
            }
            result.append(zipStr);      // 마지막에 추가안된 zipStr추가
            answer = Math.min(answer, result.length()); // 가장 작은 문자열 길이 저장
        }

        return answer;
    }
}
