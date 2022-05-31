package SWEA.D3;

import java.util.Scanner;

/**
 * 비둘기집
 * 3명
 */
public class SWEA13218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            System.out.println("#" + t + " " + n/3);
        }
    }
}
