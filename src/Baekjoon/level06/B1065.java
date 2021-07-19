package Baekjoon.level06;

import java.util.Scanner;

public class B1065 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(func(i)) count++;
        }
        System.out.println(count);
    }

    /**
     * 다른풀이
     * char를 사용하지 않고 그냥 각 자리 숫자를 뽑아냄.
     * 아니 애시당초에 이렇게 풀면 안됐음. 100이하는 무조건 그대로고
     * 1000 이하는 3자리니까 무조건 first&second만 나옴
     * 1000보다 작거나 같은 자연수 N이므로 1000에서 false인 분기만 만들면 됨.
     */
    static boolean func(int n){
        if(n<100) return true;
        else{
            String s = Integer.toString(n);
            int first = (s.charAt(1) - '0') - (s.charAt(0) - '0');
            int second = (s.charAt(2) - '0') - (s.charAt(1) - '0');
            if(s.length() == 3){
                if(first == second) return true;
                else return false;
            }else{
                int third = (s.charAt(3) - '0') - (s.charAt(2) - '0');
                if(first == second && second == third) return true;
                else return false;
            }
        }
    }
}

/**
 * int n;
 * n's unit = n%10
 * n's tens = (n%100)/10
 * n's hunds = (n%1000)/10
 * ...
 */
