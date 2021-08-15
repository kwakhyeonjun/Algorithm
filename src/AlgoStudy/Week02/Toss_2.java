package AlgoStudy.Week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 로드밸런서
 *
 * 조건
 * 1. 1번부터 N번 서버까지 순차적으로 전달
 * 2. if(stiky == true) then 이전에 분배된 서버로 요청이 분배되어야함.
 * 3. request -> server에 요청하는 숫자
 *
 * 정리
 * 1. 각 서버는 1번 원소부터 N번째 원소까지 확인하며 지정
 * 2. 각 서버는 request.length/servers 개수만큼 담당함
 * 3. 각 서버마다 담당한 request 목록이 필요함. >> sticky 경우 담당할 수 있도록
 */
public class Toss_2 {
    public static void main(String[] args) {
        int[][] arr = solution(3, true, new int[]{1, 2, 2, 3, 4, 1});

        for(int i = 0; i < 2; i++){
            System.out.print(Arrays.toString(arr[i]) + " ");
        }
    }

    public static int[][] solution(int servers, boolean sticky, int[] requests) {
//        int[][] tempAnswer = new int[servers][requests.length/servers];
//        int[] serverAddIdx = new int[servers];

        ArrayList<Integer>[] tempAnswer = new ArrayList[servers];
        for(int i = 0; i <servers; i++){
            tempAnswer[i] = new ArrayList();
        }

        int[][] answer = new int[servers][];

        // 각 request가 어떤 server에 있는지 확인하기 위한 배열
        int[] requestInServer = new int[requests.length];

        int serverIdx = 0; // 서버를 확인할 인덱스
        for(int requestIdx = 0; requestIdx < requests.length; requestIdx++){
            if(sticky && requestIdx != 0){
                boolean isSticky = false;
                for(int i = 0; i < requestIdx; i++){
                    if(requests[i] == requests[requestIdx]) {
                        int server = requestInServer[i];
//                        tempAnswer[server][serverAddIdx[server]++] = requests[requestIdx];
                        tempAnswer[server].add(requests[requestIdx]);
                        requestInServer[requestIdx] = server;
                        if(serverIdx == 0) serverIdx = servers - 1;
                        else serverIdx--;
                        isSticky = true;
                        break;
                    }
                }
                if(!isSticky) {
//                    tempAnswer[serverIdx][serverAddIdx[serverIdx]++] = requests[requestIdx];
                    tempAnswer[serverIdx].add(requests[requestIdx]);
                    requestInServer[requestIdx] = serverIdx;
                }
            }else{
//                tempAnswer[serverIdx][serverAddIdx[serverIdx]++] = requests[requestIdx];
                tempAnswer[serverIdx].add(requests[requestIdx]);
                requestInServer[requestIdx] = serverIdx;
            }
            serverIdx = (serverIdx+1)%servers;
        }

        for(int i = 0; i < servers; i++){
            answer[i] = new int[tempAnswer[i].size()];
            for(int j = 0; j < tempAnswer[i].size(); j++){
                answer[i][j] = tempAnswer[i].get(j);
            }
        }
        return answer;
    }
}
