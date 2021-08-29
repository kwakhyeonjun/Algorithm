package IM;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA4698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = (int)Math.pow(10, 6);
        boolean[] isNotPrime = new boolean[N+1];

        isNotPrime[0] = isNotPrime[1] = true;
        for(int i=2; i*i <= N; i++) {
            if(!isNotPrime[i]){
                for(int j=i*i; j<= N; j+=i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int count = 0;
            for(int i = A; i <= B; i++){
                if(!isNotPrime[i]){
                    String temp = String.valueOf(i);
                    for(int j = 0; j < temp.length(); j++){
                        int num = temp.charAt(j) - '0';
                        if(num == D){
                            count++;
                            break;
                        }
                    }

                }

            }
            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
