package level04;

import java.util.Scanner;

public class B10952 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int A, B;

        do{
            A = sc.nextInt();
            B = sc.nextInt();
            if(A!=0 && B!=0) System.out.println(A+B);
        }while(A !=0 && B != 0);
    }
}
