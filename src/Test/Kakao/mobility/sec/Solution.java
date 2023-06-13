package Test.Kakao.mobility.sec;

public class Solution {
//    public static void main(String[] args) {
//        int[][] edges = {
//                {1, 2, 2}, {5, 2, 2}, {1, 5, 2}, {1, 3, 1}, {1, 6, 2}, {1, 7, 3}, {6, 7, 4}, {7, 4, 1}};
//        int[] users = {0, 2, 0, 0, 0, 4, 1};
//        Solution sol = new Solution();
//        System.out.println(sol.solution(7, edges, users, 2, 3));
//    }
//    public int solution(int[][] infos, int m) {
//        int answer = Integer.MAX_VALUE;
//        int[] answers = new int[4];
//        answers[0] = car(infos);
//        answers[1] = bike(infos, m);
//        answers[2] = bus(infos, m);
//        answers[3] = walk(infos, m);
//        for(int ans : answers) {
//            if(ans == -1) continue;
//            answer = Math.min(ans, answer);
//        }
//        return answer;
//    }
//
//    /**
//     * 자동차롬 이동하는 경우, 모두 자동차로 이동해야함.
//     * @param infos info[0] = 자동차 소요시간
//     * @return 자동차만으로 이동한 시간
//     */
//    private int car(int[][] infos) {
//        int res = 0;
//        for(int[] info : infos) {
//            res += info[0];
//        }
//        return res;
//    }
//
//    /**
//     * 자전거로 이동하는 경우, 구간별로 자전거나 도보로 이동할 수 있음.
//     * @param infos info[1] = 자전거 소요시간, info[3] = 도보 소요시간
//     * @param m 도보로 연속해서 이동할 수 있는 최대 시간
//     * @return 자전거 + 도보로 이동한 시간
//     */
//    private int bike(int[][] infos, int m) {
//        int res = 0;
//        int walk = 0;
//        for(int[] info : infos) {
//            if(walk + info[3] > m) { // 다음 구간에서 걸을 수 없는 경우
//                res += info[1];
//                walk = 0;
//            } else { // 다음 구간에서 걸을 수 있는 경우
//                if(info[3] < info[1]) { // 걷는 것이 더 빠를 때
//                    res += info[3];
//                    walk += info[3];
//                } else { // 자전거가 더 빠를 때
//                    res += info[1];
//                    walk = 0;
//                }
//            }
//        }
//        return res;
//    }
//
//    /**
//     * 대중교통으로 이동하는 경우, 구간별로 대중교통이나 도보로 이동할 수 있음.
//     * 단, 대중교통을 이용할 수 없는 경우 반드시 도보로 이동
//     * @param infos info[2] = 대중교통 소요 시간
//     * @return 대중교통으로 이동한 최소시간
//     */
//    private int bus(int[][] infos, int m) {
//        int res = 0;
//        int walk = 0;
//        for(int[] info : infos) {
//            if(walk + info[3] > m && info[2] == -1) { // 최적화 필요
//                return -1;
//            } else if(walk + info[3] > m) { // 대중교통 이용
//                walk = 0;
//                res += info[2];
//            } else if(info[2] == -1) { // 걸어서 이동
//                walk += info[3];
//                res += info[3];
//            }
//        }
//        return res;
//    }
//
//    private int walk(int[][] infos, int m) {
//        int res = 0;
//        for(int[] info : infos) {
//            res += info[3];
//        }
//        return res > m ? -1 : res;
//    }


//    private int[][] map;
//    int[] users;
//    private int d, n, limit, answer;
//
//    public int solution(int n, int[][] edges, int[] users, int d, int limit) {
//        answer = 0;
//
//        init(n, edges, users, d, limit);
//        comb();
//
//        return answer;
//    }
//
//    /**
//     * 값 초기화
//     * @param n
//     * @param edges
//     * @param users
//     * @param d
//     * @param limit
//     */
//    private void init(int n, int[][] edges, int[] users, int d, int limit) {
//        map = new int[n][n];
//        this.users = users;
//        this.d = d;
//        this.n = n;
//        this.limit = limit;
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                if(i == j) continue;
//                map[i][j] = Integer.MAX_VALUE;
//            }
//        }
//        for(int[] edge : edges) {
//            map[edge[0] - 1][edge[1] - 1] = edge[2];
//            map[edge[1] - 1][edge[0] - 1] = edge[2];
//        }
//    }
//
//    /**
//     * 선택할 값이 2개로 고정되어 있으므로 2중 for문을 통해 장소 선택
//     */
//    private void comb() {
//        for(int i = 0; i < n; i++) {
//            for(int j = i + 1; j < n; j++) {
//                int[] parking = new int[n];
//                parking[i] = limit;
//                parking[j] = limit;
//                find(parking);
//            }
//        }
//    }
//
//    boolean[] visited;
//
//    /**
//     * 선택된 위치를 바탕으로 유저가 최대 몇개의 바이크를 사용할 수 있는 유저의 수를 확인
//     * 이때 최소 유저가 존재하는 장소부터 검색한다.
//     * @param parking 현재 파킹존의 바이크 개수. parking.length = n
//     */
//    private void find(int[] parking) {
//        visited = new boolean[n];
//        for(int t = 0; t < n; t++) {
//            // 최소인 위치 찾기
//            int idx = getMinIdx();
//            if(idx == -1) break; // 방문하지 않았고, 최소인 장소가 없다면 멈춤
//            visited[idx] = true;
//            bfs(parking, idx); // 최소인 장소에서 사용할 수 있는 파킹존을 탐색
//        }
//        int curAnswer = 2 * limit;
//        for(int park : parking) {
//            curAnswer -= park;
//        }
//        answer = Math.max(curAnswer, answer);
//    }
//
//    /**
//     * start에서 bfs 탐색하여 사용자가 사용할 수 있는 파킹존을 검색한다.
//     * 이때 사용 가능한 파킹존이 있다면 해당 파킹존(parking)의 수를 해당 크기만큼 줄인다.
//     * @param parking 현재 파킹존의 바이크 개수
//     * @param start 탐색을 시작하는 위치
//     */
//    private void bfs(int[] parking, int start) {
//        boolean[] visited = new boolean[n];
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{start, users[start], 0});
//        // 시작 위치, 사용자 수, 현재 이동 거리
//
//        while(!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            for(int i = 0; i < n; i++) {
//                if(visited[i]) continue;
//                if(map[cur[0]][i] + cur[2] > d) continue;
//                if(map[cur[0]][i] <= cur[1]) {
//                    int next = Math.max(cur[1] - parking[i], 0);
//                    parking[i] = Math.max(parking[i] - cur[1], 0);
//                    queue.add(new int[]{i, next, cur[2] + map[cur[0]][i]});
//                    visited[i] = true;
//                }
//            }
//        }
//    }
//
//    /**
//     * 가장 적은 유저가 있는 장소 탐색
//     * @return 가장 적은 유저가 있는 장소 (i - 1)
//     */
//    private int getMinIdx() {
//        int min = Integer.MAX_VALUE;
//        int idx = -1;
//        for(int i = 0; i < n; i++) {
//            if(visited[i] || users[i] == 0) continue; // 이미 방문한 경우 혹은 유저가 없는 경우
//            if(min > users[i]) {
//                idx = i;
//                min = users[i];
//            }
//        }
//        return idx;
//    }

//    private int[] getNeeds() {
//        for(int i = 0; i < n; i++) {
//            int[] needs = new int[n];
//            if(users[i] == 0) continue;
//            findPath(needs, i);
//
//        }
//        return needs;
//    }
//
//    private void findPath(int[] needs, int start) {
//        Queue<int[]> queue = new LinkedList<>();
//        boolean[] visited = new boolean[n];
//        queue.add(new int[]{start, d});
//        visited[start] = true;
//        needs[start] += users[start];
//        while(!queue.isEmpty()) {
//            int[] cur = queue.poll();
//
//            for(int i = 0; i < n; i++) {
//                if(visited[i]) continue;
//                if(map[cur[0]][i] <= cur[1]) {
//                    queue.add(new int[]{i, cur[1] - map[cur[0]][i]});
//                    visited[i] = true;
//                    needs[i] += users[start];
//                }
//            }
//        }
//    }
}
