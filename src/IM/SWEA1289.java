package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            String input = br.readLine();
            int count = 0;
            if(input.charAt(0) == '1') count++;
            for(int i = 0; i < input.length() - 1; i++){
                if(input.charAt(i) != input.charAt(i+1)) count++;
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}
