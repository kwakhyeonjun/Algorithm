package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            Stack<Integer>[] stacks = new Stack[N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                stacks[i] = new Stack<>();
            }

            int count = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[j][i] != 0){
                        if(stacks[i].isEmpty()) stacks[i].push(map[j][i]);
                        else{
                            int prev = stacks[i].pop();
                            int current = map[j][i];
                            if(prev == 1 && current == 2) count++;
                            else stacks[i].push(current);
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);


        }
    }
}
