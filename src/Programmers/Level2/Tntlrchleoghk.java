package Programmers.Level2;

import java.util.ArrayList;

// 18:00 ~ 18:26
public class Tntlrchleoghk {
    public static void main(String[] args) {
        Tntlrchleoghk sol = new Tntlrchleoghk();
        String expression = "50*6-3*2";
        long answer = sol.solution(expression);
        System.out.println(answer);
    }

    private int[][] priority = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
    private char[] operators = {'+', '-', '*'};
    public long solution(String expression) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Character> opList = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char cur = expression.charAt(i);
            boolean isOp = false;
            for (int j = 0; j < 3; j++) {
                if(cur == operators[j]){
                    isOp = true;
                    break;
                }
            }
            if(isOp) {
                numList.add(Long.parseLong(sb.toString()));
                opList.add(cur);
                sb = new StringBuilder();
            } else {
                sb.append(cur);
            }
        }
        numList.add(Long.parseLong(sb.toString()));

        for(int i = 0; i < 6; i++) {
            ArrayList<Long> curNumList = new ArrayList<>(numList);
            ArrayList<Character> curOpList = new ArrayList<>(opList);
            int[] curPriority = priority[i];
            char[] operator = new char[3];
            for (int j = 0; j < 3; j++) {
                operator[j] = operators[curPriority[j]];
            }
            for (int j = 0; j < 3; j++) {
                int k = 0;
                while(k < curOpList.size()){
                    if(curOpList.get(k) == operator[j]) {
                        long a = curNumList.remove(k);
                        long b = curNumList.remove(k);
                        if(operator[j] == '+') curNumList.add(k, a + b);
                        else if(operator[j] == '*') curNumList.add(k, a * b);
                        else curNumList.add(k, a - b);
                        curOpList.remove(k);
                    }else {
                        k++;
                    }
                }
            }
            answer = Math.max(Math.abs(curNumList.get(0)), answer);
        }

        return answer;
    }
}
