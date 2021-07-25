package SWEA.D2;

import java.util.Scanner;
import java.util.HashSet;
public class SWEA1974_ver2 {
    static HashSet<Integer> set = new HashSet<Integer>();
    static int isValid(int a[][]) {
        int i, j, k, l;
        // horizontal line
        for(i=0; i<9; i++) {
            set.clear();
            for(j=0; j<9; j++) set.add(a[i][j]);
            if( set.size() < 9 ) return 0;
        }
        // vertical line
        for(i=0; i<9; i++) {
            set.clear();
            for(j=0; j<9; j++) set.add(a[j][i]);
            if( set.size() < 9 ) return 0;
        }
        // square
        for(i=0; i<3; i++) {
            for(j=0; j<3; j++) {
                set.clear();
                for(k=0; k<3; k++) {
                    for(l=0; l<3; l++) {
                        set.add(a[3*i+k][3*j+l]);
                    }
                }
                if( set.size() < 9 ) return 0;
            }
        }
        return 1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t, i, j;
        for(t=1; t<=T; t++) {
            int a[][] = new int[9][9];
            for(i=0; i<9; i++) {
                for(j=0; j<9; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.format("#%d %d\n", t, isValid(a));
        }
    }
}