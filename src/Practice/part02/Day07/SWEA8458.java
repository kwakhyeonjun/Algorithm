package Practice.part02.Day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] distances = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                distances[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
            }

            int isEven = distances[0]%2;
            int max = 0;
            int answer = 0;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, distances[i]);
                if(isEven != distances[i]%2) answer = -1;
            }
            if(answer == -1) {
                System.out.println("#" + test_case + " -1");
                continue;
            }

            int sum = 0;
            while(sum < max || Math.abs(max - sum) % 2 == 1) {
                sum += ++answer;
            }


            System.out.println("#" + test_case + " " + answer);
        }
        br.close();

    }
}
