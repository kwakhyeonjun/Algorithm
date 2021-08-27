package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        loop1:
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int[] a = new int[5];
            for (int i = 0; i < aSize; i++) {
                int pic = Integer.parseInt(st.nextToken());
                a[pic]++;
            }
            st = new StringTokenizer(br.readLine());
            int bSize = Integer.parseInt(st.nextToken());
            int[] b = new int[5];
            for(int i = 0; i < bSize; i++){
                int pic = Integer.parseInt(st.nextToken());
                b[pic]++;
            }

            for(int i = 4; i > 0; i--){
                if(a[i] > b[i]) {
                    System.out.println("A");
                    continue loop1;
                }
                else if(a[i] < b[i]){
                    System.out.println("B");
                    continue loop1;
                }
            }
            System.out.println("D");
        }
    }
}
