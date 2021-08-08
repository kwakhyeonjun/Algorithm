package SWEA.D4;

import java.io.*;
import java.util.Stack;

public class SWEA5432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            char[] arr = br.readLine().toCharArray();
            int staff = 0;
            int count = 0;
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] == '('){
                    if(arr[i+1] == ')'){
                        count += staff;
                        i++;
                    }else{
                        staff++;
                        count++;
                    }
                }else{
                    staff--;
                }
            }
            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
