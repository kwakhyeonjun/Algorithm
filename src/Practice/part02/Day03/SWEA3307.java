package Practice.part02.Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[N];
            for(int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int[] pick = new int[N];

            pick[0] = 1;
            for(int i = 1; i < N; i++){
                int max = Integer.MIN_VALUE;
                for(int j = i - 1; j >= 0 ; j--){
                    if(nums[j] < nums[i] && pick[j] > max){
                        max = pick[j];
                        pick[i] = pick[j] + 1;
                    }
                    if(pick[i] == 0) pick[i] = 1;
                }
            }

            int max = Integer.MIN_VALUE;
            for(int i : pick) max = Math.max(max, i);
            System.out.println("#" + test_case + " " +max);
        }
    }
}
