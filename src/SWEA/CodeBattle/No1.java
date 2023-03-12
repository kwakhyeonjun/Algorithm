package SWEA.CodeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            // input
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            gates = new Gate[3];
            for (int i = 0; i < 3; i++) {
                String[] cur = br.readLine().split(" ");
                gates[i] = new Gate(Integer.parseInt(cur[0]) - 1, Integer.parseInt(cur[1]));
            }

            // init
            visited = new boolean[3];
            picked = new int[3];

            // select with perm
            perm(0);

//            System.out.println(answer);
        }
    }

    private static int N, answer;
    private static Gate[] gates;
    private static boolean[] visited;
    private static int[] picked;

    private static void selectSpot() {
        int cur = 0;

        // init map
        boolean[] map = new boolean[N];

        // iter gates
        for (int i = 0; i < 3; i++) {
            int curLoc = gates[picked[i]].location;
            int curFisher = gates[picked[i]].fisher;


        }

        // after iter gate, compare answer and cur
        answer += Math.min(answer, cur);
    }

    private static void getRightMove() {

    }

    private static void getLeftMove() {

    }

    private static void perm(int count) {
        if (count == 3) {

            // select spot
            selectSpot();

            return;
        }
        for (int i = 0; i < 3; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            picked[count] = i;
            perm(count + 1);
            visited[i] = false;
        }
    }

    static class Gate {
        int location;
        int fisher;

        Gate(int location, int fisher){
            this.location = location;
            this.fisher = fisher;
        }
    }
}
