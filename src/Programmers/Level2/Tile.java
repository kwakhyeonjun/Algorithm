package Programmers.Level2;

public class Tile {
    public static void main(String[] args) {
        Tile sol = new Tile();
        int n = 4;
        int answer = sol.solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        int[] tile = new int[n + 1];
        tile[1] = 1;
        tile[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            tile[i] = (tile[i - 2] + tile[i - 1])%1000000007;
        }
        return tile[n];
    }
}
