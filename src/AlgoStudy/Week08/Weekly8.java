package AlgoStudy.Week08;

public class Weekly8 {
    public int solution(int[][] sizes){
        int maxW = 0;
        int maxH = 0;
        for (int[] card : sizes) {
            int min = Math.min(card[0], card[1]);
            int max = Math.max(card[0], card[1]);

            maxW = Math.max(maxW, min);
            maxH = Math.max(maxH, max);
        }
        return maxH * maxW;
    }
}
