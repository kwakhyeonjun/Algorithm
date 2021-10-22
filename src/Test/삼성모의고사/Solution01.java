package Test.삼성모의고사;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution01 {
	
	private static class Person{
		int x, y; 
		int[] dist = new int[2];
		int minDist;
		int minExit;
		Person(int x, int y){
			this.x = x;
			this.y = y;
		}
		void setDist(int[][] exit) {
			for(int i = 0; i < 2; i++) {
				dist[i] = Math.abs(exit[i][0] - x) + Math.abs(exit[i][1] - y);
			}
		}
		void setMinDist() {
			if(dist[0] < dist[1]) {
				minDist = dist[0];
				minExit = 0;
			}else {
				minDist = dist[1];
				minExit = 1;
			}
		}
	}
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			List<Person> pList = new ArrayList<>();
			int[][] exit = new int[2][2];
			int[] wait = new int[2];
			boolean isExit = false;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) pList.add(new Person(i, j));
					if(map[i][j] == 2) {
						if(isExit) exit[1] = new int[] {i, j};
						else {
							isExit = true;
							exit[0] = new int[] {i, j};
						}
					}
				}
			}
			
			for(Person person : pList) {
				person.setDist(exit);
			}
			
			int answer = 1;
			
			while(!pList.isEmpty()) {
				int min = Math.min(pList.get(0).dist[0], pList.get(0).dist[1]);
				int index = 0;
				for(int i = 1; i < pList.size(); i++) {
					Person person = pList.get(i);
					person.setMinDist();
					if(min > person.minDist) {
						index = i;
						min = person.minDist;
					}
				}
				
				Person removePerson = pList.remove(index); 
				
				for(Person person : pList) {
					if(min == person.minDist && removePerson.minExit == person.minExit) {
						person.dist[person.minExit]++;
					}
				}
								
				for(Person person : pList) {
					person.dist[0] -= min; 
					person.dist[1] -= min; 
				}
				answer += min;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
