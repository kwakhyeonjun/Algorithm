package Test.삼성모의고사;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 100점!
 */
public class Algo02 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] station = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				station[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] values = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i==j || i+1==j || i-1==j || (i == 0 && j == N-1) || (j==0 && i == N-1)) values[i][j] = 0;
					else values[i][j] = (station[i] + station[j]) * (station[i] + station[j]);
				}
			}
			
			int max = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = i; j < N; j++) {
					// 불가능 지역 넘어감
					if(values[i][j] == 0)  continue;
					
					// i와 j를 선택했을 때, 불가능한 지역 골라냄
					boolean[] impossible = new boolean[N];
					for(int k = i; k <= j; k++) {
						impossible[k] = true;
					}
					int in = Math.abs(i - j + 1);
					int out = N - Math.abs(i - j + 1);
					if(in < out) {
						if(i - 1 < 0) impossible[N-1] = true;
						else impossible[i-1] = true;
						if(j+1>=N) impossible[0] = true;
						else impossible[j+1] = true;
					}else {
						for(int k = 0; k < N; k++) {
							impossible[k] = !impossible[k];
						}
						impossible[i] = !impossible[i];
						impossible[j] = !impossible[j];
						if(i+1 >= N) impossible[0] = !impossible[0];
						else impossible[i+1] = !impossible[i+1];
						if(j-1 < 0) impossible[N-1] = !impossible[N-1];
						else impossible[j-1] = !impossible[j-1];
					}
					// 이때 impossible이 false 인 지역만 선택할 수 있음.
					
					for(int k = 0; k < N; k++) {
						if(impossible[k]) continue;
						for(int l = k; l < N; l++) {
							if(impossible[l]) continue;
							if(k==l) continue;
							if(values[k][l] == 0) continue;
							max = Math.max(max, values[i][j] + values[k][l]);
						}
					}
				}
			}
			bw.write("#" + test_case + " " + max + "\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
