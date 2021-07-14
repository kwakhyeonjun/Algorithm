import java.util.Scanner;

public class B2577 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int num = A * B * C;

        String sNum = String.valueOf(num);

        char[] digit = sNum.toCharArray();

        int[] result = new int[10];

        for(int i = 0; i < digit.length; i++){
            result[digit[i] - '0']++;
        }

        for(int v : result){
            System.out.println(v);
        }
    }
}
