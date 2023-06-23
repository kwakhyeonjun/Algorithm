package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class P92342 {

    public int[] solution(int n, int[] info) {

        picked = new int[11];
        max = Integer.MIN_VALUE;
        answer = new int[11];

        comb(info, 0, 0, n);

        if(max == Integer.MIN_VALUE) return new int[]{-1};
        return answer;
    }

    int[] picked;
    int max, against;
    int[] answer;

    private void comb(int[] info, int start, int count, int n) {
        if(count == n) {
            int sum = 0;
            for(int i = 0; i < count; i++) {
                sum += (11 - picked[i]);
            }
            against = 0;
            for(int i = 0; i < 11; i++) {
                boolean flag = false;
                for (int j = 0; j < count; j++) {
                    if(picked[j] == i) {
                        flag = true;
                        break;
                    }
                }
                if(!flag && info[i] > 0) against += i;
            }

            if(sum > max && against < sum) {
                answer = new int[11];
                for (int i = 0; i < count; i++) {
                    answer[picked[i]] = info[picked[i]] + 1;
                }
                max = sum;
            }
            return;
        }
        for (int i = start; i < 11; i++) {
            picked[count] = i;
            if(count + info[i] + 1 > n) continue;
            comb(info, i + 1, count + info[i] + 1, n);
        }
    }

    public int solution(int number, int target) {
        // 여기에 코드를 작성해주세요
        visited = new boolean[target * 2];

        return bfs(number, target);
    }

    private boolean[] visited;

    private int bfs(int number, int target) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{number, 0});
        visited[number] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int ret = cur[1];

            if(num + 1 == target || num - 1 == target || num * 2 == target) return ret + 1;
            if(!visited[num + 1]) {
                visited[num + 1] = true;
                queue.add(new int[]{num + 1, ret + 1});
            }

            if(!visited[num - 1]) {
                visited[num - 1] = true;
                queue.add(new int[]{num - 1, ret + 1});
            }

            if(num * 2 <= target * 2 && !visited[num * 2]) {
                visited[num * 2] = true;
                queue.add(new int[]{num * 2, ret + 1});
            }
        }

        return -1;
    }
}
