package Test.Line;

import java.util.ArrayList;
import java.util.List;

public class Sol3 {

    public static void main(String[] args) {
        int[] arr = solution(new int[][]{{0, 2, 3, 1}, {5, 3, 3, 1}, {10, 2, 4, 1}});
        for(int v : arr) System.out.print(v + " ");
    }

    /**
     * 모든 작업은 각각의 중요도를 가짐
     * 처리하는 방식에 따라 나뉨
     * 한 분류의 작업은 한번에 처리
     * 처리 도중 혹은 처리가 끝남과 동시에 새로 요청된다면 이어서 처리 (파이프라인?)
     * 한 분류에 속하는 모든 작업을 끝내면, 다른 분류 중 중요도 합이가장 높은 분류 처리
     * 우선순위 : 중요도의 합 > 분류번호 낮은 순
     * @param jobs
     * @return
     */
    public static int[] solution(int[][] jobs) {
        boolean[] done = new boolean[jobs.length];
        curTime = jobs[0][0];


        dfs(jobs, done, 0);

        int[] answer = new int[list.size()];
        int idx = 0;
        for(int v : list) answer[idx++] = v;
        return answer;
    }

    static List<Integer> list = new ArrayList<>();
    static int curTime;
    public static void dfs(int[][] jobs, boolean[] done, int index){
        curTime += jobs[index][1];
        int curJob = jobs[index][2];
        if(list.isEmpty()) list.add(curJob);
        if(list.get(list.size()-1) != curJob) list.add(curJob);
        done[index] = true;
        // 같은 작업 있는지 탐색
        for(int i = 0; i < jobs.length; i++){
            if(jobs[i][0] > curTime) break;
            if(jobs[i][2] == curJob && !done[i]){
                dfs(jobs, done, i);
            }
        }
        // 높은 중요도 작업 진행
        int[] nums = new int[101];
        for(int i = 0; i < jobs.length; i++){
            if(jobs[i][0] > curTime) break;
            if(!done[i]){
                nums[jobs[i][2]] += jobs[i][3];
            }
        }
        int max = 0;
        int maxNum = -1;
        for(int i = 1; i <= 100; i++){
            if(nums[i] > max) {
                max = nums[i];
                maxNum = i;
            }
        }

        max = 0;
        int maxIdx = -1;
        for(int i = 0; i < jobs.length; i++){
            if(!done[i] && jobs[i][2] == maxNum){
                if(jobs[i][3] > max){
                    max = jobs[i][3];
                    maxIdx = i;
                }
            }
        }
        if(maxIdx != -1) dfs(jobs, done, maxIdx);
        else{ // 선택된 작업이 없는 경우
            for(int i = 0; i < jobs.length; i++){
                if(!done[i]){
                    dfs(jobs, done, i);
                    break;
                }
            }
        }
    }
}
