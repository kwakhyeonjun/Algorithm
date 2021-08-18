package Practice.Day12;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 조건
 * 1. 지도의 가로, 세로 크기는 10이다.
 * 2. 사용자는 총 2명이며, 사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발한다.
 * 3. 총 이동 시간 M은 20이상 100이하의 정수이다. (20 ≤ M ≤ 100)
 * 4. BC의 개수 A는 1이상 8이하의 정수이다. (1 ≤ A ≤ 8)
 * 5. BC의 충전 범위 C는 1이상 4이하의 정수이다. (1 ≤ C ≤ 4)
 * 6. BC의 성능 P는 10이상 500이하의 짝수이다. (10 ≤ P ≤ 500)
 * 7. 사용자의 초기 위치(0초)부터 충전을 할 수 있다.
 * 8. 같은 위치에 2개 이상의 BC가 설치된 경우는 없다. 그러나 사용자A, B가 동시에 같은 위치로 이동할 수는 있다. 사용자가 지도 밖으로 이동하는 경우는 없다.
 */

class BC{
    int x;
    int y;
    int c;
    int p;
    int connect;

    public BC(int x, int y, int c, int p){
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }
}

class Person{
    int x;
    int y;
    int connectBC;

    public Person(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class SWEA5644 {
    private static int[][] direction = {{0,0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 이동하지 않음, 상, 우, 하, 좌
    private static BC[] BCList;
    private static int M, A, totCharge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            totCharge = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 이동 시간
            A = Integer.parseInt(st.nextToken()); // BC의 개수
            int[] moveA = new int[M]; // A의 이동
            int[] moveB = new int[M]; // B의 이동
            // A이동 저장
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            // B이동 저장
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            // BC의 정보 저장
            BCList = new BC[A];
            for(int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                BCList[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(BCList, ((o1, o2) -> o1.p - o2.p));
            Person personA = new Person(1, 1);
            Person personB = new Person(10, 10);

            for(int i = 0; i < M; i++){
                charge(personA, personB);
                move(personA, moveA, i);
                move(personB, moveB, i);
            }
            charge(personA, personB);
            bw.write("#" + test_case + " " + totCharge + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void charge(Person personA, Person personB){
        // person A에 대해 연결할 수 있는 BC 확인
        List<Integer> connectableBC_A = getConnectableBC(personA);
        List<Integer> connectableBC_B = getConnectableBC(personB);
        if(connectableBC_A.size() > connectableBC_B.size()){
            addTotCharge(connectableBC_B, personB);
            addTotCharge(connectableBC_A, personA);
        }else{
            addTotCharge(connectableBC_A, personA);
            addTotCharge(connectableBC_B, personB);
        }
    }

    private static List<Integer> getConnectableBC(Person person) {
        int x;
        int y;
        x = person.x;
        y = person.y;
        // person이 연결하던 BC 연결을 끊음 - 매번 초기화
        if(BCList[person.connectBC].connect != 0) BCList[person.connectBC].connect--; // BC에서 초기화
        person.connectBC = 0; // 현재 person의 연결 초기화

        List<Integer> connectableBC = new ArrayList<>();
        for (int i = 0; i < A; i++) { // 모든 BC에 대해 확인
            BC currentBC = BCList[i];
            int distance = getDistance(x, y, currentBC.x, currentBC.y); // 현재 위치와 BC사이의 거리
            if (distance <= currentBC.c) { // 현재 위치가 충전 범위 안인 경우
                connectableBC.add(i);
            }
        }
        return connectableBC;
    }

    private static void addTotCharge(List<Integer> connectableBC, Person person){
        if(connectableBC.size() == 0) return; // 충전할 수 없는 경우
        else if(connectableBC.size() == 1){ // 충전할 수 있는 BC가 1개인 경우
            int idx = connectableBC.get(0);
            person.connectBC = idx; // person에 연결된 BC 저장
            if(BCList[idx].connect > 0){
                return;
            }
            BCList[idx].connect++; // BC에 연결된 person수 추가
            totCharge += BCList[idx].p; // BC에서 충전가능한 양만큼 충전
        }else{ // 충전할 수 있는 BC가 여러개인 경우
            int max = 0; // minValue
            int maxIdx = -1;

            for(int i = 0; i < connectableBC.size(); i++){ // 모든 connectable BC 순회
                int idx = connectableBC.get(i);
                if(BCList[idx].connect > 0) continue; // 하나 이상 연결된 경우 두 사용자에게 충전을 나누어줘도 totCharge는 변하지 않음. 즉, 굳이 나누지 않고 진행
                else{
                    int chargable = BCList[idx].p;
                    if(chargable > max){
                        maxIdx = idx;
                        max = chargable;
                    }
                }
            }// 가장 충전 효율이 좋은 BC를 찾음.
            if(maxIdx == -1) return;
            person.connectBC = maxIdx; // person에 연결된 BC 저장
            BCList[maxIdx].connect++; // BC에 연결된 person 수 저장
            totCharge += max; //
        }
    }
//    /**
//     * 1. find available BC & save idx
//     * 2. if(idx.size() == 1) connect BC(idx) & totCharge += currentBC.p
//     * 3. else find currentBC.p/connect == MAX; >>>> no need to calculate charging efficiency.
//     * !. if both person charge at same BC
//     *      then totCharge has nothing good point ( same value )
//     *    so, if(BC.connect == 1) continue;
//     * @param person current person
//     */
//    private static void charge(Person person){
//        // person의 위치
//        int x = person.x;
//        int y = person.y;
//
//        // person이 연결하던 BC 연결을 끊음 - 매번 초기화
//        if(BCList[person.connectBC].connect != 0) BCList[person.connectBC].connect--; // BC에서 초기화
//        person.connectBC = 0; // 현재 person의 연결 초기화
//
//        // BC에 연결할 수 있는지 확인
//        List<Integer> connectableBC = new ArrayList<>();
//        for(int i = 0; i < A; i++){ // 모든 BC에 대해 확인
//            BC currentBC = BCList[i];
//            int distance = getDistance(x, y, currentBC.x, currentBC.y); // 현재 위치와 BC사이의 거리
//            if(distance <= currentBC.c){ // 현재 위치가 충전 범위 안인 경우
//                connectableBC.add(i);
//            }
//        }
//
//        // 연결할 수 있는 BC의 수에 따라 다르게 진행함.
//        if(connectableBC.size() == 0) return; // 충전할 수 없는 경우
//        else if(connectableBC.size() == 1){ // 충전할 수 있는 BC가 1개인 경우
//            int idx = connectableBC.get(0);
//            person.connectBC = idx; // person에 연결된 BC 저장
//            BCList[idx].connect++; // BC에 연결된 person수 추가
//            totCharge += BCList[idx].p/BCList[idx].connect; // BC에서 충전가능한 양만큼 충전
//        }else{ // 충전할 수 있는 BC가 여러개인 경우
//            int max = 0; // minValue
//            int maxIdx = -1;
//
//            for(int i = 0; i < connectableBC.size(); i++){ // 모든 connectable BC 순회
//                int idx = connectableBC.get(i);
//                if(BCList[idx].connect > 0) continue; // 하나 이상 연결된 경우 두 사용자에게 충전을 나누어줘도 totCharge는 변하지 않음. 즉, 굳이 나누지 않고 진행
//                else{
//                    int chargale = BCList[idx].p;
//                    if(chargale > max){
//                        maxIdx = i;
//                        max = chargale;
//                    }
//                }
//            }// 가장 충전 효율이 좋은 BC를 찾음.
//
//            person.connectBC = maxIdx; // person에 연결된 BC 저장
//            BCList[maxIdx].connect++; // BC에 연결된 person 수 저장
//            totCharge += max; //
//        }
//    }

    /**
     * each person can move with move[] & person's coordinate
     * person's move at idx min
     * @param person 움직일 사람
     * @param move 이동 방향이 저장된 int[]
     * @param idx 현재 시간
     */
    private static void move(Person person, int[] move, int idx){
        int x = person.x;
        int y = person.y;
        int currentMove = move[idx];
        person.x = x + direction[currentMove][0];
        person.y = y + direction[currentMove][1];
    }

    private static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
