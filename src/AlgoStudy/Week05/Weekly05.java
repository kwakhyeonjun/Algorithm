package AlgoStudy.Week05;

public class Weekly05 {
    public static void main(String[] args) {

    }

    private String alp = "_EIOU";
    private int[] digits = {781, 156, 31, 6, 1};
    public int solution(String word) {
        int answer = 0;
        int pos = 4;
        for(int i = 0; i < word.length(); i++){
            int pow = digits[i];
            if(word.charAt(i)=='A') answer += 1;
            else{
                answer += pow*alp.indexOf(word.charAt(i)) + 1;
            }

        }

        return answer;
    }
}
