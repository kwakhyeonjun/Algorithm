package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String input = br.readLine();
            int sum = 0;
            int count = 1;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == 'O'){
                    sum += count;
                    count++;
                }else{
                    count = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
