package level03;

import java.util.Scanner;

public class B10950 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();

        for(int T = 0; T < TestCase; T++){
            int A, B;
            A = sc.nextInt();
            B = sc.nextInt();

            System.out.println(A+B);
        }
    }
}