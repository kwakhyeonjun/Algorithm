package SWEA.D2;

import java.util.Scanner;

public class SWEA1917 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int i, j, l, T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[][] = new int[n][n];
            for(i=0; i<n; i++) {
                for(j=0; j<n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            // horizontal
            for(i=0; i<n; i++) {
                outerloop:
                for(j=0; j<=n-k; j++) {
                    if( j != 0 && a[i][j-1] == 1 ) continue;
                    if( j+k != n && a[i][j+k] == 1 ) continue;
                    for(l=0; l<k; l++) {
                        if( a[i][j+l] == 0 ) continue outerloop;
                    }
                    count++;
                }
            }
            // vertical
            for(i=0; i<n; i++) {
                outerloop:
                for(j=0; j<=n-k; j++) {
                    if( j != 0 && a[j-1][i] == 1 ) continue;
                    if( j+k != n && a[j+k][i] == 1 ) continue;
                    for(l=0; l<k; l++) {
                        if( a[j+l][i] == 0 ) continue outerloop;
                    }
                    count++;
                }
            }
            System.out.format( "#%d %d\n", t, count );
        }
    }
}
