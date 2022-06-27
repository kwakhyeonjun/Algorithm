package Programmers.Level2;

public class Land {
    public static void main(String[] args) {
        Land sol = new Land();

        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(sol.solution(land));
    }

    public int solution(int[][] land) {
        max = Integer.MIN_VALUE;
        for (int i = 0; i < land.length; i++) {
            dfs(land, 1,  i, land[0][i]);
        }
        return max;
    }

    private int max;

    private void dfs(int[][] land, int height, int prev, int sum) {
        if(height == land.length) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < land[height].length; i++) {
            if(prev == i) continue;
            dfs(land, height + 1, i, sum + land[height][i]);
        }
    }
}
