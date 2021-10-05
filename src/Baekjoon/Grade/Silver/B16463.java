package Baekjoon.Grade.Silver;

import java.util.Scanner;

public class B16463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 19년의 1월 1일은 화요일 == 금요일은 4번째
        int answer = 0, date = 13;
        for (int year = 2019; year <= N; year++) {
            for (int month = 1; month <= 12; month++) {

                // 13일의 금요일인지 확인
                if(date%7 == 4)answer++;

                // 해당 월의 일 수만큼 더하기
                date += days[month];

                //윤년인 해는 2월이 29일까지
                if(month == 2 // 2월인 경우
                    && ((year%4 == 0) && year%200 != 0)  // 4의 배수가 아니고 100의 배수가 아닌 경우
                    || year%400 == 0){ // 400의 배수인 경우
                    date++; // 윤년
                }
            }
        }
        System.out.println(answer);
    }
}
