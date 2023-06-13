package Test.Kakao.Kakao0924;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

//    public int[] solution(int[][] edges, int[] target) {
//        int size = target.length;
//        boolean[][] map = new boolean[size][size];
//        boolean[][] curMap = new boolean[size][size];
//
//        for(int[] edge : edges) {
//            map[edge[0] - 1][edge[1] - 1] = true;
//        }
//
//        for(int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if(map[i][j]) {
//                    curMap[i][j] = true;
//                    break;
//                }
//            }
//        }
//
//        int count = 0;
//        for(int cur : target) {
//            if(cur != 0) count++;
//        }
//
//        for(int t = 0; t < count; t++) {
//            int endNode = getEndNode(curMap, map, 0);
//        }
//
//        int[] answer = {};
//        return answer;
//    }
//
//    private int getEndNode(boolean[][] curMap, boolean[][] map, int start) {
//        for(int i = 0; i < map.length; i++){
//            if(curMap[start][i]) {
//                curMap[start][i] = false;
//                boolean flag = false;
//                for(int j = start + 1; j < map.length; j++) {
//                    if(map[i][j]) {
//                        flag = true;
//                        curMap[i][j] = true;
//                    }
//                }
//                if(!flag) {
//                    for(int j = 0; j < map.length; j++) {
//                        if(map[i][j]) curMap[i][j] = true;
//                    }
//                }
//            }
//        }
//    }

//    public int[] solution(long[] numbers) {
//        int[] answer = {};
//        return answer;
//    }

//    public int[] solution(int[][] users, int[] emoticons) {
//        this.users = users;
//        this.emoticons = emoticons;
//        picked = new int[emoticons.length];
//        discountArr = new int[]{10, 20, 30, 40};
//        plusMax = 0;
//        paySumMax = 0;
//
//        dfs(0, 0);
//        return new int[]{plusMax, paySumMax};
//    }
//
//    private int[] emoticons, discountArr, picked;
//    private int[][] users;
//    private int plusMax, paySumMax;
//
//
//    private void dfs(int start, int count) {
//        if(count == emoticons.length) {
//            int[] pay = new int[users.length];
//            int plus = 0, paySum = 0;
//            for(int i = 0; i < users.length; i++) {
//                for(int j = 0; j < emoticons.length; j++)  {
//                    if(picked[j] >= users[i][0]) {
//                        pay[i] += emoticons[j]*(1 - (double)picked[j]/100);
//                    }
//                }
//                if(pay[i] >= users[i][1]) {
//                    pay[i] = 0;
//                    plus++;
//                }
//                paySum += pay[i];
//            }
//            if(plus > plusMax) {
//                plusMax = plus;
//                paySumMax = paySum;
//            }
//            else if(plus == plusMax && paySum > paySumMax) {
//                paySumMax = paySum;
//            }
//            return;
//        }
//        for(int i = start; i < emoticons.length; i++) {
//            for(int discount : discountArr) {
//                picked[i] = discount;
//                dfs(start + 1, count + 1);
//            }
//        }
//    }


//    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
//        answer = 0;
//
//        this.cap = cap;
//        this.n = n;
//        this.deliveries = deliveries;
//        this.pickups = pickups;
//
//        return answer;
//    }
//
//    long answer;
//    private int cap, n;
//    int[] deliveries, pickups;
//
//    private void dfs(int start) {
//
//    }

//    public int[] solution(String today, String[] terms, String[] privacies) {
//        List<Integer> answerList = new ArrayList<>();
//
//        Map<String, Integer> privacyMap = new HashMap<>();
//        for(String term : terms) {
//            String[] cur = term.split(" ");
//            privacyMap.put(cur[0], Integer.parseInt(cur[1]));
//        }
//
//        int[] todayArr = getDate(today);
//        long todayNum = getDateNum(todayArr);
//
//        for(int i = 0 ; i < privacies.length; i++) {
//            String[] cur = privacies[i].split(" ");
//
//            int[] curDateArr = getDate(cur[0]);
//            long dateNum = getDateNum(curDateArr);
//            dateNum += privacyMap.get(cur[1]) * 28 - 1;
//            if(dateNum < todayNum) answerList.add(i + 1);
//        }
//
//        int[] answer = new int[answerList.size()];
//        for(int i = 0; i < answerList.size(); i++) {
//            answer[i] = answerList.get(i);
//        }
//
//        return answer;
//    }
//
//    private int[] getDate(String input) {
//        String[] split = input.split("\\.");
//        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])};
//    }
//
//    private long getDateNum(int[] date) {
//        return (long) date[0] * 12 * 28 + date[1] * 28L + date[2];
//    }
}
