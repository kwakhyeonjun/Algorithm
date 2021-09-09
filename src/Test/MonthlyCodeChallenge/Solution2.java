package Test.MonthlyCodeChallenge;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SL","LR"}));
    }

    static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우, 하, 좌, 상 (오른쪽)
    static class Node {
        boolean[] in = new boolean[4];
        char s;

        Node(char s){
            this.s = s;
        }
    }

    public static int[] solution(String[] grid) {
        Node[][] map = new Node[grid.length][grid[0].length()];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                map[i][j] = new Node(grid[i].charAt(j));
            }
        }

        Node[][] newMap = copyMap(map);
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                for(int k = 0; k < 4; k++){
                    Node[][] tempMap = copyMap(newMap);
                    if(!map[i][j].in[k]) dfs(map, tempMap, new int[]{i, j}, k, 0);
                }
            }
        }
        int[] answer = new int[reuslt.size()];
        int idx = 0;
        for(int v : reuslt) answer[idx++] = v;
        return answer;
    }

    public static Node[][] copyMap(Node[][] map){
        Node[][] tempMap = new Node[map.length][map[0].length];
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        return tempMap;
    }

    static List<Integer> reuslt = new ArrayList<>();
    public static void dfs(Node[][] map, Node[][] cur, int[] startNode, int startDir, int count){
        int x = startNode[0];
        int y = startNode[1];
        if(cur[x][y].in[startDir]) {
            reuslt.add(count);
            return;
        }
        map[x][y].in[startDir] = true;
        cur[x][y].in[startDir] = true;
        int[] nextNode = new int[2];
        int nextDir = 0;
        if(cur[x][y].s == 'S'){
            nextDir = startDir;
        }else if(cur[x][y].s == 'R'){
            nextDir = (startDir + 1)%4;
        }else{
            if(startDir == 0) startDir = 4;
            nextDir = (startDir - 1)%4;
        }
        int nx = x + dir[nextDir][0];
        int ny = y + dir[nextDir][1];

        if(nx < 0) nx = map.length-1;
        if(nx >= map.length) nx = 0;
        if(ny < 0) ny = map[0].length - 1;
        if(ny >= map[0].length) ny = 0;
        nextNode = new int[]{nx, ny};

        dfs(map, cur, nextNode, nextDir, count+1);
    }
}
