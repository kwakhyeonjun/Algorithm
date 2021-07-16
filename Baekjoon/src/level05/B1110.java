package level05;

import java.util.Scanner;

public class B1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 10) n *= 10;
        int newN = 0, count = 0, temp = n;
        int nUnit = 0, nTens = 0;
        while(n != newN){
            if(count == 0){
                nUnit = n%10;
                nTens = n/10;
            }else{
                nUnit = newN%10;
                nTens = newN/10;
            }
            temp = nUnit + nTens;
            int tempUnit = temp%10;
            newN = 10 * nUnit + tempUnit;
            count++;
        }
        if(n==0) System.out.println("1");
        else System.out.println(count);
    }
}
