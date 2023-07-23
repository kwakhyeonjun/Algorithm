package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA17288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int t = Integer.parseInt(input);

        for (int tc = 1; tc <= t; tc++) {
            input = br.readLine();
            int answer = Integer.MAX_VALUE;

            if(input.length() % 2 == 0) {
                int a = Integer.parseInt(input.substring(0, input.length()/2));
                int b = Integer.parseInt(input.substring(input.length() / 2));
                System.out.printf("#%d %d\n", tc, a + b);
                continue;
            }


            for (int i = 0; i < 2; i++) {
                int a = Integer.parseInt(input.substring(0, input.length()/2 + i));
                int b = Integer.parseInt(input.substring(input.length() / 2 + i));
                answer = Math.min(answer, a + b);
            }

            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
