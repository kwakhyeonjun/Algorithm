package IM;

import java.io.*;

public class B5356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            bw.write("#" + test_case+ " ");
            String[] input = new String[5];
            for(int t = 0; t < 5; t++){
                input[t] = br.readLine();
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 5; j++){
                    if(input[j].length() <= i) continue;
                    sb.append(input[j].charAt(i));
                }
            }
            bw.write(sb +"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
