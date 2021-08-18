package Practice.Day12;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA4012 {
    private static int[][] taste;
    private static int[] stuff;
    private static int[] pick;
    private static int N, min;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            taste = new int[N][N];
            stuff = new int[N];
            pick = new int[N/2];
            min = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    taste[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < N; i++){
                stuff[i] = i;
            }

            choice(0, 0);
            bw.write("#" + test_case + " " + min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void choice(int start, int count){
        if(count == N/2){
            cook();
            return;
        }else{
            for(int i = start; i < N; i++){
                pick[count] = stuff[i];
                choice(i + 1, count + 1);
            }
        }
    }

    private static void cook(){
        int[] unpick = setUnpick();
        int taste1 = 0;
        int taste2 = 0;
        for(int i = 0; i < N/2; i++){
            for(int j = 0; j < N/2; j++){
                taste1 += taste[pick[i]][pick[j]];
                taste2 += taste[unpick[i]][unpick[j]];
            }
        }
        min = Math.min(Math.abs(taste1 - taste2), min);
    }

    private static int[] setUnpick(){
        int[] unpick = new int[N/2];
        int idx = 0;
        for(int i = 0; i < N; i++){
            boolean isPicked = false;
            for(int j = 0; j < N/2; j++){
                if(stuff[i] == pick[j]) isPicked = true;
            }
            if(!isPicked) unpick[idx++] = i;
        }
        return unpick;
    }
}
