package Baekjoon.level03;

/**
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class B11022 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();

        for(int T = 0; T < TestCase; T++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.printf("Case #%d: %d + %d = %d%n", T+1, A, B, A+B);
        }
    }
}
