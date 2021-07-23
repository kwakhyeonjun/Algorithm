package SWEA.D2;

import java.util.Scanner;

public class SWEA2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 1; test_case <= T; test_case++){
            String s = sc.nextLine();
            Boolean isSame = true;
            int idx = 0, count = 1, temp = 0, result = 0;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(idx)){
                    for(int j = idx; j < i; j++){
                        if(i+temp < s.length() && s.charAt(j) != s.charAt(i + temp++)){
                            isSame = false;
                            break;
                        }
                    }
                    if(isSame){
                        result = i - idx;
                        idx = i;
                        count++;
                    }
                    isSame = true;
                    temp = 0;
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
