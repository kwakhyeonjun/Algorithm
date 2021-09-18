package Practice.part01.Day09;

import java.io.*;

public class B3040 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarf = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[7];
        comb(dwarf, result, 0, 0, 9, 7);

        bw.flush();
        bw.close();
        br.close();

    }

    private static void comb(int[] dwarf, int[] result, int count, int start, int n, int r) throws IOException{
        if(count == r){
            int sum = 0;
            for(int i = 0; i < 7; i++){
                sum += result[i];
            }
            if(sum == 100){
                for(int i = 0; i < 7; i++){
                    bw.write(result[i] + "\n");
                }
            }
            return;
        }else{
            for(int i = start; i < n; i++){
                result[count] = dwarf[i];
                comb(dwarf, result, count + 1, i + 1, n, r);
            }
        }
    }
}
