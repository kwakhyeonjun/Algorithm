package Programmers.ret;

public class P12953 {
    public int solution(int[] arr) {
        int answer = 1;

        int gcd = gcd(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
        }
        answer = gcd;
        for(int a : arr) {
            answer *= (double) a / gcd;
        }
        return answer;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
