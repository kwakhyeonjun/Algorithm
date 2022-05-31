package SWEA.D3;

import java.util.Scanner;

/**
 * 0 <= N < 10^10
 * 한 쌍의 숫자를 골라 그 위치를 최대 한번 바꿔 새로운 수 M을 만들 수 있음.
 * 단, 맨 앞에 0이면 안됨.
 * M의 최솟값, 최댓값을 구하라.
 */
public class SWEA13428 {

    private static int[] nums;
    private static int MAX, MIN;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            MAX = Integer.MIN_VALUE; MIN = Integer.MAX_VALUE;
            String N = sc.next();
            if("0".equals(N)) {
                System.out.println("#" + t + " " + 0 + " " + 0);
                continue;
            }
            char[] charNums = N.toCharArray();
            nums = new int[charNums.length];
            for (int i = 0; i < charNums.length; i++) {
                nums[i] = charNums[i] - '0';
            }
            for(int i = 0; i < nums.length; i++) {
                change(i);
            }
            System.out.println("#" + t + " " + MIN + " " + MAX);
        }
    }
    private static void change(int idx) {
        for(int i = 0; i < nums.length; i++) {

            swap(i, idx);
            int cur = getNum();
            if(cur == -1) {
                swap(i, idx);
                continue;
            }
            MIN = Math.min(MIN, cur);
            MAX = Math.max(MAX, cur);
            swap(i, idx);
        }
    }

    private static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int getNum() {
        if(nums[0] == 0) return -1;
        int idx = 0;
        int result = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            result += Math.pow(10, idx++) * nums[i];
        }
        return result;
    }
}
