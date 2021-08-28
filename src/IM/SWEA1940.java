package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            int tot = 0;
            int curSpeed = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int control = Integer.parseInt(st.nextToken());
                int speed = 0;
                if(control != 0){
                    speed = Integer.parseInt(st.nextToken());
                }
                if(control == 2){
                    curSpeed -= speed;
                    if(curSpeed < 0) curSpeed = 0;
                }else if(control == 1){
                    curSpeed += speed;
                }
                tot += curSpeed;
            }
            System.out.println("#" + test_case + " " + tot);
        }
    }
}
