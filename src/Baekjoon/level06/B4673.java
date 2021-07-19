package Baekjoon.level06;

public class B4673 {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
        for(int i = 1; i <= 10000; i++){
            int selfNum = selfNumber(i);
            if(selfNum <= 10000) arr[selfNum] = true;
        }
        for(int i = 1; i < 10001; i++){
            if(!arr[i]) System.out.println(i);
        }
    }

    public static int selfNumber(int n){
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += s.charAt(i) - '0';
        }
        sum += n;
        return sum;
    }
}
