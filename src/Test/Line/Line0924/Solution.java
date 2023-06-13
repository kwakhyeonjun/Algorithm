package Test.Line.Line0924;

public class Solution {
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int[][] answer = sol.solution(new String[]{"H.H", ".HX", "H.H"});
//        for (int i = 0; i < answer.length; i++) {
//            for (int j = 0; j < answer[0].length; j++) {
//                System.out.print(answer[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println(sol.solution(new int[][]{{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}}));
    }

//    public long[] solution(int[][] fees, int t) {
//        long[] answer = {};
//        return answer;
//    }

//    public int[][] solution(String[] wall) {
//        col = wall.length;
//        row = wall[0].length();
//        answer = new int[col][row];
//        map = new char[col][row];
//        for (int i = 0; i < col; i++) {
//            for (int j = 0; j < row; j++) {
//                map[i][j] = wall[i].charAt(j);
//                answer[i][j] = map[i][j] == '.' || map[i][j] == 'X' ? 0 : -1;
//            }
//        }
//        bfs(new int[]{col - 1, 0, 1});
//        return answer;
//    }
//
//    private void bfs(int[] pos) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(pos);
//        answer[pos[0]][pos[1]] = pos[2];
//
//        while(!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            int x = cur[0];
//            int y = cur[1];
//            int count = cur[2];
//
//            for(int i = 0; i < 4; i++) {
//                int nx = x + dir[i][0];
//                int ny = y + dir[i][1];
//
//                if(!isInMap(nx, ny)) continue;
//
//                if(map[nx][ny] == 'H' && (answer[nx][ny] == -1 || answer[nx][ny] > count + 1)) {
//                    queue.add(new int[]{nx, ny, count + 1});
//                    answer[nx][ny] = count + 1;
//                }
//            }
//            if(case01(x, y) && (answer[x][y + 2] == -1 || answer[x][y + 2] > count + 1)) {
//                queue.add(new int[]{x, y + 2, count + 1});
//                answer[x][y + 2] = count + 1;
//            }
//            if(case02(x, y) && (answer[x][y-2] == -1 || answer[x][y-2] > count + 1)) {
//                queue.add(new int[]{x, y - 2, count + 1});
//                answer[x][y - 2] = count + 1;
//            }
//            if(case03(x, y) && (answer[x][y+3] == -1 || answer[x][y+3] > count + 1)) {
//                queue.add(new int[]{x, y + 3, count + 1});
//                answer[x][y + 3] = count + 1;
//            }
//            if(case04(x, y) && (answer[x][y-3] == -1 || answer[x][y-3] > count + 1)) {
//                queue.add(new int[]{x, y - 3, count + 1});
//                answer[x][y - 3] = count + 1;
//            }
//            if(case05(x, y) && (answer[x-1][y+1] == -1 || answer[x - 1][y + 1] > count + 1)) {
//                queue.add(new int[]{x - 1, y + 1, count + 1});
//                answer[x - 1][y + 1] = count + 1;
//            }
//            if(case06(x, y) && (answer[x-1][y-1] == -1 || answer[x - 1][y - 1] > count + 1)) {
//                queue.add(new int[]{x - 1, y - 1, count + 1});
//                answer[x - 1][y - 1] = count + 1;
//            }
//            if(case07(x, y) && (answer[x - 2][y] == -1 || answer[x - 2][y] > count + 1)) {
//                queue.add(new int[]{x - 2, y, count + 1});
//                answer[x - 2][y] = count + 1;
//            }
//        }
//    }
//
//    private boolean case07(int x, int y) {
//        if(x - 2 < 0) return false;
//        return map[x - 1][y] == '.' && map[x - 2][y] == 'H';
//    }
//
//    private boolean case06(int x, int y) {
//        if(x - 1 < 0 || y - 1 > 0) return false;
//        for (int i = x - 1; i < x + 1; i++) {
//            for (int j = y - 1; j < y + 1; j++) {
//                if(i == x && j == y) continue;
//                if(i == x - 1 && j == y - 1 && map[i][j] == 'H') continue;
//                if(map[i][j] != '.') return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean case05(int x, int y) {
//        if(x - 1 < 0 || y + 1 < row - 1) return false;
//        for (int i = x - 1; i < x + 1; i++) {
//            for (int j = y; j < y + 1; j++) {
//                if(i == x && j == y) continue;
//                if(i == x - 1 && j == y + 1 && map[i][j] == 'H') continue;
//                if(map[i][j] != '.') return false;
//            }
//        }
//        return true;
//    }
//    private boolean case04(int x, int y) {
//        if(x - 1 < 0 || y < 3) return false;
//        for(int i = x - 1; i < x + 1; i++) {
//            for(int j = y - 3; j <= y; j++) {
//                if(i == x && j == y) continue;
//                if(i == x && j == y - 3 && map[i][j] == 'H') continue;
//                if(map[i][j] != '.') return false;
//            }
//        }
//        return true;
//    }
//    private boolean case03(int x, int y) {
//        if(x - 1 < 0 || y >= row - 3) return false;
//        for(int i = x - 1; i < x + 1; i++) {
//            for(int j = y; j < j + 3; j++) {
//                if(i == x && j == y) continue;
//                if(i == x && j == y + 3 && map[i][j] == 'H') continue;
//                if(map[i][j] != '.') return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean case02(int x, int y) {
//        if(x - 1 < 0 || y - 2 < 0) return false;
//        for(int i = x - 1; i < x + 1; i++) {
//            for(int j = y - 2; j <= y; j++) {
//                if(i == x && j == y) continue;
//                if(i == x && j == y - 2 && map[i][j] == 'H') continue;
//                if(map[i][j] != '.') return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean case01(int x, int y) {
//        if(x - 1 < 0 || y >= row - 2) return false;
//        for(int i = x - 1; i < x + 1; i++) {
//            for(int j = y; j < j + 2; j++) {
//                if(i == x && j == y) continue;
//                if(i == x && j == y + 2 && map[i][j] == 'H') continue;
//                if(map[i][j] != '.') return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean isInMap(int x, int y) {
//        return x >= 0 && x < col && y >= 0 && y < row;
//    }
//
//    int[][] answer;
//    char[][] map;
//    int col, row;
//
//    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
////    private int[][] dir = {{0, -2}, {0, 2}, {-2, 0}, {0, -3}, {0, 3}, {-1, 1}, {-1, -1}};
//    private String[][] pos = {{"...", "H.H"}, {"....", "H..H"}, {"H", ".", "H"}, {".H", "H."}, {"H.", ".H"}};
//

//    public long[][] solution(int n, int m, int[][] fires, int[][] ices) {
//
//        long[][] map = new long[n][n];
//
//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//
//                for(int[] fire : fires) {
//                    long dist = Math.max(Math.abs(fire[0] - 1 - i), Math.abs(fire[1] - 1 - j));
//                    if(dist > m) continue;
//                    if(dist == 0) map[i][j] -= 1;
//                    map[i][j] += m - dist + 1;
//                }
//
//                for(int[] ice : ices) {
//                    long dist = Math.abs(ice[0] - 1 - i) + Math.abs(ice[1] - 1 - j);
//                    if(dist > m) continue;
//                    if(dist == 0) map[i][j] += 1;
//                    map[i][j] += dist - m - 1;
//                }
//            }
//        }
//
//        return map;
//    }

//    public String solution(int k, String[] dic, String chat) {
//
//        StringBuilder sb = new StringBuilder();
//
//        for(String cur : chat.split(" ")) {
//            int length = cur.length();
//            String reg = cur.replace(".", ".{1," + k +"}");
//
//            for(String word : dic) {
//                if(word.matches(reg)) {
//                    cur = cur.replace(cur, getReplaceWord(length));
//                    break;
//                }
//            }
//            sb.append(cur).append(" ");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        return sb.toString();
//    }
//
//    private String getReplaceWord(int size) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("#".repeat(Math.max(0, size)));
//        return sb.toString();
//    }

//    public int solution(int[][] queries) {
//        int answer = 0;
//
//        Map<Integer, int[]> map = new HashMap<>();
//
//        for(int[] query : queries) {
//            int key = query[0];
//            int value = query[1];
//
//            int[] curValue = map.getOrDefault(key, new int[]{0, 0});
//            int newSize = getSize(curValue[1], value);
//            if(newSize != curValue[0]) answer += curValue[1];
//            map.put(key, new int[]{newSize, curValue[1] + value});
//        }
//
//        return answer;
//    }
//
//    private int getSize(int cur, int add) {
//        int ret = 1;
//        int count = 0;
//        while(ret < cur + add) {
//            ret = (int) Math.pow(2, count++);
//        }
//        return ret;
//    }
//}
