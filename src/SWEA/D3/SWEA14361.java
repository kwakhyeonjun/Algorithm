package SWEA.D3;

import java.util.Scanner;

public class SWEA14361 {

    private static int N;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            int numIndex = 0;
            int tempN = N;
            while(tempN > 0) {
                numIndex++;
                tempN /= 10;
            }
            nums = new int[numIndex];
            tempN = N;
            numIndex = 0;
            while(tempN > 0) {
                nums[numIndex++] = tempN%10;
                tempN /= 10;
            }
            isVisit = new boolean[nums.length];
            resultList = new int[nums.length];
            isMult = false;
            perm(0);
            System.out.println("#" + t + " " + (isMult?"possible":"impossible"));
        }
    }

    private static boolean[] isVisit;
    private static int[] resultList;
    private static boolean isMult;
    private static void perm(int count) {
        if(count == nums.length) {
            int result = 0;
            for(int i = 0; i < nums.length; i++) {
                result += (int)Math.pow(10, i) * resultList[i];
            }
            if(result % N == 0 && result != N) isMult = true;
        }
        for(int i = 0; i < nums.length; i++) {
            if(isVisit[i]) continue;
            isVisit[i] = true;
            resultList[count] = nums[i];
            perm(count + 1);
            isVisit[i] = false;
        }
    }
}
