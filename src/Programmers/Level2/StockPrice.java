package Programmers.Level2;

import java.util.Stack;

public class StockPrice {
    public static void main(String[] args) {
        StockPrice sol = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = sol.solution(prices);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        stack.add(new int[]{0, prices[0]});


        for (int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty()) {
                int[] cur = stack.pop();
                if(cur[1] > prices[i]) {
                    answer[cur[0]] = i - cur[0];
                }else{
                    stack.push(cur);
                    break;
                }
            }
            stack.push(new int[]{i, prices[i]});
        }

        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            answer[cur[0]] = prices.length - cur[0] - 1;
        }

        return answer;
    }
}
