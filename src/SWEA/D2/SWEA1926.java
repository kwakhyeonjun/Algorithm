package SWEA.D2;

import java.util.Scanner;

public class SWEA1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            /**
             * 1. 3의 배수인 경우 XXXXXX 3의 배수가 아니라 3이 들어간겁니다...
             * 2. 3의 개수 판별
             *  2-1. String? << 이 방법으로 진행
             *  2-2. 자리수별 3의배수 : 몇자리 수인지 확인하기 힘듦
             */
            Boolean thirdFlag = false;
            String str = Integer.toString(i);
            for(int j = 0; j < str.length(); j++){
                if((str.charAt(j) - '0')%3 == 0 && str.charAt(j) - '0' != 0) {
                    System.out.print("-");
                    thirdFlag = true;
                }

            }
            if(!thirdFlag) System.out.print(i + " ");
            else System.out.print(" ");
        }
    }
}
