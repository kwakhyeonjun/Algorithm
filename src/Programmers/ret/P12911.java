package Programmers.ret;

public class P12911 {
    public int solution(int n) {
        int count = binaryCheck(n);
        while(true) {
            n++;
            if(count == binaryCheck(n)) return n;
        }
    }

    private int binaryCheck(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);
        for(char c : binary.toCharArray()) {
            if(c == '1') count++;
        }
        return count;
    }
}
