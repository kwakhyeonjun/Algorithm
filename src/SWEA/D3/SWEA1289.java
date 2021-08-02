package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            String str = br.readLine();
            char[] arr = str.toCharArray();
            boolean isZero = true;
            int count = 0;
            for(int i = 0 ; i < arr.length; i++){
                if(isZero){
                    if(arr[i] == '1'){
                        isZero = false;
                        count++;
                    }
                }else{
                    if(arr[i] == '0'){
                        isZero = true;
                        count++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}

