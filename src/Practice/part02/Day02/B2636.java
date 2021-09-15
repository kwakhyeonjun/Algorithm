package Practice.part02.Day02;

import java.util.*;

public class B2636 {

    private static int height, width;
    private static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();

        map = new boolean[height][width];


        for(int x = 0; x < height; x++){
            for(int y = 0; y < width; y++){
                map[x][y] = sc.nextInt() != 0;
            }
        }

        int count = 0;
        int prevCheese = 0;
        while(true){ // TODO
            visited = new boolean[height][width];
            // if) map[x][y] = false인데 visited[x][y] = true라면, 바깥부분으로 생각할 수 있음.
            setBackgroundByDFS();
            int curCheese = getCurCheese();
            if(curCheese == 0) break;
            prevCheese = curCheese;
            count++;
            melt = new ArrayList<>();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(map[i][j] && !visited[i][j]) dfs(i, j, false);
                }
            }
            for(int[] curMelt : melt) map[curMelt[0]][curMelt[1]] = false;
        }

        System.out.println(count);
        System.out.println(prevCheese);
    }

    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우 하 좌 상
    private static boolean[][] visited;
    private static List<int[]> melt;

    // 주변이 모두 1로 둘러쌓여있으면 안들어감.
    private static void dfs(int x, int y, boolean isZero){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        if(!isZero) melt.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int dirIndex = 0; dirIndex < 4; dirIndex++){
                int nx = current[0] + dir[dirIndex][0];
                int ny = current[1] + dir[dirIndex][1];
                if(isInMap(nx, ny) && map[nx][ny] == !isZero && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    if(!isZero && isInCheese(nx, ny)){
                        melt.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static boolean isInCheese(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(!map[nx][ny] && visited[nx][ny]) return true;
        }
        return false;
    }

    private static boolean isInMap(int x, int y){
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    private static void setBackgroundByDFS(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(!map[i][j]){
                    dfs(i, j, true);
                    return;
                }
            }

        }
    }

    private static int getCurCheese(){
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(map[i][j]) count++;
            }
        }
        return count;
    }
}
