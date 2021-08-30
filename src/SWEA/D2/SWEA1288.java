package SWEA.D2;

import java.io.*;

public class SWEA1288 {
    private static boolean[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            nums = new boolean[10];
            while(true){
                String temp = String.valueOf(N);
                for(int i = 0; i < temp.length(); i++){
                    nums[temp.charAt(i) - '0'] = true;
                }
                if(isAllCount()) break;
                else{
                    N *= 2;
                }
            }
            bw.write("#" + test_case + " " + N + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isAllCount(){
        for(int i = 0; i < nums.length; i++){
            if(!nums[i]) return false;
        }
        return true;
    }
}
