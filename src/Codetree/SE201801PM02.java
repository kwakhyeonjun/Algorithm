package Codetree;

import java.util.*;
import java.io.*;

public class SE201801PM02 {
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int n, m, answer;
    private static List<int[]> person, hospital;
    private static int[] picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        answer = Integer.MAX_VALUE;

        person = new ArrayList<>();
        hospital = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            split = br.readLine().split(" ");

            for(int j = 0; j < n; j++) {
                int cur = Integer.parseInt(split[j]);

                if(cur == 1) person.add(new int[]{i, j});
                else if(cur == 2) hospital.add(new int[]{i, j});
            }
        }

        picked = new int[m];
        pickedList = new ArrayList<>();

        comb(0, 0);

        System.out.println(answer);
    }

    private static List<int[]> pickedList;

    private static void calc() {
        setPicked();

        int sum = 0;

        for (int[] p : person) {
            int min = Integer.MAX_VALUE;
            for (int[] h : pickedList) {
                min = Math.min(min, getDist(p, h));
            }
            sum += min;
        }

        answer = Math.min(answer, sum);
    }

    private static void setPicked() {
        pickedList.clear();
        for(int i = 0; i < m; i++) {
            pickedList.add(hospital.get(picked[i]));
        }
    }

    private static void comb(int start, int count) {
        if(count == m) {
            calc();
            return;
        }
        for(int i = start; i < hospital.size(); i++) {
            picked[count] = i;
            comb(i + 1, count + 1);
        }
    }

    private static int getDist(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }
}