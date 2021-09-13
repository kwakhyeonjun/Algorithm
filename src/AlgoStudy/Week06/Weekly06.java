package AlgoStudy.Week06;

import java.util.Arrays;
import java.util.Comparator;

public class Weekly06 {
    public static void main(String[] args) {
        Weekly06 cur = new Weekly06();
//        int[] weights = {50,82,75,120};
        int[] weights = {60, 70, 60};
//        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
        String[] head2head = {"NNN", "NNN", "NNN"};

        int[] result = cur.solution(weights, head2head);
        for(int i : result) System.out.println(i);
    }

    /**
     * 복서의 순서 정렬하기
     * 1. 전체 승률이 높은 복서의 번호가 앞쪽으로. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%
     * 2. 승률이 같은 복서의 번호들 중 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로
     * 3. 자신보다 무거운 복서를 이긴 횟수까지 같으면 자신의 몸무게가 무거운 사람이 앞으로
     * 4. 모두 같으면 작은 번호가 앞으로
     * @param weights
     * @param head2head
     * @return
     */
    public int[] solution(int[] weights, String[] head2head) {

        int length = weights.length;

        double[] winRate = new double[length];
        int[] heavyWin = new int[length];

        for(int i = 0; i < length; i++){
            int winCount = 0;
            int heavyCount = 0;
            int countAll = length;
            for(int j = 0; j < length; j++){
                if(head2head[i].charAt(j) == 'W') {
                    winCount++;
                    if(weights[i] < weights[j]) heavyCount++;
                }
                if(head2head[i].charAt(j) == 'N') countAll--;
            }
            winRate[i] = winCount == 0 ? 0 : (double)winCount/countAll;
            heavyWin[i] = heavyCount;
        }

        double[][] records = new double[length][4];
        int index = 1;
        for(int i = 0; i < length; i++){
            records[i] = new double[]{index++, winRate[i], heavyWin[i], weights[i]};
        }

        for(int i = 0; i < length; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(records[i][j] + " ");
            }
            System.out.println();
        }

        Arrays.sort(records, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[1] == o2[1]){
                    if(o1[2] == o2[2]){
                        if(o1[3] == o2[3]){
                            return (int)(o1[0] - o2[0]);
                        }else return (int)(o2[3] - o1[3]);
                    }else return (int)(o2[2] - o1[2]);
                }else return (int)(o2[1]*1000000000 - o1[1]*1000000000);
            }
        });

        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[i] = (int)records[i][0];
        }
        return answer;
    }
}
