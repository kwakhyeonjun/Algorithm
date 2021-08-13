package Baekjoon.Grade.Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 조건
 * 1. 궁수는 3명
 * 2. 한칸에 한명의 궁수만
 * 3. 각 턴에 각 궁수는 하나의 적을 공격(3명이 모두 동시에 공격함)
 * 4. D이하인 적 중 가장 가까운 적
 * 5. 4번 조건이 여러명인경우 가장 왼쪽에 있는 적을 공격
 * 6. 같은 적이 여러 궁수에게 공격당할 수 있음
 * 7. 공격받은 적은 게임에서 제외
 * 8. 궁수의 공격이 끝나면 적이 아래로 한칸 이동함
 * 9. 성이 있는 칸(N+1)으로 이동한 경우 게임에서 제외
 * 10. 모든 적이 격자판에서 제외되면 끝남.
 */
public class B17135 {
    private static int N, M, D, maxKill = Integer.MIN_VALUE; // n: 세로길이 / m: 가로길이 / D: 사거리 / maxKill: 최대 킬 수
    private static int kill; // 현재 킬 수
    private static int archerIdx; // 몇번째 궁수인지 확인
    private static int[][] map; // 지도
    private static int[] archer = new int[3]; // 궁수 위치
    private static int[] place; // 각 적의 위치
    private static int deadMonster[][]; // 각 궁수가 선택한 몬스터
    private static boolean[] isDeadMonster;

    public static void main(String[] args) throws IOException {
        // 입력객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        place = new int[M];
        for(int i = 0; i < M; i++){
            place[i] = i;
        }
        setArcher(0, 0);

        bw.write(String.valueOf(maxKill));
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 조합을 활용하여 궁수가 있을 위치(archer)을 저장함.
     * 가로길이(M) 중 궁수(3)이 있을 수 있는 위치 확인
     * 궁수가 위치한 자리를 2로 저장
     * 이후 각 궁수에 맞게 적을 공격함. (attack())
     * 공격 후에 적이 한칸씩 아래로 이동
     * @param count 횟수
     * @param start 시작위치
     */
    private static void setArcher(int count, int start){
        if(count == 3){
            int[][] tempMap = new int[N+1][M];
            for(int i= 0; i < N; i++){
                tempMap[i] = Arrays.copyOf(map[i], M);
            }
            for(int i = 0; i < 3; i++){
                tempMap[N][archer[i]] = 2; // 궁수의 위치를 2로 저장
            }
            kill = 0;
            deadMonster = new int[3][2];
            isDeadMonster = new boolean[3];
            while(!isNoEnemy(tempMap)){
//                print(tempMap);
                setArcher(tempMap);
                killMonster(tempMap);
                moveEnemy(tempMap); // 적이 한칸씩 이동
            }
            maxKill = Math.max(maxKill, kill);
            return;
        }else{
            for(int i = start; i < M; i++){ // map의 가로위치 중 어디에 궁수를 놓을지 정함.
                archer[count] = place[i]; // 가능한 위치(place)중 하나를 궁수의 위치(archer[])로 지정
                setArcher(count + 1, i + 1);
            }
        }
    }

    private static void killMonster(int[][] map) {
        for(int i = 0; i < 3; i++){
            if(!isDeadMonster[i]) continue;
            int x = deadMonster[i][0];
            int y = deadMonster[i][1];
            if(map[x][y] == 1){
                kill++;
            }
            map[x][y] = 0;
        }
    }

    private static void print(int[][] map){
        for(int i = 0; i < N + 1; i++){
            for(int j = 0; j < M; j++ ){
                System.out.print(map[i][j]);;
            }
            System.out.println();
        }
        System.out.println(kill);
        System.out.println();
    }

    /**
     * map을 순회하여 적이 있는지 확인
     * @param map 궁수가 저장된 맵
     * @return
     */
    private static boolean isNoEnemy(int[][] map){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }

    /**
     * 궁수마다 공격할 적을 지정
     * 궁수의 위치를 확인하면 해당 궁수가 적을 공격(killMonster(map, archer)
     * @param map 각 궁수에 맞춰 새로운 맵이 필요하므로 깊은복사한 tempMap을 받음
     */
    private static void setArcher(int[][] map){
        // 모든 궁수가 공격
        archerIdx = 0;
        for(int archer = 0; archer < M; archer++){
            if(map[N][archer] == 2){ // 궁수가 있는 경우
                // map을 순회하며 사거리 내에 적이 있는지 확인
                chooseMonster(map, archer);
                archerIdx++;
            }
        }
    }
    
    /**
     * 궁수의 공격이 끝난 후 적의 위치를 한칸씩 아래로 이동
     * 중복을 막기 위해 제일 아래 행(N-1)부터 순회
     * 이동 후 적의 위치가 성벽(N)인 경우 게임에서 제외
     * 아닌 경우 아래로 한칸 이동
     * @param map
     */
    private static void moveEnemy(int[][] map){
        for(int i = N-1; i >= 0; i--){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    if(i + 1 != N){ // 움직여서 성벽에 도달하지 않는 경우만 아래로 이동
                        map[i+1][j] = 1;
                    }
                }
            }
        }
    }

    /**
     * "각" 궁수에서 사거리 내에 있는 적을 발견하면 해당 적을 선택함. (궁수 한명의 공격)
     * 이때 2중for문을 통해 오른쪽 아래부타 순회하므로 제일 위의 왼쪽 적부터 처리할 수 있다.
     * 가장 많은 적을 처리하기 위해 성벽과 가까운 적부터 처리함.
     * @param map 각 궁수에 맞춰 새로운 맵이 필요하므로 깊은복사한 tempMap을 받음
     * @param archer 각 궁수의 위치를 받음
     */
    private static void chooseMonster(int[][] map, int archer) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                int distance = getDistance(N, archer, i, j);
                // Kill log Event
                if (map[i][j] == 1 && distance <= D && minDistance >= distance) { // 사거리 이내에 적이 있다면 == 적을 발견한 경우
                    if(minDistance > distance){
                        minDistance = Math.min(minDistance, distance);
                        isDeadMonster[archerIdx] = true;
                        deadMonster[archerIdx][0] = i;
                        deadMonster[archerIdx][1] = j;
                    }else{
                        if(deadMonster[archerIdx][1] > j){
                            minDistance = Math.min(minDistance, distance);
                            isDeadMonster[archerIdx] = true;
                            deadMonster[archerIdx][0] = i;
                            deadMonster[archerIdx][1] = j;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 격자판의 두 위치의 거리
     * @param x1 첫 위치 x
     * @param y1 첫 위치 y
     * @param x2 다른 위치 x
     * @param y2 다른 위치 y
     * @return 두 위치 사이의 거리
     */
    private static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
