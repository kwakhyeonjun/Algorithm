package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CodeTree22After01 {
    private static int n, m, time;
    private static boolean[][] map;
    private static List<Pos> baseCampList;
    private static List<Person> personList;
    private static List<Person> removeList;
    private static final int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {

        init();

        while(true) {
            time++;

            move();

            if(!baseCampList.isEmpty()) setPerson();

            if(personList.isEmpty()) break;
        }

        System.out.println(time);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new boolean[n][n];
        baseCampList = new ArrayList<>();
        personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(input[j]);
                if(cur == 1) baseCampList.add(new Pos(i, j));
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            personList.add(new Person(i + 1, new Pos(x, y)));
        }
    }

    /**
     * 격자에 있는 사람들이 본인이 가고 싶은 편의점 방향을 향해서 1 칸 움직입니다.
     * 최단거리로 움직이며 최단 거리로 움직이는 방법이 여러가지라면 ↑, ←, →, ↓ 의 우선 순위로 움직이게 됩니다.
     * 여기서 최단거리라 함은 상하좌우 인접한 칸 중 이동가능한 칸으로만 이동하여 도달하기까지 거쳐야 하는 칸의 수가 최소가 되는 거리를 뜻합니다.
     */
    private static void move() {
        removeList = new ArrayList<>();
        for (Person person : personList) {
            if(person.queue.isEmpty()) continue;
            person.move();
        }

        removeArrivedPerson();
    }

    private static void removeArrivedPerson() {
        for (Person person : removeList) {
            personList.remove(person);
        }
    }

    /**
     * 만약 편의점에 도착한다면 해당 편의점에서 멈추게 되고,
     * 이때부터 다른 사람들은 해당 편의점이 있는 칸을 지나갈 수 없게 됩니다.
     */
    private static void arrived(Person person, Pos goal) {
        map[goal.x][goal.y] = true;
        removeList.add(person);
    }

    /**
     * 현재 시간이 t분이고 t ≤ m를 만족한다면,
     * t번 사람은 자신이 가고 싶은 편의점과 가장 가까이 있는 베이스 캠프에 들어갑니다.
     * 여기서 가장 가까이에 있다는 뜻 역시 1에서와 같이 최단거리에 해당하는 곳을 의미합니다.
     * 가장 가까운 베이스캠프가 여러 가지인 경우에는 그 중 행이 작은 베이스캠프, 행이 같다면 열이 작은 베이스 캠프로 들어갑니다.
     * t번 사람이 베이스 캠프로 이동하는 데에는 시간이 전혀 소요되지 않습니다.
     *
     * 이때부터 다른 사람들은 해당 베이스 캠프가 있는 칸을 지나갈 수 없게 됩니다.
     * t번 사람이 편의점을 향해 움직이기 시작했더라도 해당 베이스 캠프는 앞으로 절대 지나갈 수 없음에 유의합니다.
     */
    private static void setPerson() {
        for (Person person : personList) {
            if(person.index > time) continue;
            if(!person.queue.isEmpty()) continue;

            Pos baseCamp = findBaseCamp(person);

            person.setBaseCamp(baseCamp);
            baseCampList.remove(baseCamp);
        }
    }

    private static Pos findBaseCamp(Person person) {
        int minDist = Integer.MAX_VALUE;
        Pos minBaseCamp = null;

        for (Pos baseCamp : baseCampList) {
            int curDist = getMinDist(baseCamp, person.goal);
            if(curDist == minDist) {
                if(minBaseCamp == null) continue;

                if(baseCamp.x == minBaseCamp.x) {
                    if(minBaseCamp.y > baseCamp.y) {
                        minBaseCamp = baseCamp;
                    }
                } else if (minBaseCamp.x > baseCamp.x) {
                    minBaseCamp = baseCamp;
                }
            } else if(minDist > curDist) {
                minBaseCamp = baseCamp;
                minDist = curDist;
            }
        }

        return minBaseCamp;
    }

    private static int getDist(Pos p1, Pos p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static int getMinDist(Pos start, Pos end) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start.x, start.y, 0});
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny]) continue;

                if(nx == end.x && ny == end.y) return cur[2] + 1;

                queue.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Person {
        int index;
        Pos goal;
        Queue<Pos> queue;
        int moveCount;
        boolean[][] visited;

        public Person(int index, Pos goal) {
            this.index = index;
            this.goal = goal;
            queue = new LinkedList<>();
            moveCount = 0;
            visited = new boolean[n][n];
        }

        public void setBaseCamp(Pos cur) {
            queue.offer(cur);
            moveCount++;
            visited[cur.x][cur.y] = true;
            map[cur.x][cur.y] = true;
        }

        /**
         * use BFS
         */
        public void move() {
            int mc = moveCount;
            moveCount = 0;
            for (int i = 0; i < mc && !queue.isEmpty(); i++) {
                Pos cur = queue.poll();

                for (int[] d : dir) {
                    int nx = cur.x + d[0];
                    int ny = cur.y + d[1];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny]) continue;

                    if(nx == goal.x && ny == goal.y) arrived(this, goal);

                    queue.offer(new Pos(nx, ny));
                    visited[nx][ny] = true;
                    moveCount++;
                }
            }
        }
    }
}