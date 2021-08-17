package Jungol;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Arrays.sort(stuff, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> ref = new ArrayList<>();
        for(int i = 0; i < N; i++){
            if(ref.size() == 0) ref.add(stuff[i]);
            else{
                boolean isRef = false;
                for(int j = 0; j < ref.size(); j++){
                    int[] temp = ref.get(j);
                    if(temp[0] < stuff[i][0] && temp[1] > stuff[i][0]){
                        ref.remove(j);
                        ref.add(new int[]{stuff[i][0], temp[1]});
                        isRef = true;
                    }
                    if(temp[0] < stuff[i][1] && temp[1] > stuff[i][1]){
                        ref.remove(j);
                        ref.add(new int[]{temp[0], stuff[i][1]});
                        isRef = true;
                    }
                }
                if(!isRef){
                    ref.add(stuff[i]);
                }
            }
        }

        bw.write(String.valueOf(ref.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
