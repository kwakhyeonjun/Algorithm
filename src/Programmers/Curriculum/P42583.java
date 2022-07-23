package Programmers.Curriculum;

import java.util.LinkedList;
import java.util.Queue;

public class P42583 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        P42583 sol = new P42583();

        System.out.println(sol.solution(bridge_length, weight, truck_weights));
    }

    public int solution_prev(int bridge_length, int weight, int[] truck_weights) {
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
                } else if (queue.size() == bridge_length) {
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
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if(sum + truck > weight) {
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.offer(truck);
                        answer++;
                        sum += truck;
                        break;
                    }
                }
            }
        }
        answer += bridge_length;

        return answer;
    }
}
