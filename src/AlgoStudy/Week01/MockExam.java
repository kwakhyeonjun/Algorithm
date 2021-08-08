package AlgoStudy.Week01;

import java.util.Arrays;

public class MockExam {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1,2,3,4,5});
        for(int i = 0; i <result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
        result = solution(new int[]{1,3,2,4,2});
        for(int i = 0; i <result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int[] answers){
        int[] answer = new int[3];
        int[] point = {0,0,0};
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int o = 0, t = 0, th = 0;
        for(int i = 0; i <answers.length; i++){
            if(one[o] == answers[i]) point[0]++;
            if(two[t] == answers[i]) point[1]++;
            if(three[th] == answers[i]) point[2]++;

            if(o>=4) o = 0;
            else o++;

            if(t>=7) t=0;
            else t++;

            if(th>=9) th=0;
            else th++;
        }
        /*
         * 1. max를 찾음
         * 2. max와 같은 수를 가진 녀석을 배열에 저장
         */
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            max = Math.max(max, point[i]);
        }

        int idx = 0;
        for(int i = 0; i < 3; i++){
            if(point[i] == max) answer[idx++] = i+1;
        }
        return Arrays.copyOf(answer, idx);
    }
}
