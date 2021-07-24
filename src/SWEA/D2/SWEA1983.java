package SWEA.D2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class SWEA1983 {
    public static void main(String args[]) {
        final String grades[] = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt()-1; // 0 to 9
            Integer a[] = new Integer[n];
            for(int i=0; i<n; i++) {
                int mid = sc.nextInt();
                int fin = sc.nextInt();
                int hom = sc.nextInt();
                a[i] = mid*35 + fin*45 + hom*20; //굳이 소수점 필요없음
            }
            int k_score = a[k]; // k번째 스코어를 미리 저장
            Arrays.sort(a, Collections.reverseOrder()); // A+부터 grades를 저장해놨으므로 역순으로 sort
            int k_rank = Arrays.asList(a).indexOf(k_score); // k번째의 스코어를 가진 수를 불러옴
            System.out.format("#%d %s\n", t, grades[10*k_rank/n]); //
        }
    }
}