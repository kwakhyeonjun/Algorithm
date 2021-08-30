package IM;

import java.util.Arrays;
import java.util.Scanner;

public class JO1205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] deck = new int[n];
        int joker = 0;
        for(int i = 0; i < n; i++){
            int input = sc.nextInt();
            if(input == 0){
                joker++;
            }else{
                deck[i] = input;
            }
        }
        Arrays.sort(deck);

        int count = 0;
        int max = 0;

        for(int i = joker; i < n-1; i++){
            int tempjoker = joker;
            count = 1;
            int current = deck[i];
            for(int j = i; j < n-1; j++){
                if(current + 1 == deck[j+1]){
                    count++;
                    current = deck[j+1];
                }
                else{
                    if(tempjoker > 0){
                        tempjoker--;
                        count++;
                        j--;
                        current++;
                    }
                }
            }
            if(tempjoker > 0){
                count += tempjoker;
            }
            max = Math.max(max, count);
        }
        if(max == 0 && joker > 0) max = joker;
        System.out.println(max);
    }
}
