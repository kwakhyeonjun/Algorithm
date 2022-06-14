package Programmers.Level2;


import java.util.LinkedList;
import java.util.Queue;

public class TruckOnBridge {
    public static void main(String[] args) {
        TruckOnBridge sol = new TruckOnBridge();
        int b = 100;
        int w = 100;
        int[] t = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(sol.solution(b, w, t));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for(int truck : truck_weights) {
            while(true) {
                if(queue.isEmpty()) {
                    queue.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if(queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if(sum + truck > weight) {
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        answer += bridge_length;

        return answer;
    }
}
