package Test.NaverFinantial;


import java.util.Arrays;

public class Sol1 {
    public static void main(String[] args) {
        Sol1 sol = new Sol1();

        int[][] re = {{0, 2}, {0, 3}, {1, 0}, {1, 1},{1, 2}, {2, 0}, {2, 1}, {2, 3}, {3, 2}};
        int s1 = 2;
        int s2 = 3;
        int[] s = sol.solution(re, s1, s2);
        System.out.println(s[0] + ", " + s[1]);
    }

    /**
     * 입사시험 점수에 따라 분류
     * -Junior : Senior, Expert가 아닌 입사자
     * -Senior : Expert에 해당하지 않는 입사자 중 경력기간이 s1년 이상이거나 입사시험 점수가 s2점 이상인 입사자
     * -Expert : 경력기간이 e1년 이상이면서 e2점 이상인 입사자
     * s1과 s2가 정해진 상태에서, e1, e2를 정해야함.
     * 0 < Expert 수 < Senior 수 < Junior 수
     * e1 + e2의 값이 가능한 커야함.
     *
     * @author Kwak Hyeonjun
     * @param recruits : 리스트
     * @param s1 : 경력기간
     * @param s2 : 점수
     * @return {e1, e2}
     */
    public int[] solution(int[][] recruits, int s1, int s2) {
        int e1 = Integer.MAX_VALUE, e2 = Integer.MAX_VALUE, junior = 0, senior = 0;

        // Junior를 제외한 지원자들 (Expert + Senior)
        for(int i = 0; i < recruits.length; i++) {
            int[] cur = recruits[i];
            if(cur[0] < s1 && cur[1] < s2) junior++;
        }


        // 점수와 경력기간의 합을 기준으로 sort
        Arrays.sort(recruits, (o1, o2) -> {
            if((o1[0] < s1 || o1[1] < s2) && (o2[0] < s1 || o2[1] < s2))
                return o1[0] + o1[1] - o2[0] - o2[1];
            if(o1[0] < s1 || o1[1] < s2) return -1;
            if(o2[0] < s1 || o2[1] < s2) return 1;
            return o1[0] + o1[1] - o2[0] - o2[1];
        });

        // 각 배열의 점수를 확인하면서 가장 높은 점수가 되는 부분을 찾음
        // 이때 Senior의 수가 더 많아야 함에 주의
        int MAX = Integer.MIN_VALUE;
        for(int i = junior; i < recruits.length; i++) {
            if(senior < recruits.length - senior - junior){
                senior++;
                continue;
            }
            int[] cur = recruits[i];
            if(MAX <= cur[0] + cur[1]) {
                MAX = cur[0] + cur[1];
                e1 = Math.min(cur[0], e1);
                e2 = Math.min(cur[1], e2);
            }
            senior++;
        }

        return new int[] {e1, e2};
    }
}
