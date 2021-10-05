package Practice.part02.Day11;

import java.io.*;
import java.util.*;

public class Jungol2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d+1];

        int curCount = 0;
        for (int i = 0; i < k; i++) {
            count[belt[i]]++;
            if(count[belt[i]] == 1) curCount++;
        }
        count[c]++;
        if(count[c] == 1) curCount++;

        int answer = curCount;
        for (int i = 0; i < N-1; i++) {
            count[belt[i]]--;
            if(count[belt[i]] == 0) curCount--;
            int cur = i + k;
            if(i+k >= N) cur = cur - N;
            count[belt[cur]]++;
            if(count[belt[cur]] == 1) curCount++;

            answer = Math.max(answer, curCount);
        }
        System.out.println(answer);
        br.close();
    }
}
