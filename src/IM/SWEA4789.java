package IM;

import java.io.*;

public class SWEA4789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            String input = br.readLine();
            int sum = 0;
            int count = 0;
            for(int i = 0; i < input.length(); i++){
                int current = input.charAt(i) - '0';
                if(sum < i && current != 0){
                    count = i - sum;
                    sum += count + current;
                }else{
                    sum += current;
                }
            }
            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
