package Practice.Day11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Jungol1828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] stuff = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stuff, (o1, o2) -> o1[1] - o2[1]);

        int count = 1;
        int max = stuff[0][1];
        for(int i = 1; i < N; i++){
            if(max < stuff[i][0]){
                max = stuff[i][1];
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
