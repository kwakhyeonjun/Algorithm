package Programmers.ret;

public class P12923 {
    public static void main(String[] args) {
        P12923 sol = new P12923();
        int[] answer = sol.solution(1, 10);
        for (int i : answer) {
            System.out.print(i);
        }
    }

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin + 1)];

        long index = begin;

        for (int i = 0; i < answer.length; i++) {
            answer[i] = 1;
            for (int j = 2; j * j <= index; j++) {
                if(index % j == 0) {
                    if(index / j > 10_000_000) continue;
                    answer[i] = (int) (index / j);
                    break;
                }
            }

            if(index == 1) answer[i] = 0;
            index++;
        }

        return answer;
    }
}
