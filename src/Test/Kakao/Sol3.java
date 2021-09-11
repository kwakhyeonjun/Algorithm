package Test.Kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sol3 {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, int[]> chargeMap = new HashMap<>();
        Map<Integer, Integer> timeMap = new HashMap<>();
        StringTokenizer st = null;

        // 출입 시간 파싱 후 해쉬맵 저장
        for(String record : records){
            st = new StringTokenizer(record, " ");
            String time = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            String inout = st.nextToken();

            st = new StringTokenizer(time, ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            if("IN".equals(inout)){
                chargeMap.put(num, new int[]{hour, min});
            }else{
                int[] inTime = chargeMap.get(num);
                chargeMap.remove(num);
                int chargeTime = (hour - inTime[0]) * 60 + min - inTime[1];

                if(timeMap.containsKey(num)){
                    chargeTime += timeMap.get(num);
                }
                timeMap.put(num, chargeTime);
            }
        }

        // 파싱된 출입시간으로부터 시간 저장
        for(Map.Entry<Integer, int[]> entry : chargeMap.entrySet()){
            int num = entry.getKey();
            int[] inTime = entry.getValue();
            int chargeTime = (23 - inTime[0])*60 + 59 - inTime[1];
            if(timeMap.containsKey(num)){
                chargeTime += timeMap.get(num);
            }
            timeMap.put(num, chargeTime);
        }

        for(Map.Entry<Integer, Integer> entry : timeMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

            // 시간 기준으로 요금 부과
        int[][] chargeTable = new int[timeMap.size()][2];
        int chargeTableIndex = 0;
        for(Map.Entry<Integer, Integer> entry : timeMap.entrySet()){
            int num = entry.getKey();
            int chargeTime = entry.getValue();
            if(chargeTime <= fees[0]){ // 기본요금 시간보다 작은경우
                chargeTable[chargeTableIndex++] = new int[]{num, fees[1]};
            }else{ // 기본시간 이상
                int charge = fees[1] + (int)Math.ceil((double)(chargeTime - fees[0])/fees[2]) * fees[3];
                chargeTable[chargeTableIndex++] = new int[]{num, charge};
            }
        }

        Arrays.sort(chargeTable, (o1, o2) -> o1[0] - o2[0]);

        int[] answer = new int[chargeTable.length];
        int answerIdx = 0;
        for(int[] charge : chargeTable){
            answer[answerIdx++] = charge[1];
        }
        return answer;
    }
}
