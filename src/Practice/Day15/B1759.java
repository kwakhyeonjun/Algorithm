package Practice.Day15;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759 {
    private static int L, C;
    private static String vowels = "aeiou";
    private static String[] picked;
    private static String[] input;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        picked = new String[L];
        input = new String[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            input[i] = st.nextToken();
        }

        Arrays.sort(input);

        comb(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void comb(int count, int start) throws IOException{
        if(count == L){
            int vowel = 0;
            for(String s : picked){
                if(vowels.contains(s)) vowel++;
            }
            if(vowel < 1 || L-vowel < 2) return;
            for(String s : picked){
                bw.write(s);
            }
            bw.write("\n");
            return;
        }else{
            for(int i = start; i < C; i++){
                picked[count] = input[i];
                comb(count + 1, i+1);
            }
        }
    }
}
