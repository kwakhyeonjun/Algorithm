package Test.삼성모의고사;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution02 {
	
	private static class Task{
		int time;
		int[] prev;
		boolean done;
		
		public Task(int time, int[] prev){
			this.time = time;
			this.prev = prev;
			done = false;
		}
	}	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			Task[] tasks = new Task[N+1];
			tasks[0] = new Task(0, new int[] {});
			tasks[0].done = true;
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int time = Integer.parseInt(st.nextToken());
				int prevCount = Integer.parseInt(st.nextToken());
				int[] prev = new int[prevCount];
				for(int j = 0; j < prevCount; j++) {
					prev[j] = Integer.parseInt(st.nextToken());
				}
				tasks[i] = new Task(time, prev);
			}
			
			boolean isDeadlock = false;
			int answer = Integer.MAX_VALUE;
			
			for(int t = 1; t <= N; t++) {
				int temp = tasks[t].time;
				tasks[t].time /= 2;
				int time = 0;
				for(int i = 1; i < N; i++) {
					tasks[i].done = false;
				}				
				
				while(!isAllDone(tasks)){
					isDeadlock = false;
					
					List<Integer> process = new ArrayList<>();
					
					for(int i = 1; i <= N; i++) {
						Task cur = tasks[i]; 
						
						boolean isDone = true;
						
						// 이미 수행한 업무는 넘어감
						if(cur.done) continue;
						
						// 먼저 해야하는 일이 완료되어 있다면,
						for(int p : cur.prev) 
							if(!tasks[p].done) isDone = false;
						
						if(isDone) {
							isDeadlock = true;
							
							process.add(i);							
							
							cur.done = true;
						}
					}
					if(!isDeadlock) break;
					
					int maxTime = 0;
					for(int p : process) {
						maxTime = Math.max(maxTime, tasks[p].time);
					}
					time += maxTime;
				}
				if(!isDeadlock) break;
				answer = Math.min(time, answer);
				tasks[t].time = temp;
			}
			
			if(!isDeadlock) bw.write("#" + test_case + " -1\n");
			else bw.write("#" + test_case + " " + answer + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static boolean isAllDone(Task[] tasks) {
		for(Task cur : tasks)
			if(!cur.done) return false;
		return true;
	}
}
