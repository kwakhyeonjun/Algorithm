package Test.Kakao;

public class Sol4 {
    /**
     * - 화살 쏘는 법
     * 1. 어피치가 화살 n발을 모두 쏜 후 라이언이 n발쏨.
     * 2. 점수를 계산함.
     * 3. 최종 점수가 더 높은 선수가 우승자. 최종 점수가 같은 경우 어피치가 우승
     *
     * - 점수 계산하는 법
     * 1. 기존에 사용하는 양궁판을 사용
     * 2. 만약 k점을 어피치가 a발 맟추고, 라이언이 b발 맞춘 경우 더 많은 화살을 k점에 맞힌 선수가 k점을 가져감
     *      - 한 점수에 여러발 맞춘 선수가 해당 점수 독식
     *      - 단, 두 선수가 같은 횟수 맞춘 경우에는 어피치가 점수를 가져감
     *      - 맞추지 않으면 아무도 점수 안가져감
     *      - k개 배열 사용해야할 듯
     * 3. 모든 과녁 점수에 대해 각 선수의 최종 점수 계산
     *
     * - 높은 점수를 더 많이 맞춘 경우를 return
     * - 우승 방법이 없는 경우 -1을 return
     *
     * 조합, 그런데 선택 갯수가 복잡한
     *
     * @param n     쏜 화살의 개수
     * @param info  어피치가 맞친 과녁(점수)
     * @return      라이언이 최대 점수차로 이길 수 있는 경우의 과녁
     */
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        comb(0, 10);
        if(answer == null) return new int[]{-1};
        return answer;
    }

    int n, max;
    int[] info;
    int[] result = new int[11];
    boolean[] visited = new boolean[11];
    int[] answer;
    /**
     * 과녁 11개 중 선택
     * @param count 쏜 화살 수
     * @param start 다음 화살
     */
    public void comb(int count, int start){
        if(count <= n){
            int rionSum = 0, apSum = 0;
            for(int i = 0; i < 11; i++){
                if(visited[i]) rionSum += 10 - i;
                if(!visited[i] && info[i] > 0) apSum += 10 - i;
            }

            if(rionSum > apSum && max < rionSum - apSum){
                answer = new int[11];
                max = rionSum - apSum;
                for(int i = 0; i < 11; i++){
                    if(visited[i]) answer[i] = result[i];
                }
                answer[10] += n - count;
            }
            if(count == n) return;
        }
        for(int i = start; i >= 0; i--){
            if(info[i] + 1 + count > n) continue;
            result[i] = info[i] + 1;
            visited[i] = true;
            comb(result[i] + count, i-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Sol4 sol = new Sol4();
        int[] res = sol.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
        for(int v : res) System.out.print(v + " ");
    }
}
