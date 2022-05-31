package SWEA.D3;

import java.util.Scanner;

public class SWEA13038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            boolean[] classes = new boolean[7];
            int d = 0;
            for(int i = 0; i < 7; i++) {
                classes[i] = sc.nextInt() == 1;
                if(classes[i]) d++;
            }
            int a = (n-1)/d;
            int b = (n-1)%d;

            int[] diff = new int[d];
            boolean isFirst = false;
            int zeroDate = 0, date = 1, diffIdx = 0;
            for(int i = 0; i < 7; i++) {
                if(!isFirst && !classes[i]) zeroDate++;
                if(isFirst && !classes[i]) date++;
                if(isFirst && classes[i]) {
                    diff[diffIdx++] = date;
                    date = 1;
                }
                if(!isFirst && classes[i]) isFirst = true;
            }
            diff[d-1] += zeroDate + date;

            int MIN = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i = 0; i < d; i++) {
                if(MIN > diff[i]){
                    MIN = diff[i];
                    minIndex = i;
                }
            }

            int add = 0, addIndex = 0;

            while(b != addIndex) {
                add += diff[minIndex++];
                if(minIndex >= d) minIndex = 0;
                addIndex++;
            }

            System.out.println("#" + t + " " + (1 + a*7 + add));
        }
    }
}
