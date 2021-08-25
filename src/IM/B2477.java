package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        StringTokenizer st = null;
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 6; i++){
            if(i%2 == 0){
                if(x1 < arr[i]) x1 = arr[i];
            }else{
                if(y1 < arr[i]) y1 = arr[i];
            }
        }

        for(int i = 0; i < 6; i++){
            if(i%2 == 0){
                if(y1 == arr[(i+5)%6] + arr[(i+1)%6]) x2 = arr[i];
            }else{
                if(x1 == arr[(i+5)%6] + arr[(i+1)%6]) y2 = arr[i];
            }
        }
        System.out.println((x1*y1 - x2*y2)*T);
    }
}