package Test.Kakao.mobility;


public class Solution {
//    private static final long SEC = 60;
//    private static final long MIN = SEC * 60;
//    private static final long HOUR = MIN * 24;
//    private static final long DAY = HOUR * 30;
//    private static final long MONTH = DAY * 12;
//
//    public int[] solution(String s, String[] times) {
//        long start = getStartTime(s);
//        long today = start;
//        Set<Integer> set = new LinkedHashSet<>();
//        set.add((int) (start/ HOUR));
//
//        for(String t : times) {
//            today += getAddTime(t);
//            set.add((int) (today / HOUR));
//        }
//
//        int prev = (int) (start / HOUR);
//        boolean isEveryday = true;
//        for(int next : set) {
//            if(next - prev > 1) {
//                isEveryday = false;
//            }
//            prev = next;
//        }
//        return new int[]{isEveryday ? 1 : 0, (int)(prev - start / HOUR) + 1};
//    }
//
//    private long getStartTime(String s) {
//        String[] split = s.split(":");
//        int[] time = new int[6];
//        for(int i = 0; i < 6; i++) {
//            time[i] = Integer.parseInt(split[i]);
//        }
//        return time[5] + time[4] * SEC + (long) time[3] * MIN + (long) time[2] * HOUR + (long) time[1] * DAY + (long) time[0] * MONTH;
//    }
//
//    private long getAddTime(String s) {
//        String[] split = s.split(":");
//        int[] time = new int[4];
//
//        for (int i = 0; i < 4; i++) {
//            time[i] = Integer.parseInt(split[i]);
//        }
//
//        return time[3] + time[2] * SEC + time[1] * MIN + time[0] * HOUR;
//    }

//    public int solution(String[] id_list, int k) {
//        int answer = 0;
//
//        Map<String, Integer> map = new HashMap<>();
//
//        for(String id : id_list) {
//            Set<String> set = new HashSet<>(Arrays.asList(id.split(" ")));
//            for(String cur : set) {
//                map.put(cur, map.getOrDefault(cur, 0) + 1);
//            }
//        }
//
//        for(String key : map.keySet()) {
//            int coupon = map.get(key);
//            answer += Math.min(coupon, k);
//        }
//        return answer;
//    }

//    public int solution(int[][] flowers) {
//        int answer = 0;
//
//        boolean[] isFlower = new boolean[366];
//        for(int[] flower : flowers) {
//            for(int i = flower[0]; i < flower[1]; i++) {
//                isFlower[i] = true;
//            }
//        }
//        for(int i = 1; i < 366; i++) {
//            if(isFlower[i]) answer++;
//        }
//
//        return answer;
//    }
}
