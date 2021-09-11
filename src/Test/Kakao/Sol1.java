package Test.Kakao;

import java.util.StringTokenizer;

public class Sol1 {

    /**
     * 서로 다른 유저를 계속해서 신고할 수 있음
     * 한 유저를 여러번 신고할 수 있지만, 동일한 유저에 대한 신고는 1회만 2차원 boolean 배열
     * k번 이상 신고된 유저는 즉시 정지, 정지된 이용자도 신고 가능
     *
     * @param id_list
     * @param report
     * @param k
     * @return
     */
    public int[] solution(String[] id_list, String[] report, int k) {
        int length = id_list.length;
        // 신고 여부 저장
        boolean[][] repoTable = new boolean[length][length];

        // 각 report 순회하면서 repoTable 저장함
        for(int i = 0; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            int fromIdx = -1;
            String to = st.nextToken();
            int toIdx = -1;
            for (int j = 0; j < length; j++) {
                if(id_list[j].equals(from)) fromIdx = j;
                if(id_list[j].equals(to)) toIdx = j;
            }
            repoTable[fromIdx][toIdx] = true;
        }

        // repoTable 순회하면서 신고당한 횟수 저장
        int[] repoResult = new int[length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(repoTable[j][i]) repoResult[i]++;
            }
        }

        // 신고당한 횟수가 k번 이상인 경우 메일 전송
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            if(repoResult[i] >= k){
                for(int j = 0; j < length; j++){
                    if(repoTable[j][i]) answer[j]++;
                }
            }
        }

        return answer;
    }
}
