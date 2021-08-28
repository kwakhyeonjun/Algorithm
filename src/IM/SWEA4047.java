package IM;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA4047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            String input = br.readLine();
            int[][] cards = new int[4][14];
            for(int i = 0; i < input.length(); i = i + 3){
                char card = input.charAt(i);
                int num = Integer.parseInt(input.substring(i+1, i+3));
                if(card == 'S'){
                    cards[0][num]++;
                }else if(card == 'D'){
                    cards[1][num]++;
                }else if(card == 'H'){
                    cards[2][num]++;
                }else{
                    cards[3][num]++;
                }
            }
            bw.write("#"+test_case + " ");
            boolean isError = false;
            for(int j = 0; j < 4; j++){
                for(int k = 1; k <= 13; k++){
                    if(cards[j][k] > 1) isError = true;
                }
            }
            if(isError) bw.write("ERROR\n");
            else{
                for(int i = 0; i < 4; i++){
                    int count = 0;
                    for(int j = 1; j <= 13; j++){
                        if(cards[i][j] == 0) count++;
                    }
                    bw.write(count + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
