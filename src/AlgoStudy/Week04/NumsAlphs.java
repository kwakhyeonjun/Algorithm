package AlgoStudy.Week04;

public class NumsAlphs {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
    private static String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static int solution(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') result.append(s.charAt(i));
            else{
                temp.append(s.charAt(i));
                for(int j = 0; j < nums.length; j++){
                    if(nums[j].equals(temp.toString())) {
                        result.append(j);
                        temp = new StringBuilder();
                    }
                }
            }
        }
        return Integer.parseInt(result.toString());
    }
}
