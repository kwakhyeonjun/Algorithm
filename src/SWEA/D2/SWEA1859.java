package SWEA.D2;

import java.util.Scanner;

public class SWEA1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int T = 1; T <= test_case; T++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
            long sum = 0;
            int max = arr[N-1];
            for(int i = N-2; i >= 0; i--){
                if(arr[i] > max) max = arr[i];
                else sum += max - arr[i];
            }
            System.out.printf("#%d %d\n", T, sum);
        }
    }
/**
 * 틀린풀이
 * 앞에서부터 최대값을 찾고 앞의 수를 더하는 방식을 사용
 * 하지만 반례가 발생하여 취소
 * 새로운 풀이
 * 맨 뒤의 값을 최대값으로 하고, 이전의 값을 더함
 * 더 큰 최대값이 생기면 이전까지의 값을 계산
 */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int test_case = sc.nextInt();
//        for(int T = 1; T <= test_case; T++){
//            System.out.print("#" + T + " ");
//            int N = sc.nextInt();
//            int[] prize = new int[N];
//            for(int i = 0; i < N; i++){
//                prize[i] = sc.nextInt();
//            }
//            int idx = 0, maxIdx;
//            long sum = 0, result = 0;
//            // 최대값에서 팔아야함.
//            while(true){
//                maxIdx = findMaxIndex(prize, idx, N);
//                if(maxIdx <= idx) break;
//                int count = maxIdx - idx;
//                for(int i = idx; i < maxIdx; i++){
//                    sum += prize[i];
//                }
//                result += prize[maxIdx] * count - sum;
//                idx = maxIdx + 1;
//                sum = 0;
//            }
//            System.out.println(result);
//        }
//    }
//    static int findMaxIndex(int[] arr, int start, int end){
//        int max = 0, idx = -1;
//        for(int i = start; i < end; i++){
//            if(arr[i] > max) {
//                max = arr[i];
//                idx = i;
//            }
//        }
//        return idx;
//    }
}
