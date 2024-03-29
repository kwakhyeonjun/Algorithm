package Programmers.Level2;

public class P92335 {
    public int solution(int n, int k) {
        int answer = 0;

        String change = getK(n, k);

        String[] split = change.split("0");

        for(String s : split) {
            if("".equals(s)) continue;
            if(isPrime(Long.parseLong(s))) answer++;
        }

        return answer;
    }

    private boolean isPrime(long n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    private String getK(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            sb.append(n%k);
            n /= k;
        }

        return sb.reverse().toString();
    }
}
