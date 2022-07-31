package Programmers.Curriculum;

import java.util.Arrays;

public class P42861 {
    public static void main(String[] args) {
        P42861 sol = new P42861();

        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(sol.solution(4, costs));
    }

    int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (int[] o1, int[] o2) -> o1[2] - o2[2]);
        parents = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for(int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            if(fromParent == toParent) continue;

            answer += cost;
            parents[toParent] = fromParent;
        }

        return answer;
    }

    private int findParent(int n) {
        if(parents[n] == n) return n;
        return parents[n] = findParent(parents[n]);
    }
}
