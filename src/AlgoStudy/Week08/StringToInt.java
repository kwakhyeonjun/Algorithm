package AlgoStudy.Week08;

public class StringToInt {
    public static void main(String[] args) {
        StringToInt sol = new StringToInt();
        System.out.println(sol.solution("-1000"));
    }

    public int solution(String s){
        int answer = 0;
        int pow = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '-'){
                answer = -1 * answer;
                continue;
            }else if(s.charAt(i) == '+') continue;
            answer += Math.pow(10, pow++) * Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return answer;
    }

    public int solution2(String s){
        return Integer.parseInt(s);
    }
}
