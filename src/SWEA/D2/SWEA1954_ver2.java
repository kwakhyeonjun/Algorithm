package SWEA.D2;

import java.util.Scanner;

public class SWEA1954_ver2 {
    static int num, r, c;
    static String direction;
    static int ar, ac;
    static int a[][];
    static void turn() {
        switch( direction ) {
            case "right": direction="down"; return;
            case "down": direction="left"; return;
            case "left": direction="up"; return;
            case "up": direction="right"; return;
        }
    }
    static void move(int n) {
        for(int i=0; i<n; i++) {
            num++;
            switch( direction ) {
                case "right": c++; break;
                case "down": r++; break;
                case "left": c--; break;
                case "up": r--; break;
            }
            a[r][c] = num;
        }
    }
    public static void main(String args[]) {
        a = new int[10][10];
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for( int t=1; t<=T; t++) {
            int n = sc.nextInt();
            direction = "right";
            r = 0; c = 0;
            num = 1; a[0][0] = 1;
            move( n-1 );
            for(int i=n-1; i>0; i--) {
                turn();
                move( i );
                turn();
                move( i );
            }
            System.out.format("#%d\n", t);
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.format("%d ", a[i][j]);
                }
                System.out.println();
            }
        }
    }
}
