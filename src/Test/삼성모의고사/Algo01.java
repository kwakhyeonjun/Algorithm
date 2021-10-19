package Test.삼성모의고사;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일단 bfs()
 * dp?
 * 시간 3초
 * 
 * @author Administrator
 *
 */
public class Algo01 {
	
	private static int N, count;
	private static int[][] map;
	private static int[] po;
	private static boolean[][] visited;
	
	private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						po = new int[] {i, j};
						map[i][j] = 0;
					}
				}
			}
			
			bfs();
			bw.write("#" + test_case + " " + count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static class State{
		int x;
		int y;
		int count;
		int[][] map;
		
		public State(int x, int y, int count, int[][] map) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.map = map;
		}
	}
	
	private static int[][] copyMap(int[][] map){
		int[][] tempMap = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		return tempMap;
	}
	
	private static void bfs() {
		Queue<State> queue = new LinkedList<>();
		State state = new State(po[0], po[1], 0, map);
		queue.add(state);
		
		while(!queue.isEmpty()) {
			State cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int moveCount = cur.count;
			int[][] curMap = cur.map;
			
			for(int i = 0; i < 4; i++) {
				int nx = x;
				int ny = y;
				int pos = 0;
				while(true) {
					nx = nx + dir[i][0];
					ny = ny + dir[i][1];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) break; // 밖으로 벗어나는 경우
					
					if(pos == 1) {
						boolean temp = false;
						if(curMap[nx][ny] == 1 && !visited[nx][ny]) {
							count++;
							visited[nx][ny] = true;
							curMap[nx][ny] = 0;
							pos++;
							temp = true;
						}
						if(moveCount < 2) queue.add(new State(nx, ny, moveCount+1, copyMap(curMap)));
						if(temp) curMap[nx][ny] = 1;
					}
					
					if(curMap[nx][ny] == 1) pos++;
				}
			}
		}
	}
}
























