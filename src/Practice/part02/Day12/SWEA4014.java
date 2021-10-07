package Practice.part02.Day12;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA4014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                int count = 1;
                int height = map[i][0];
                boolean pos = true;
                boolean rev = false;
                for (int j = 1; j < N; j++) {
                    int curHeight = map[i][j];
                    if(height == curHeight) {
                        count++;
                        if(rev && count == X){
                            rev = false;
                            count = 0;
                        }
                    }else if(height == curHeight + 1){
                        if(rev){
                            pos = false;
                            break;
                        }
                        count = 1;
                        height = curHeight;
                        rev = true;
                    }else if(height == curHeight - 1){
                        if(rev){
                            pos = false;
                            break;
                        }
                        if(count >= X){
                            count = 1;
                            height = curHeight;
                        }else{
                            pos = false;
                            break;
                        }
                    }else{
                        pos = false;
                        break;
                    }
                }
                if(pos && !rev) answer++;

                count = 1;
                height = map[0][i];
                pos = true;
                rev = false;
                for (int j = 1; j < N; j++) {
                    int curHeight = map[j][i];
                    if(height == curHeight) {
                        count++;
                        if(rev && count == X){
                            rev = false;
                            count = 0;
                        }
                    }else if(height == curHeight + 1){
                        if(rev){
                            pos = false;
                            break;
                        }
                        count = 1;
                        height = curHeight;
                        rev = true;
                    }else if(height == curHeight - 1){
                        if(count >= X){
                            count = 1;
                            height = curHeight;
                        }else{
                            pos = false;
                            break;
                        }
                    }else{
                        pos = false;
                        break;
                    }
                }
                if(pos && !rev) answer++;
            }
            bw.write("#" + test_case + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
