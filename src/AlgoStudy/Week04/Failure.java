package AlgoStudy.Week04;

import java.util.Arrays;
import java.util.Comparator;

public class Failure {
    public static void main(String[] args) {
        int[] result = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        for(int i = 0; i <result.length; i++){
            System.out.print(result[i]);
        }
    }
    public static int[] solution(int N, int[] stages) {
        double[][] map = new double[N+1][3];
        for(int i = 0; i <= N; i++) map[i][1] = i;
        for(int v : stages){
            for(int i  = 0; i < v; i++){
                map[i][2]++;
            }
            map[v-1][0]++;

        }
        for(int i = 0; i < N; i++){
            map[i][0] /= map[i][2];
        }
        Arrays.sort(map, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o2[0] - o1[0] < 0) return -1;
                else if(o2[0] - o1[0] > 0) return 1;
                else return 0;
            }
        });
        int[] result = new int[N];
        int idx = 0;
        for(int i  =0; i <= N; i++){
            if(map[i][1] == N) continue;
            result[idx++] = (int)map[i][1] + 1;
        }
        return result;
    }
}
