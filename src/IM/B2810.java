package IM;

import java.util.Scanner;

public class B2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String input = sc.next();
        int count = 0;
        for(int i = 0; i < N; i++){
            char current = input.charAt(i);
            if(current == 'S') count++;
            else{
                count++;
                i++;
            }
        }
        count++;
        if(count > N) System.out.println(N);
        else System.out.println(count);
    }
}
