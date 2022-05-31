package Test.Toss;

public class Sol2 {
    public static void main(String[] args) {
        int[] a = {1, 6};
        int[] b = {3, 5};
        int duration = 1;
        int distance = 2;
        System.out.println(solution(a, b, duration, distance));
    }

    /**
     * 외출 가능 시간 안에 집에서 나와서 약속장소에서 만나고 외출 가능 시간이 끝나기 전에 집에가야함.
     *  !! 먼저 나와서 기다리기 가능 !!
     * 수직선으로 distance만큼, 1에 1시간걸림.
     * 집에서 만나더라도 둘 다 외출 가능한 시간일 때에만 가능.
     *
     * 풀이
     * 1) 가능 불가능 판단
     * a의 이동가능거리 = a[1] - a[0] = dist(a)라 하면,
     * a가 더 빨리 출발한다고 할 때,
     * 1-1)
     *  b[0] > a[1] - distance + duration - 1이면 불가능
     *  a[1] < diff
     * 두 사람의 이동가능 거리의 차 = pos(dist(a), dist(b)) = pos,
     * 두 사람의 출발 시간 차 = diff(a, b) = diff,
     * 이떄, (pos + diff - duration)/2 <= distance일 때, 두 사람이 만날 수 있다.
     *
     * 2) 가장 빨리 만날 수 있는 시간
     * diff >= distance인 경우, late[0]
     * diff < distance인 경우, late[0] + Math.round(distance/2)
     */
    public static int solution(int[] a, int[] b, int duration, int distance) {
        int answer = 0;

        // 1) 가능/불가능 판단

        // 출발 순서 확인
        boolean late = false; // 0: a, 1: b
        if(a[0] > b[1]) {
            late = true;
        }

        // 물리적인 시간 확인
        if(!late) { // a가 먼저 출발
            if(b[0] > a[1] - distance - duration) return -1;
        }else {
            if(a[0] > b[1] - distance - duration) return -1;
        }

        // 이동 가능 거리 확인
        int[] dist = new int[2];
        dist[0] = a[1] - a[0];
        dist[1] = b[1] - b[0];

        int pos;
        int diff;
        // a가 더 빠른경우
        if(!late) {
            pos = dist[0] - dist[1];
            diff = b[0] - a[0];
        }
        else {
            pos = dist[1] - dist[0];
            diff = a[0] - b[0];
        }

        if(!((diff - duration)/2 <= distance)) return -1;

        int addition = (int)Math.round((double) (distance - diff) / 2);

        // 2) 가장 빨리 만날 수 있는 시간
        // 2-1) 이동 거리가 시간 차이보다 적은 경우 먼저 이동가능
        if(diff >= distance) return late?a[0]:b[0];
        // 2-1) 이동거리가 시간 차이보다 큰 경우
        else return late?a[0]+addition:b[0]+addition;
    }
}
