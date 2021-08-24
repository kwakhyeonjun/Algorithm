package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] switchs = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int input = Integer.parseInt(st.nextToken());
            if(input == 1) switchs[i] = true;
        }
        int t = Integer.parseInt(br.readLine());
        for(int T = 0; T < t; T++){
            st = new StringTokenizer(br.readLine());
            int control = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(control == 1){
                for(int i = 1; i <= N; i++){
                    if(i%num == 0) switchs[i] = !switchs[i];
                }
            }else{
                int idx = 1;
                switchs[num] = !switchs[num];
                while(true){
                    if(num+idx > N || num-idx <= 0) break;
                    if(switchs[num+idx] == switchs[num-idx]){
                        switchs[num+idx] = !switchs[num+idx];
                        switchs[num-idx] = !switchs[num-idx];
                        idx++;
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(switchs[i]) System.out.print(1 + " ");
            else System.out.print(0 + " ");
            if(i%20 == 0) System.out.println();
        }
    }
}
