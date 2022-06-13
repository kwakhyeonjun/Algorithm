package Programmers.Level2;

import java.util.Stack;

public class TruckOnBridge {
    public static void main(String[] args) {
        TruckOnBridge sol = new TruckOnBridge();
        int b = 2;
        int w = 10;
        int[] t = {7,4,5,6};
        System.out.println(sol.solution(b, w, t));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        Stack<Integer> stack = new Stack<>();
        int curWeight = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            if(curWeight > weight) answer += bridge_length;

            curWeight += truck_weights[i];
            stack.push(truck_weights[i]);
        }

        return answer;
    }
}
