package AlgoStudy.Week08;

public class MatrixRotate {
    public static void main(String[] args) {
        MatrixRotate sol = new MatrixRotate();
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] res = sol.solution(6, 6, queries);
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

        int min = Integer.MAX_VALUE;
        int x = startX;
        int y = startY;
        int curDir = 0;
        while(curDir < 4){
            int nx = x + dir[curDir][0];
            int ny = y + dir[curDir][1];

            swap(map, x, y, nx, ny);
            min = Math.min(min, map[x][y]);

            // 주어진 범위의 끝에 도달한 경우
            if((nx != startX && ny == endY) ||
                (nx == endX && ny == 0)
            ) curDir++;

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
