package Practice.part01.Day09;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA6808 {
    private static int[] deckInput = new int[9];
    private static int[] deckOpponent = new int[9];
    private static int[] resultArr = new int[9];
    private static int N = 9, R = 9;
    private static int resultA, resultB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++){
                deckInput[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            resultA = 0;
            resultB = 0;
            int idx = 0;
            for(int i = 0; i < 18; i++){
                boolean isInDeck = false;
                for(int j = 0; j < 9; j++){
                    if(deckInput[j] == i) isInDeck = true;
                }
                if(!isInDeck) deckOpponent[idx++] = i;
            }
//            permWithFlag(0, 0);
            permWithArr(0);
            bw.write("#" + test_case + " " + resultA + " " + resultB + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void permWithFlag(int count, int flag){
        if(count == R){
            int p1 = 0;
            int p2 = 0;
            for(int i = 0; i < 9; i++){
                if(deckInput[i] > resultArr[i]){
                    p1 += deckInput[i] + resultArr[i] + 2;
                }else{
                    p2 += deckInput[i] + resultArr[i] + 2;
                }
            }
            if(p1 > p2) resultA++;
            else if(p1 < p2) resultB++;
            return;
        }else{
            for(int i = 0; i < N; i++){
                if((flag & 1 << i) != 0) continue;
                resultArr[count] = deckOpponent[i];
                permWithFlag(count+1, flag | 1 << i);
            }
        }
    }

    private static boolean[] isVisited = new boolean[N];

    private static void permWithArr(int count){
        if(count == R){
            int p1 = 0;
            int p2 = 0;
            for(int i = 0; i < 9; i++){
                if(deckInput[i] > resultArr[i]){
                    p1 += deckInput[i] + resultArr[i] + 2;
                }else{
                    p2 += deckInput[i] + resultArr[i] + 2;
                }
            }
            if(p1 > p2) resultA++;
            else if(p1 < p2) resultB++;
            return;
        }else{
            for(int i = 0; i < N; i++){
                if(isVisited[i]) continue;
                isVisited[i] = true;
                resultArr[count] = deckOpponent[i];
                permWithArr(count+1);
                isVisited[i] = false;
            }
        }
    }
}
