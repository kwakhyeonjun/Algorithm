package Programmers.Level2;

public class Tired {
    public static void main(String[] args) {
        Tired sol = new Tired();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(sol.solution(k, dungeons));
    }

    public int solution(int k, int[][] dungeons) {
        this.answer = -1;

        this.k = k;
        this.dungeons = dungeons;
        picked = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        comb(0);

        return answer;
    }

    private int k;
    private int answer;
    private int[] picked;
    private int[][] dungeons;
    private boolean[] visited;

    private void comb(int count) {
        if(count == dungeons.length){
            int tired = k;
            int cur = 0;
            for (int i : picked) {
                if(tired >= dungeons[i][0]) {
                    tired -= dungeons[i][1];
                    cur++;
                }
            }
            answer = Math.max(answer, cur);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            picked[count] = i;
            comb(count + 1);
            visited[i] = false;
        }
    }
}
