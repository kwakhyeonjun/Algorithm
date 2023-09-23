package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE20160201 {
    private static final int MAX_N = 20, MAX_M = 20, MAX_K = 1000;
    private static final int[][] map = new int[MAX_N][MAX_M];
    private static final int[] move = new int[MAX_K];
    private static int[] dice = new int[6]; // 0: 위, 1: 아래, 2: 앞, 3: 뒤, 4: 왼, 5: 오
    private static int n, m, x, y, k;
    private static boolean rollFlag;

    public static void main(String[] args) throws IOException {
        init();

        for(int i = 0; i < k; i++) {
//			System.out.println("roll = " + i);
            roll(move[i]);
//			printMap();
//			System.out.println("x = " + x + ", y = " + y);
//			printDice();
            if(!rollFlag) continue;
//			System.out.print("output: ");
            System.out.println(dice[0]);
        }
    }

    private static void printDice() {
        System.out.println("dice: ");
        for(int i = 0; i < 6; i++) {
            System.out.println(dice[i] + " ");
        }
    }

    private static void printMap() {
        System.out.println("map: ");
        for(int i = 0;i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rollSouth() {
        if(x + 1 >= n) {
            rollFlag = false;
            return;
        }
        x++;
        int[] newDice = new int[6];
        newDice[0] = dice[3];
        newDice[1] = dice[2];
        newDice[2] = dice[0];
        newDice[3] = dice[1];
        newDice[4] = dice[4];
        newDice[5] = dice[5];
        dice = newDice;
    }

    private static void rollNorth() {
        if(x - 1 < 0) {
            rollFlag = false;
            return;
        }
        x--;
        int[] newDice = new int[6];
        newDice[0] = dice[2];
        newDice[1] = dice[3];
        newDice[2] = dice[1];
        newDice[3] = dice[0];
        newDice[4] = dice[4];
        newDice[5] = dice[5];
        dice = newDice;
    }

    private static void rollWest() {
        if(y - 1 < 0) {
            rollFlag = false;
            return;
        }
        y--;
        int[] newDice = new int[6];
        newDice[0] = dice[5];
        newDice[1] = dice[4];
        newDice[2] = dice[2];
        newDice[3] = dice[3];
        newDice[4] = dice[0];
        newDice[5] = dice[1];
        dice = newDice;
    }

    private static void rollEast() {
        if(y + 1 >= m) {
            rollFlag = false;
            return;
        }
        y++;
        int[] newDice = new int[6];
        newDice[0] = dice[4];
        newDice[1] = dice[5];
        newDice[2] = dice[2];
        newDice[3] = dice[3];
        newDice[4] = dice[1];
        newDice[5] = dice[0];
        dice = newDice;
    }

    private static void roll(int m) {
        rollFlag = true;
        switch(m) {
            case 1: // 동
                rollEast();
                break;
            case 2: // 서
                rollWest();
                break;
            case 3: // 북
                rollNorth();
                break;
            case 4: // 남
                rollSouth();
                break;
        }

        if(!rollFlag) return;

        if(map[x][y] == 0) map[x][y] = dice[1];
        else {
            dice[1] = map[x][y];
            map[x][y] = 0;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        k = Integer.parseInt(input[4]);

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        for(int i = 0; i <  k; i++) {
            move[i] = Integer.parseInt(input[i]);
        }
    }
}
