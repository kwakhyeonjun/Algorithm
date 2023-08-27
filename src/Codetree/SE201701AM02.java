package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SE201701AM02 {
    private static List<Job> jobs = new ArrayList<>();
    private static int n, answer;
    private static boolean[] visited;
    private static int[] picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        picked = new int[n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int time = Integer.parseInt(split[0]);
            int pay = Integer.parseInt(split[1]);

            jobs.add(new Job(i + 1, time, pay));
        }

        comb(0, 0, 0);

        System.out.println(answer);
    }

    private static void calc(int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += jobs.get(picked[i]).pay;
        }

        answer = Math.max(answer, sum);
    }

    private static void comb(int start, int count, int curTime) {
        if(count > n) return;

        calc(count);

        for (int i = start; i < n; i++) {
            if(visited[i]) continue;
            Job cur = jobs.get(i);
            if(curTime > cur.start) continue;
            if(cur.start + cur.time > n + 1) continue;

            picked[count] = i;
            comb(i + 1, count + 1, cur.start + cur.time);
        }
    }

    static class Job {
        int start;
        int time;
        int pay;

        public Job(int start, int time, int pay) {
            this.start = start;
            this.time = time;
            this.pay = pay;
        }
    }
}
