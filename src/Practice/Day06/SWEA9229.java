package Practice.Day06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA9229 {
    private static int sum;
    private static int max;
    private static int[] snack;
    private static int[] pick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sum = 0;
            max = 0;
            snack = new int[n];
            pick = new int[2];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }
            getSnack(0, 0, m);
            if(max == 0) max = -1;
            bw.write("#" + test_case + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void getSnack(int idx, int count, int m){
        if(sum > m){
            return;
        }
        if(count == 2){
            if(sum > max) max = sum;
            return;
        }
        for(int i = idx; i < snack.length; i++){
            pick[count] = snack[i];
            sum += snack[i];
            getSnack(i + 1, count + 1, m);
            sum -= snack[i];
        }
    }
}
