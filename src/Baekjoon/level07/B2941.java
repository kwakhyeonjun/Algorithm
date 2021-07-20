package Baekjoon.level07;

import java.util.Scanner;

public class B2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        int result = parse(arr);
        System.out.println(result);
    }

    private static int parse(char[] arr) {
        int result = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == 'c' && (arr[i+1] == '=' || arr[i+1] == '-')
                    || (arr[i] == 'l' && arr[i+1] == 'j')
                    || (arr[i] == 'n' && arr[i+1] == 'j')
                    || (arr[i] == 's' && arr[i+1] == '=')
                    || (arr[i] == 'z' && arr[i+1] == '='))
            {
                if(i==arr.length-2) result++;
                result++;
                i++;
            }else if(arr[i] == 'd') {
                if (i < arr.length - 2 && arr[i + 1] == 'z' && arr[i + 2] == '=') {
                    if (i == arr.length - 3) result++;
                    result++;
                    i += 2;
                } else if (arr[i + 1] == '-') {
                    if(i==arr.length-2) result++;
                    result++;
                    i++;
                }
            }
            else{
                if(i == arr.length - 2) result++;
                result++;
            }
        }
        return result;
    }
}
