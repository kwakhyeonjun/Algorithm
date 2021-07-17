package level06;

import java.util.Scanner;

public class B8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        for(int T = 0; T < TestCase; T++){
            String prob = sc.next();
            int count = 1, result = 0;
            for(int i = 0; i < prob.length(); i ++){
                if(prob.charAt(i) == 'O') {
                    result += count;
                    count++;
                }else{
                    count = 1;
                }
            }
            System.out.println(result);
        }
    }
}
