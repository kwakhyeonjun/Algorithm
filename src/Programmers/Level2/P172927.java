package Programmers.Level2;

import java.util.*;

public class P172927 {
    public static void main(String[] args) {
        P172927 sol = new P172927();
        int[] picks = {0, 1, 1};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        int answer = sol.solution(picks, minerals);
        System.out.println(answer);
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        List<Mining> miningList = new ArrayList<>();
        rocks = new HashMap<>();
        rocks.put("diamond", 0);
        rocks.put("iron", 1);
        rocks.put("stone", 2);

        int pickSum = 0;
        for (int pick : picks) {
            pickSum += pick;
        }

        for (int i = 0; i < minerals.length && i < pickSum * 5; i += 5) {
            Mining mining = new Mining();

            for (int j = i; j < i + 5 && j < minerals.length && j < pickSum * 5; j++) {
                mining.add(rocks.get(minerals[j]));
            }

            mining.setSum();
            miningList.add(mining);
        }

        miningList.sort((o1, o2) -> o2.sum - o1.sum);

        int index = 0;

        for (Mining mining : miningList) {
            while(index < 3 && picks[index] == 0) index++;
            if(index >= 3) break;

            for (Integer mineral : mining.minerals) {
                answer += tired[index][mineral];
            }
            --picks[index];
        }

        return answer;
    }

    private Map<String, Integer> rocks;
    private static int[][] tired = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    static class Mining {
        int sum;

        List<Integer> minerals;

        Mining() {
            minerals = new ArrayList<>();
        }

        void add(int mineral) {
            minerals.add(mineral);
        }

        void setSum() {
            sum = 0;
            for (Integer mineral : minerals) {
                sum += tired[2][mineral];
            }
        }
    }
}
