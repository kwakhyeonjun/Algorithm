package SWEA.D3;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            bw.write("#" + test_case + " " + choice(arr, l, 0, n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static int choice(int[][] arr, int cal, int idx, int n){
        int include = 0;
        int exclude = 0;
        if(idx >= n) return 0;
        if(cal <= 0) return 0;
        if(cal - arr[idx][1] >= 0){
            include = arr[idx][0] + choice(arr, cal - arr[idx][1], idx + 1, n);
        }
        exclude = choice(arr, cal, idx+1, n);
        if(include > exclude) return include;
        else return exclude;
    }
}
