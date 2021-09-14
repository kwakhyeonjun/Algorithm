package Practice.part02.Day01;

import java.util.Scanner;

public class B1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[1000001];
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 1;
        for (int i = 4; i <= n; i++) {
            int[] prev = new int[3];

            prev[0] = i%2 == 0 ? nums[i/2] : Integer.MAX_VALUE;
            prev[1] = i%3 == 0 ? nums[i/3] : Integer.MAX_VALUE;
            prev[2] = nums[i-1];

            int min = Integer.MAX_VALUE;
            for(int j = 0; j < 3; j++){
                nums[i] = Math.min(min, prev[j]) + 1;
            }
        }
        System.out.println(nums[n]);
    }
}
