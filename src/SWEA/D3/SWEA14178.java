package SWEA.D3;

import java.util.Scanner;

/**
 * 1차원 수직선 위에 정원
 * 모든 정수 1<= i <= N에 대해 모든 좌표에 꽃이 하나씩 있음.
 * x에 분무기를 놓으면 [x-D, x+D]에 있는 꽃에 물을 줄 수 있음.
 * N, D를 알 때, 모든 꽃이 한개 이상의 분무기에서 물을 받을 수 있도록.
 */
public class SWEA14178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            double pos = 2*D + 1;
            System.out.println("#" + t + " " + (int)Math.ceil(N/pos));
        }
    }
}
