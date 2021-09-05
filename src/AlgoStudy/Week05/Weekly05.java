package AlgoStudy.Week05;

public class Weekly05 {
    public static void main(String[] args) {

    }

    private String alp = "AEIOU";
    public int solution(String word) {
        int answer = 5;
        int pos = 4;
        for(int i = 0; i < word.length(); i++){
            int pow = (int)Math.pow(5, pos--);
            answer += pow*alp.indexOf(word.charAt(i));
        }

        return answer;
    }
}
