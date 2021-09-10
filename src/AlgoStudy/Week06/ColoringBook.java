package AlgoStudy.Week06;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {

    public static void main(String[] args) {

        int[] sol = solution(6, 4,new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println(sol[0] + "," + sol[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;


        boolean[][] visited = new boolean[m][n];


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, visited, i, j));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }



    private static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우 하 좌 상
    public static int bfs(int[][] picture, boolean[][] visited, int x, int y){
        int m = picture.length;
        int n = picture[0].length;
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && picture[nx][ny] == picture[x][y] && !visited[nx][ny]){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
