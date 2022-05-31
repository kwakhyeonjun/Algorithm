package SWEA.D2;

import java.io.*;
import java.util.Base64;

public class SWEA1928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){

            String encoded = br.readLine();
            String decoded = new String(Base64.getDecoder().decode(encoded));
            System.out.format("#%d %s\n", test_case, decoded);
        }
    }
}
