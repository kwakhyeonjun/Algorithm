package AlgoStudy.Week08;

public class MatrixRotate {
    public static void main(String[] args) {
        MatrixRotate sol = new MatrixRotate();
        int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        int[] res = sol.solution(3, 3, queries);
        for(int v : res){
            System.out.println(v + " ");
        }
    }

    public int[] solution(int rows, int columns, int[][] queries){
        int[][] map = new int[rows][columns];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = ++idx;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(map, queries[i]);
        }
        return answer;
    }

    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int rotate(int[][] map, int[] query){
        int startX = query[0]-1;
        int startY = query[1]-1;
        int endX = query[2]-1;
        int endY = query[3]-1;

        int x = startX;
        int y = startY;
        int min = map[x][y];
        int curDir = 0;
        int xCount = 1, yCount = 1;

        while(true){
            int nx = x + dir[curDir][0];
            int ny = y + dir[curDir][1];

            if(nx == startX && ny == startY) break;

            swap(map, x, y, nx, ny);
            min = Math.min(min, map[x][y]);

            if(curDir == 1 || curDir == 3){
                yCount++;
            }else{
                xCount++;
            }

            // 주어진 범위의 끝에 도달한 경우
            if(xCount == endX - startX + 1 || yCount == endY - startY + 1) {
                xCount = 1;
                yCount = 1;
                curDir++;
            }

            x = nx;
            y = ny;
        }
        return min;
    }

    private static void swap(int[][] map, int x1, int y1, int x2, int y2){
        int temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }
}
