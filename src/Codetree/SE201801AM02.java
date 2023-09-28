package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SE201801AM02 {

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int MAX_N = 10, MAX_H = 30;
    private static boolean[][] map = new boolean[MAX_H][MAX_N - 1];
    private static boolean[][] tempMap = new boolean[MAX_H][MAX_N - 1];

    private static int n, m, h, answer = -1;
    private static List<Pos> emptyLines = new ArrayList<>();
    private static List<Pos> lines = new ArrayList<>();
    private static int[] picked = new int[3];

    private static boolean move(int start) {
        int cur = start;
        for(int i = 0; i < h; i++) {
            if(cur - 1 >= 0 && tempMap[i][cur - 1]) cur--;
            else if(cur < n - 1 && tempMap[i][cur]) cur++;
        }
        if(cur == start) return true;
        else return false;
    }

    private static boolean validateLines() {
        for(int i = 0; i < n; i++) {
            if(!move(i)) return false;
        }
        return true;
    }

    private static boolean setPickedLines(int count) {
        for(int i = 0; i < count; i++) {
            Pos cur = emptyLines.get(picked[i]);
            if(cur.y - 1 >= 0 && map[cur.x][cur.y - 1]) return false;
            if(cur.y < n - 1 && map[cur.x][cur.y]) return false;

            tempMap[cur.x][cur.y] = true;
        }
        return true;
    }

    private static void setLines() {
        for(Pos cur : lines) {
            tempMap[cur.x][cur.y] = true;
        }
    }

    private static void clearTempMap() {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n - 1; j++) {
                tempMap[i][j] = false;
            }
        }
    }

    private static boolean simulation(int count) {
        clearTempMap();
        setLines();

        if(!setPickedLines(count)) return false;

        if(!validateLines()) return false;

        return true;
    }

    private static void comb(int start, int count) {
        if(simulation(count)) {
            if(answer == -1) answer = count;
            else answer = Math.min(answer, count);
            return;
        }
        if(count >= 3) return;
        for(int i = start; i < emptyLines.size(); i++) {
            picked[count] = i;
            comb(i + 1, count + 1);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;

            map[a][b] = true;
            lines.add(new Pos(a, b));
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(!map[i][j]) emptyLines.add(new Pos(i, j));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        comb(0, 0);
        System.out.println(answer);
    }
}
