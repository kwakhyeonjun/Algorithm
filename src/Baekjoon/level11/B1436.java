package Baekjoon.level11;

import java.io.*;

public class B1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String result = getSix(n);
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static String getSix(int n){
        int num = 666;
        int count = 0;
        while(true){
            String s = String.valueOf(num++);
            for(int i = 0; i < s.length() - 2; i++){
                if(s.charAt(i) == '6' && s.charAt(i+1) == '6' && s.charAt(i+2) == '6'){
                    count++;
                    if(count == n) return s;
                    else break;
                }
            }
        }
    }
}
