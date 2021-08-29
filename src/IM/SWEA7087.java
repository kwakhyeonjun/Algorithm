package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA7087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            boolean[] alph = new boolean[26];
            for(int i = 0; i < N; i++){
                char c = br.readLine().charAt(0);
                alph[c-'A'] = true;
            }

            for(int i = 0; i < 26; i++){
                if(!alph[i]){
                    System.out.println("#" + test_case + " " + i);
                    break;
                }
            }
        }
    }
}
