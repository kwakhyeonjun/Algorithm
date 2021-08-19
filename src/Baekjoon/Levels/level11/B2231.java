package Baekjoon.Levels.level11;

import java.io.*;

public class B2231 {
    private static int N;
    private static int length;
    private static int cons;
    private static int min = Integer.MAX_VALUE;
    private static int[] result;
    private static int[] numbers = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 10; i++){
            numbers[i] = i;
        }
        String temp = br.readLine();
        length = temp.length();
        N = Integer.parseInt(temp);
        result = new int[length];

        comb(0, 0);
        if(min == Integer.MAX_VALUE) bw.write("0");
        else bw.write(String.valueOf(cons));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void comb(int count, int start){
        if(count == length){
            int sum = 0;
            int num = 0;
            for(int i = 0; i < length; i++){
                sum += result[i];
                num += result[i] * Math.pow(10, i);
            }
            sum += num;
            if(sum == N && min > num) {
                min = sum;
                cons = num;
            }
        }else{
            for(int i = 0; i < 10; i++){
                result[count] = numbers[i];
                comb(count + 1, i + 1);
            }
        }
    }
}
