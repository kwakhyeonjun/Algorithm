package level05;

import java.util.Scanner;

public class B4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        for(int T = 0; T < TestCase; T++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            for(int v : arr) sum += v;
            double avg = sum/N;
            int count = 0;
            for(int v: arr) if(v > avg) count++;
            double ratio = count*100;
            ratio /= N;
            System.out.printf("%.3f", ratio);
            System.out.println("%");
        }
    }
}
