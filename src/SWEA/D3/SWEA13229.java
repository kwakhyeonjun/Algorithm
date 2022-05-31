package SWEA.D3;

import java.util.Scanner;

public class SWEA13229 {
    private enum date {
        SAT, FRI, THU, WED, TUE, MON, SUN
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("#" + t + " " + (date.valueOf(sc.next()).ordinal() + 1));
        }
    }
}
