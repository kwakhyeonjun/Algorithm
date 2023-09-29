package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SE201802PM01 {

    private static final int MAX_N = 10;
    private static final int[][] eatMap = new int[MAX_N][MAX_N];
    private static final int[][] map = new int[MAX_N][MAX_N];
    private static final List<Virus> virusList = new ArrayList<>();
    private static final List<Virus> nextVirusList = new ArrayList<>();
    private static final List<Virus> deadVirusList = new ArrayList<>();
    private static final int[][] dir = {{1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};

    private static int n;
    private static int k;

    static class Virus {
        int x;
        int y;
        int age;

        public Virus(int x, int y, int age) {
            super();
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    /**
     * 1, 2, 3 과정이 순서대로 끝난 뒤에는 주어진 양분의 양에 따라 칸에 양분이 추가됩니다.
     */

    private static void feed() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] += eatMap[i][j];
            }
        }
    }

    /**
     * 이후 바이러스가 번식을 진행합니다.
     * 번식은 5의 배수의 나이를 가진 바이러스에게만 진행되며, 인접한 8개의 칸에 나이가 1인 바이러스가 생깁니다.
     * 이는 상하좌우와 대각선으로 인접한 8칸을 뜻하고, 배지 범위를 벗어난 곳에는 바이러스가 번식하지 않습니다.
     */
    private static void breeding() {
        List<Virus> list = new ArrayList<>();
        for(Virus virus : virusList) {
            if(virus.age % 5 != 0) continue;
            for(int i = 0; i < 8; i++) {
                int nx = virus.x + dir[i][0];
                int ny = virus.y + dir[i][1];

                if(isOutRange(nx, ny)) continue;

                list.add(new Virus(nx, ny, 1));
            }
        }

        virusList.addAll(list);
    }

    /**
     * 모든 바이러스가 섭취를 끝낸 후 죽은 바이러스가 양분으로 변합니다.
     * 죽은 바이러스마다 나이를 2로 나눈 값이 바이러스가 있던 칸에 양분으로 추가됩니다.
     * 편의를 위해 소숫점 아래는 버립니다.
     */
    private static void dead(Virus virus) {
//		System.out.println("virus dead: x = " + virus.x + ", y = " + virus.y);
        map[virus.x][virus.y] += virus.age / 2;
    }

    /**
     * 각각의 바이러스는 본인이 속한 1 * 1 크기의 칸에 있는 양분을 섭취합니다.
     * 본인의 나이만큼 양분을 섭취하며,
     * 같은 칸에 여러 개의 바이러스가 있을 때에는 나이가 어린 바이러스부터 양분을 섭취합니다.
     * 양분을 섭취한 바이러스는 나이가 1 증가합니다.
     * 만약 양분이 부족하여 본인의 나이만큼 양분을 섭취할 수 없다면 그 즉시 죽습니다.
     */
    private static void eat(Virus virus) {
        int x = virus.x;
        int y = virus.y;

//		System.out.println("eat: x = " + x + ", y = " + y + ", age = " + virus.age);

        if(map[x][y] < virus.age) {
//			System.out.println("add dead");
            deadVirusList.add(virus);
            return;
        }
        map[x][y] -= virus.age;
        virus.age++;
        nextVirusList.add(virus);
    }

    private static void experiment() {
        virusList.sort(Comparator.comparingInt(o -> o.age));

        for(Virus virus : virusList) {
            eat(virus);
        }

        for(Virus virus : deadVirusList) {
            dead(virus);
        }
        deadVirusList.clear();
        virusList.clear();
        virusList.addAll(nextVirusList);
        nextVirusList.clear();

        breeding();
        feed();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                eatMap[i][j] = Integer.parseInt(input[j]);
                map[i][j] = 5;
            }
        }

        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]) - 1;
            int c = Integer.parseInt(input[1]) - 1;
            int age = Integer.parseInt(input[2]);
            virusList.add(new Virus(r, c, age));
        }
    }

    public static void main(String[] args) throws IOException{
        init();

        for(int t = 0; t < k; t++) {
            experiment();
        }

        System.out.println(virusList.size());
    }
}
