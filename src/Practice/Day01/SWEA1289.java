package Practice.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SWEA 1289
public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            String str = br.readLine();
            char[] arr = str.toCharArray();
            boolean isZero = true;
            int count = 0;
            if(arr[0] == '1') count++;
            for(int i = 1 ; i < arr.length; i++){
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
                // 정리
                // if(arr[i - 1] != arr[i]) count++;
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}
