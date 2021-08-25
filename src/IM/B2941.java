package IM;

import java.util.Scanner;

public class B2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0 ; i < cro.length; i++){
            input = input.replaceAll(cro[i], "*");
        }
        System.out.println(input.length());
    }
}
