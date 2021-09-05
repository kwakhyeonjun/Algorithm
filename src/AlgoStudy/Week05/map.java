package AlgoStudy.Week05;

public class map {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] map = new boolean[n][n];
        for(int i = 0; i < n ; i++){
            for (int j = n-1; j >= 0; j--) {
                if(arr1[i]%2==1) map[i][j] = true;
                if(arr2[i]%2==1) map[i][j] = true;
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
        }


        String[] result = new String[n];
        for(int i = 0; i < n; i++){
            result[i] = "";
            for (int j = 0; j < n; j++) {
                if(map[i][j]) result[i] += "#";
                else result[i] += " ";
            }
        }

        return result;
    }
}
