package AlgoStudy.Week04;

public class Ternary {
    public static void main(String[] args) {
        solution(45);
    }

    public static int solution(int n) {
        int answer = 0;

        String newThree = "";
        int i = 0;
        while(n != 0){
            newThree = (n%3) + newThree;
            n = n/3;
        }

        for(i = 0; i < newThree.length(); i++){
            answer += Math.pow(3, i) * (newThree.charAt(i) - '0');
        }

        return answer;
    }
}
