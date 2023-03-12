package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Battleground {

    private static int n, m ,k;
    private static Board[][] board;
    private static List<Player> players;
    private static int[][] playerMap;
    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        init();

        for (int round = 0; round < k; round++) {
            for (int i = 1; i <= m; i++) {
                setPlayer(players.get(i));
            }
        }

        for (int i = 1; i <= m; i++) {
            System.out.print(players.get(i).point + " ");
        }
    }

    /**
     *  1 - 1. 첫 번째 플레이어부터 순차적으로 본인이 향하고 있는 방향대로 한 칸만큼 이동합니다. 만약 해당 방향으로 나갈 때 격자를 벗어나는 경우에는 정반대 방향으로 방향을 바꾸어서 1만큼 이동합니다.
     */
    private static void setPlayer(Player player) {
        movePlayer(player, false);

        // case) 해당 칸에 플레이어가 있는지 확인
        int prevPlayerIndex = playerMap[player.x][player.y];
        // 2 - 1. 플레이어가 없는 경우
        if(prevPlayerIndex == 0) {
            takeGunOnBoard(player);
        }
        // 2 - 2. 플레이어가 있는 경우
        else {
            fight(players.get(prevPlayerIndex), player);
            setPlayerMap(players.get(prevPlayerIndex));
        }

        setPlayerMap(player);
    }

    private static void setPlayerMap(Player player) {
        playerMap[player.x][player.y] = players.indexOf(player);
    }

    /**
     * 2-2-1. 만약 이동한 방향에 플레이어가 있는 경우에는 두 플레이어가 싸우게 됩니다.
     * 해당 플레이어의 초기 능력치와 가지고 있는 총의 공격력의 합을 비교하여 더 큰 플레이어가 이기게 됩니다.
     * 만일 이 수치가 같은 경우에는 플레이어의 초기 능력치가 높은 플레이어가 승리하게 됩니다.
     * 이긴 플레이어는 각 플레이어의 초기 능력치와 가지고 있는 총의 공격력의 합의 차이만큼을 포인트로 획득하게 됩니다.
     */
    private static void fight(Player prev, Player cur) {
        boolean curWin = isCurWin(prev, cur);

        // cur이 이긴 경우
        if(curWin) {
            cur.point += getPoint(cur, prev);
            setLoser(prev);
            setWinner(cur);
        }
        // prev가 이긴 경우
        else {
            prev.point += getPoint(prev, cur);
            setLoser(cur);
            setWinner(prev);
        }
    }

    private static int getPoint(Player winner, Player loser) {
        return winner.gun + winner.s - loser.gun - loser.s;
    }

    /**
     * 2-2-3. 이긴 플레이어는 승리한 칸에 떨어져 있는 총들과 원래 들고 있던 총 중 가장 공격력이 높은 총을 획득하고, 나머지 총들은 해당 격자에 내려 놓습니다.
     * @param player winner
     */
    private static void setWinner(Player player) {
        PriorityQueue<Integer> guns = board[player.x][player.y].guns;
        if(player.gun != 0) guns.add(player.gun);
        Integer cur = guns.poll();
        if(cur != null) player.gun = cur;
    }

    /**
     * 2-2-2. 진 플레이어는 본인이 가지고 있는 총을 해당 격자에 내려놓고, 해당 플레이어가 원래 가지고 있던 방향대로 한 칸 이동합니다.
     * 만약 이동하려는 칸에 다른 플레이어가 있거나 격자 범위 밖인 경우에는 오른쪽으로 90도씩 회전하여 빈 칸이 보이는 순간 이동합니다.
     * 만약 해당 칸에 총이 있다면, 해당 플레이어는 가장 공격력이 높은 총을 획득하고 나머지 총들은 해당 격자에 내려 놓습니다.
     */
    private static void setLoser(Player player) {
        dropGun(player);
        movePlayer(player, true);
        PriorityQueue<Integer> guns = board[player.x][player.y].guns;
        if(!guns.isEmpty()) {
            player.gun = guns.poll();
        }
    }

    private static void dropGun(Player player) {
        board[player.x][player.y].guns.add(player.gun);
        player.gun = 0;
    }

    private static void movePlayer(Player player, boolean isLoser) {
        playerMap[player.x][player.y] = 0;

        if(isLoser) {
            while(isOutMap(player.x + dir[player.d][0], player.y + dir[player.d][1]) || playerMap[player.x + dir[player.d][0]][player.y + dir[player.d][1]] != 0) {
                player.d = turnRight(player.d);
            }
        } else {
            if(isOutMap(player.x + dir[player.d][0], player.y + dir[player.d][1])) player.d = turnBack(player.d);
        }

        player.x += dir[player.d][0];
        player.y += dir[player.d][1];

    }

    private static boolean isCurWin(Player prev, Player cur) {
        int prevPower = prev.gun + prev.s;
        int curPower = cur.gun + cur.s;

        return (prevPower == curPower && cur.s > prev.s) || curPower > prevPower;
    }

    private static void takeGunOnBoard(Player player) {
        PriorityQueue<Integer> guns = board[player.x][player.y].guns;
        if(!guns.isEmpty()) {
            if(player.gun != 0) guns.add(player.gun);
            Integer curGun = guns.poll();
            if(curGun != null) player.gun = curGun;
        }
    }

    private static int turnRight(int d) {
        return (d + 1) % 4;
    }

    private static int turnBack(int d) {
        return (d + 2) % 4;
    }

    private static boolean isOutMap(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        board = new Board[n][n];
        players = new ArrayList<>();
        playerMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = new Board(Integer.parseInt(input[j]));
            }
        }

        players.add(null);
        for (int i = 1; i <= m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            players.add(new Player(x, y, Integer.parseInt(input[2]), Integer.parseInt(input[3])));
            playerMap[x][y] = i;
        }
    }

    static class Board {
        PriorityQueue<Integer> guns;

        Board(int gun) {
            guns = new PriorityQueue<>((o1, o2) -> o2 - o1);
            if(gun != 0) guns.add(gun);
        }
    }

    static class Player {
        int x;
        int y;
        int d;
        int s;
        int gun;
        int point;

        public Player(int x, int y, int d, int s) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
        }
    }
}
