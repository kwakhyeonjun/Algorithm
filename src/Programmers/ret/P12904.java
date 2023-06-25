package Programmers.ret;

public class P12904 {
    public static void main(String[] args) {
        P12904 sol = new P12904();
        int answer = sol.solution("xaxabbaxxx");
        System.out.println(answer);
    }
    public int solution(String s) {
        int answer = 1;

        for (int start = 0; start < s.length(); start++) {
            for (int end = s.length() - 1; end > start ; end--) {
                if(isAnswer(s, start, end)) {
                    answer = Math.max(answer, end - start + 1);
                }
            }
        }

        return answer;
    }

    private boolean isAnswer(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
