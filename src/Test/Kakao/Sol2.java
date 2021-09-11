package Test.Kakao;

import java.util.ArrayList;
import java.util.List;

public class Sol2 {

    public static void main(String[] args) {
        Sol2 sol2 = new Sol2();
        System.out.println(sol2.solution(1211211, 10));
    }

    public int solution(int n, int k) {
        String binary = setBinary(n, k);

        List<Double> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i)!='0') sb.append(binary.charAt(i));
            else{
                if(sb.length()!=0) list.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder();
            }
        }
        if(sb.length() != 0) list.add(Double.parseDouble(sb.toString()));

        int answer = 0;
        for(double v : list){
            if(isPrime(v)) answer++;
        }

        return answer;
    }

    public boolean isPrime(double n){
        if(n < 2) return false;
        if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public String setBinary(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n%k);
            n = n/k;
        }
        return sb.reverse().toString();
    }
}
