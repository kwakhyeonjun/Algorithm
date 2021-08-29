package IM;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA7272 {
    private static String[] alp = {"CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int positionA = 0;
            int positionB = 0;

            bw.write("#" + test_case + " ");
            boolean isWrong = false;
            if(a.length() != b.length()){
                bw.write("DIFF" + "\n");
                break;
            }
            for(int i = 0; i < a.length(); i++){
                for(int j = 0; j < 3; j++){
                    if(alp[j].contains(String.valueOf(a.charAt(i)))) positionA = j;
                    if(alp[j].contains(String.valueOf(b.charAt(i)))) positionB = j;
                }
                if(positionA != positionB){
                    bw.write("DIFF" + "\n");
                    isWrong = true;
                    break;
                }
            }
            if(!isWrong) bw.write("SAME" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
