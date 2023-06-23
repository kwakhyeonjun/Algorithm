package Programmers.Level2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class P176962 {
    public static void main(String[] args) {
        P176962 sol = new P176962();
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[] answer = sol.solution(plans);
        for (String s : answer) {
            System.out.println(s);
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int answerIndex = 0;

        Stack<Plan> rest = new Stack<>();
        PriorityQueue<Plan> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));

        for (String[] plan : plans) {
            pq.add(new Plan(plan[0], getTime(plan[1]), Integer.parseInt(plan[2])));
        }

        int time = 0;

        while(!pq.isEmpty()) {
            Plan cur = pq.poll();
            time = cur.start;

            if(pq.isEmpty()) {
                answer[answerIndex++] = cur.name;
                while(!rest.isEmpty()) {
                    answer[answerIndex++] = rest.pop().name;
                }
                break;
            }

            Plan next = pq.peek();

            if(next.start < cur.getEndTime()) {
                cur.playTime -= next.start - time;
                rest.push(cur);
            } else {
                answer[answerIndex++] = cur.name;
                time = cur.getEndTime();

                while(!rest.isEmpty()) {
                    Plan restCur = rest.pop();

                    if(next.start < time + restCur.playTime) {
                        restCur.playTime -= next.start - time;
                        rest.push(restCur);
                        break;
                    } else {
                        answer[answerIndex++] = restCur.name;
                        time = restCur.getEndTime();
                    }
                }
            }
        }

        return answer;
    }

    static class Plan {
        String name;
        int start;
        int playTime;

        public Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public int getEndTime() {
            return start + playTime;
        }
    }

    private int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}
