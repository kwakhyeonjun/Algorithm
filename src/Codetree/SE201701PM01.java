package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SE201701PM01 {
    private static final int TABLE_COUNT = 4, SEATS = 8, RIGHT_SEAT = 2, LEFT_SEAT = 6, TOP_SEAT = 0;
    private static final int[][] tables = new int[TABLE_COUNT][SEATS];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split;

        for (int i = 0; i < TABLE_COUNT; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < SEATS; j++) {
                tables[i][j] = Integer.parseInt(split[j]);
            }
        }

        int k = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            set.clear();
//            System.out.println("i = " + i);
            split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]) - 1;
            int d = Integer.parseInt(split[1]);

            queue.add(new int[]{n, d});
            set.add(n + " " + d);

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                int left = cur[0] - 1;
                int right = cur[0] + 1;
                int newD = turnD(cur[1]);
//                System.out.println("cur = [left = " + left + ", right = " + right + "]");

                if (left >= 0) {
//                    System.out.println("cur[LEFT_SEAT] = " + tables[cur[0]][LEFT_SEAT]);
//                    System.out.println("left[RIGHT_SEAT] = " + tables[left][RIGHT_SEAT]);
                    if (!set.contains(left + " " + newD) && tables[left][RIGHT_SEAT] != tables[cur[0]][LEFT_SEAT]) {
                        set.add(left + " " + newD);
                        queue.add(new int[]{left, newD});
                    }
                }
                if (right < TABLE_COUNT) {
//                    System.out.println("cur[RIGHT_SEAT] = " + tables[cur[0]][RIGHT_SEAT]);
//                    System.out.println("right[LEFT_SEAT] = " + tables[right][LEFT_SEAT]);
                    if (!set.contains(right + " " + newD) && tables[right][LEFT_SEAT] != tables[cur[0]][RIGHT_SEAT]) {
                        set.add(right + " " + newD);
                        queue.add(new int[]{right, newD});
                    }
                }
            }

            for (String cur : set) {
                split = cur.split(" ");
                n = Integer.parseInt(split[0]);
                d = Integer.parseInt(split[1]);

//                System.out.println("n = " + n);
//                System.out.println("d = " + d);

                rotate(n, d);
            }
        }

        int answer = calc();
        System.out.println(answer);
    }

    private static int calc() {
        int sum = 0;
        for (int i = 0; i < TABLE_COUNT; i++) {
            sum += Math.pow(2, i) * tables[i][TOP_SEAT];
        }

        return sum;
    }

    private static int turnD(int d) {
        if(d == 1) return -1;
        else return 1;
    }

    private static void rotate(int tableNo, int d) {
        if(d == 1) rotateRight(tableNo);
        else if(d == -1) rotateLeft(tableNo);
    }

    private static void rotateRight(int tableNo) {
        int[] newTable = new int[SEATS];

        for (int i = 0; i < SEATS; i++) {
            int next = (i + 1) % SEATS;
            newTable[next] = tables[tableNo][i];
        }

        tables[tableNo] = newTable;
    }

    private static void rotateLeft(int tableNo) {
        int[] newTable = new int[SEATS];

        for (int i = 0; i < SEATS; i++) {
            int next = (i + SEATS - 1) % SEATS;
            newTable[next] = tables[tableNo][i];
        }

        tables[tableNo] = newTable;
    }
}
