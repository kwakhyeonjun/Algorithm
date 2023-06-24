package Test.Kakao.Bank;

import java.util.*;

public class Sol {
    public static void main(String[] args) {
        Sol sol = new Sol();
        int[][] jobs = {{1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}};
//        System.out.println(Arrays.toString(sol.solution(jobs)));
    }
//
    public int[] solution(int[][] jobs) {
        List<Integer> answerList = new ArrayList<>();
        Queue<int[]> jobQueue = new LinkedList<>(Arrays.asList(jobs));
        List<int[]> restJobs = new ArrayList<>();

        int curTime = 0;
        int prevJobCode = 0;

        // 모든 작업이 끝날 때까지
        while(!jobQueue.isEmpty() || !restJobs.isEmpty()) {
            setRestQueue(jobQueue, restJobs, curTime);

            // 해야하는 작업은 남았는데, 현재 진행할 수 있는 작업이 없는 경우
            if(!jobQueue.isEmpty() && restJobs.isEmpty()) {
                curTime = jobQueue.peek()[0];
                continue;
            }

            // 다음에 수행할 작업 검색
            int nextJobCode = findNextJobCode(restJobs, prevJobCode);

            // 작업 수행
            int nextJobIndex = findNextJobIndex(restJobs, nextJobCode);
            int[] nextJob = restJobs.remove(nextJobIndex);


            // 완료
            curTime += nextJob[1];
            if(nextJobCode != prevJobCode) answerList.add(nextJobCode);
            prevJobCode = nextJobCode;
        }

        return listToArray(answerList);
    }

    private int[] listToArray(List<Integer> list) {
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private int findNextJobIndex(List<int[]> restJobs, int nextJobCode) {
        int index = 0;
        for(int i = 0; i < restJobs.size(); i++) {
            if(restJobs.get(i)[2] == nextJobCode) index = i;
        }
        return index;
    }


    private int findNextJobCode(List<int[]> restQueue, int prevJobCode) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] restJob : restQueue) {
            int key = restJob[2];
            // 만약 이전 작업과 같은 코드의 작업이 있는 경우 해당 작업부터 진행
            if(key == prevJobCode) return prevJobCode;
            map.put(key, map.getOrDefault(key, 0) + restJob[3]);
        }

        return getMax(map);
    }

    private int getMax(Map<Integer, Integer> map) {
        int key = 0;
        int max = 0;

        for(int cur : map.keySet()) {
            if(max < map.get(cur)) {
                key = cur;
                max = map.get(cur);
            } else if(max == map.get(cur) && key > cur) {
                key = cur;
                max = map.get(cur);
            }
        }
        return key;
    }

    private static void setRestQueue(Queue<int[]> jobQueue, List<int[]> restQueue, int curTime) {
        while(!jobQueue.isEmpty() && jobQueue.peek()[0] <= curTime) {
            restQueue.add(jobQueue.poll());
        }
    }

//    public int[] solution(int[][] jobs) {
//       /*
//           1. 같은 분류 방식이라면 모드 끝마칠 때 까지 작업 처리
//           2. 처리하는 도중이나 처리가 끝남과 동시에 같은 분류의 작업이 새로 요청되면 이어서 처리
//           3. 한 분류에 속하는 모든 작업을 끝내면 계속해서 다른 분류 중 작업의 중요도 합이 가장 높은 분류를 선택하여 처리
//        */
//        List<Integer> answerList = new ArrayList<>();
//        Queue<Job> queue = new LinkedList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Job> restJobs = new ArrayList<>();
//        int idx = 1;
//        for(int[] job : jobs) {
//            queue.add(new Job(idx++, job[0], job[1], job[2], job[3]));
//        }
//        int curTime = 0;
//        int preJob = 0;
//        while(!queue.isEmpty() || !restJobs.isEmpty()) {
////            System.out.println(curTime);
//            while(!queue.isEmpty() && curTime >= queue.peek().start) {
//                Job nextJob = queue.poll();
//                restJobs.add(nextJob);
//                int classNo = nextJob.classNo;
//                map.put(classNo, map.getOrDefault(classNo, 0) + nextJob.importance);
//            }
//            if(restJobs.isEmpty()) {
//                curTime++;
//                continue;
//            }
//
//            int key = 0;
//            int max = 0;
//            boolean flag = false;
//
////            System.out.println("map = " + map);
//            for(int classNo : map.keySet()) {
//                if(preJob == classNo) flag = true;
//                if(max < map.get(classNo)) {
//                    key = classNo;
//                    max = map.get(classNo);
//                }
//            }
//            if(flag) key = preJob;
////            System.out.println(restJobs);
//
//            map.remove(key);
//
//            int start = curTime;
//            for(Job job : restJobs) {
//                if(job.classNo != key) continue;
////                System.out.println(job);
//                start = Math.max(start, job.volumn + curTime);
//            }
//            curTime = start;
//
//            for(int i = restJobs.size() - 1; i >= 0; i--) {
//                if(restJobs.get(i).classNo == key) restJobs.remove(i);
//            }
//            if(preJob != key) answerList.add(key);
//            preJob = key;
//        }
//        int[] answer = new int[answerList.size()];
//        for(int i = 0; i < answerList.size(); i++) {
//            answer[i] = answerList.get(i);
//        }
//        return answer;
//    }
//
//    static class Job {
//        int id;
//        int start;
//        int volumn;
//        int classNo;
//        int importance;
//
//        public Job(int id, int start, int volumn, int classNo, int importance) {
//            this.id = id;
//            this.start = start;
//            this.volumn = volumn;
//            this.classNo = classNo;
//            this.importance = importance;
//        }
//
//        @Override
//        public String toString() {
//            return "Job{" +
//                    "id = " + id +
//                    ", start=" + start +
//                    ", volumn=" + volumn +
//                    ", classNo=" + classNo +
//                    ", importance=" + importance +
//                    '}';
//        }
//    }

//    public int solution(int[] rooms) {
//        int answer = 0;
//        n = rooms.length;
//        visited = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            if(visited[i]) continue;
//            dfs(rooms, i);
//            answer++;
//        }
//
//        return answer;
//    }
//
//    private void dfs(int[] rooms, int start) {
//        visited[start] = true;
//        if(visited[rooms[start]]) return;
//        dfs(rooms, rooms[start]);
//    }
//
//    private int n;
//    private boolean[] visited;



//    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
//        int answer = 0;
//
//        for(int t = 0; t < months; t++) {
//            int rest = getRest(money);
//            int prop = money - rest;
//
//            int rate = 0;
//
//            if(prop >= threshold) {
//                rate = getRate(prop, threshold, ranksize, minratio);
//                if(rate > maxratio) rate = maxratio;
//            }
//            int taken = prop * rate / 100;
//            prop = prop - taken + rest;
//            System.out.println("rate = " + rate + ", taken = " + taken + ", prop = " + prop);
//
//            money = prop;
//        }
//
//        return money;
//    }
//
//    private int getRate(int money, int threshold, int rankSize, int minRatio) {
//        return (money - threshold) / rankSize + minRatio;
//    }
//
//    private int getRest(int money) {
//        return money % 100;
//    }

//    public int[] solution(String logs) {
//        int[] answer = new int[24];
//        for(String log : logs.split("\n")) {
//            String[] pre = log.split(" ");
//            String[] time = pre[1].split(":");
//
//            answer[korTime(Integer.parseInt(time[0]))]++;
//        }
//        return answer;
//    }
//
//    public int korTime(int hour) {
//        return (hour + 9) % 24;
//    }
}
