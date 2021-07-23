package SWEA.D2;

import java.util.Scanner;

public class SWEA1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            String str = sc.next();
            Boolean isPalindrome = true;
            for(int i = 0; i < str.length()/2; i++){
                if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                    isPalindrome = false;
                    break;
                }
            }
            System.out.print("#" + test_case + " ");
            if(isPalindrome) System.out.println(1);
            else System.out.println(0);
        }
    }
}
