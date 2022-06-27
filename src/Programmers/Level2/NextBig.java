package Programmers.Level2;

public class NextBig {
    public static void main(String[] args) {
        NextBig sol = new NextBig();
        int n = 78;
        System.out.println(sol.solution(n));
    }

    public int solution(int n) {
        int cur = n + 1;
        while(getDigit(n) != getDigit(cur++)){

        }
        return cur;
    }

    private int getDigit(int n) {
        String digit = Integer.toBinaryString(n);
        int count = 0;
        for(char c : digit.toCharArray()){
            if(c == '1') count++;
        }
        return count;
    }
}
