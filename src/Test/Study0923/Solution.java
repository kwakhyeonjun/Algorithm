package Test.Study0923;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//        System.out.println(Arrays.toString(sol.solution(5, info)));

//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] reports = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        int k = 2;

//        System.out.println(Arrays.toString(sol.solution(id_list, reports, k)));
    }

//    public int[] solution(int n, int[] info) {
//        ryan = new int[11];
//        apeach = new int[11];
//    }
//
//    private int[] ryan;
//    private int[] apeach;
//
//    private void dfs(int[] info, int n, int start, int count) {
//        if(count == n) {
//            int ryanSum = 0, apeachSum = 0;
//            for(int i = 0 ; i < 11; i++) {
//                if(info[i] != 0 || ryan[i] != 0) {
//                    if(info[i] < ryan[i]) {
//                        ryanSum += 10 - i;
//                    } else {
//                        apeachSum += 10 - i;
//                    }
//                }
//                if(ryanSum > apeachSum && ryanSum - apeachSum > max) {
//
//                }
//            }
//        }
//        for(int i = start; i < 11; i++) {
//            ryan[i]++;
//            dfs(info, n, i, count + 1);
//            ryan[i]--;
//        }
//    }

//    public int[] solution(int[] fees, String[] records) {
//        Map<String, Record> recordMap = new HashMap<>();
//        for(String record : records) {
//            String[] cur = record.split(" ");
//            int time = getTime(cur[0]);
//            String car = cur[1];
//            String log = cur[2];
//            if(!recordMap.containsKey(car)) recordMap.put(car, new Record());
//            Record curRecord = recordMap.get(car);
//            if("IN".equals(log)) {
//                curRecord.in = time;
//            } else {
//                curRecord.totTime += time - curRecord.in;
//                curRecord.in = -1;
//            }
//        }
//
//        int LAST_TIME = getTime("23:59");
//
//        Object[] keys = recordMap.keySet().toArray();
//        Arrays.sort(keys);
//
//        int[] answer = new int[recordMap.size()];
//        int idx = 0;
//
//        for(Object thisKey : keys) {
//            String key = (String) thisKey;
//            // 남은차량
//            Record curRecord = recordMap.get(key);
//            if(recordMap.get(key).in != -1){
//                curRecord.totTime += LAST_TIME - curRecord.in;
//            }
//
//            // 금액 계산
//            answer[idx] = fees[1];
//            curRecord.totTime -= fees[0];
//            if(curRecord.totTime < 0) {
//                idx++;
//                continue;
//            }
//
//            answer[idx++] += fees[3] * Math.ceil((double)curRecord.totTime / fees[2]);
//        }
//        return answer;
//    }
//
//    private int getTime(String time) {
//        String[] split = time.split(":");
//        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
//    }
//    static class Record {
//        int in;
//        int totTime;
//    }

//    public int solution(int n, int k) {
//        int answer = 0;
//        String kNum = getKNum(n, k);
//        String[] pList = kNum.split("0");
//        for(String cur : pList) {
//            if("".equals(cur) || !isPrime(Long.parseLong(cur))) continue;
//            answer++;
//        }
//        return answer;
//    }
//
//    private boolean isPrime(long n) {
//        if(n < 2) return false;
//        for(int i = 2; i <= Math.sqrt(n); i++) {
//            if(n % i == 0) return false;
//        }
//        return true;
//    }
//
//    private String getKNum(int n, int k) {
//        StringBuilder sb = new StringBuilder();
//        while(n > 0) {
//            sb.append(n%k);
//            n /= k;
//        }
//        return sb.reverse().toString();
//    }

//    public int[] solution(String[] id_list, String[] report, int k) {
//        Set<String> set = new HashSet<>(Arrays.asList(report));
//        Map<String, Info> infos = new HashMap<>();
//        Map<String, Integer> idMap = new HashMap<>();
//
//        int idx = 0;
//        for(String id : id_list) {
//            infos.put(id, new Info());
//            idMap.put(id, idx++);
//        }
//        for(String cur : set) {
//            String[] split = cur.split(" ");
//            Info curInfo = infos.get(split[1]);
//            curInfo.count++;
//            curInfo.reporter.add(split[0]);
//        }
//
//        int[] answer = new int[id_list.length];
//
//        for(String key : infos.keySet()) {
//            Info info = infos.get(key);
//            if(info.count < k) continue;
//            for(String repo : info.reporter) {
//                answer[idMap.get(repo)]++;
//            }
//        }
//
//        return answer;
//    }
//
//    static class Info {
//        int count;
//        List<String> reporter;
//
//        Info() {
//            this.reporter = new ArrayList<>();
//        }
//    }
}
