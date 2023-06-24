package Programmers.ret;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class P1833 {
    public static void main(String[] args) {
        P1833 sol = new P1833();
        int solution = sol.solution(4, new int[][]{{0, 0}, {1, 10}, {0, 20}, {2, 0}});
        System.out.println(solution);
    }
    /**
     * 풀이
     *  1. 해당 문자열의 범위는 [0, 2^31 -1]로 배열로 선언할 수 없고, iter하기 어려움
     *  2. 때문에 가능한 x, y좌표들을 모두 구한 뒤, 이를 순서에 따라 list에 저장하므로써 값을 압축할 수 있다.
     *  3. 이는 전체 data의 범위가 5000개 이하이므로 가능.
     *  4. 압축을 통해 구해진 각 x, y의 값으로 data의 값을 치환
     *  5. 압축한 값들을 iter하면서 segment tree 혹은 DP와 같은 형태로 쐐기의 개수를 누적해 저장합니다.
     *  6. 누적을 위해 쐐기가 있는 위치는 1로 초기화합니다.
     *  7. 이후 i, j의 위치에서 쐐기의 누적 개수 S[i][j]는 s[i-1][j] + S[i][j-1] - S[i - 1][j - 1]로 구할 수 있습니다.
     *  8. s[i-1][j]는 s[i-1][j-1]의 수를 포함하며, s[i][j-1] 또한 s[i-1][j-1]의 수를 포함합니다.
     *  9. 따라서 s[i][j]의 수는 s[i-1][j] + s[i][j-1]에서 s[i-1][j-1]을 빼야 합니다.
     * 10. 이렇게 누적한 값을 통해 (0, 0)부터 i, j까지의 누적 개수를 segment tree의 형태와 같이 계산해 구할 수 있습니다.
     * 11. 이때 i, j에서 k, l까지의 범위의 내부에 쐐기 개수를 구하기 위해 s[k][l] - s[k][j-1] - s[i-1][l] + s[i-1][j-1]을 사용합니다.
     * 12. s[i-1][j-1]을 더하는 부분은 위의 8, 9의 설명과 같습니다.
     * 13. 이렇게 계산한 결과가 0이라면 해당 구역에 쐐기가 없다고 판단할 수 있습니다.
     * 14. 계산된 이차원 배열 s를 활용해서 이제 한 쌍의 쐐기를 선택하고 내부에 쐐기가 있는지 판단할 수 있습니다.
     * 15. 때문에 2개의 쐐기를 iter로 선택하고 선택한 쐐기 내부의 위치를 특정해 해당 구역에 쐐기가 있는지 판단해 문제를 해결합니다.
     */
    public int solution(int n, int[][] data) {
        int answer = 0;

        // 좌표 압축
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for(int[] cur : data) {
            listX.add(cur[0]);
            listY.add(cur[1]);
        }

        // hash를 통해 중복을 제거하고, 각각의 값을 list로 다시 저장
        List<Integer> minListX = new ArrayList<>(new HashSet<>(listX));
        List<Integer> minListY = new ArrayList<>(new HashSet<>(listY));

        // 중복을 제거한 list를 순서대로 정렬합니다. 이렇게 완성된 minList는 각 값의 index로 설정할 수 있습니다.
        minListX.sort(Comparator.naturalOrder());
        minListY.sort(Comparator.naturalOrder());
        // 해설에서는 Collections를 사용하나, list.sort가 권장되기에 위와 같이 작성합니다.

        // 배열의 "최대" 크기는 x와 y의 최대 개수 n과 동일합니다.
        int[][] map = new int[n][n];

        for(int[] cur : data) {
            int x = minListX.indexOf(cur[0]);
            int y = minListY.indexOf(cur[1]);
            // 해설에서 new Integer(cur[0])을 통해 index를 찾고 있지만, Integer(int)는 deprecated된 Constructor이며, 오토박싱이 적용될 수 있으므로 cur[0]만 작성합니다.

            // data의 값을 압축한 좌표로 변환합니다.
            cur[0] = x;
            cur[1] = y;

            // 압축한 좌표를 활용해 해당 위치의 쐐기를 초기화 합니다.
            map[x][y] = 1;
        }

        // map의 전체 위치를 순회하면서 쐐기의 누적합을 기록합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += (i - 1 >= 0 ? map[i-1][j] : 0)
                           + (j - 1 >= 0 ? map[i][j-1] : 0)
                           - (i - 1 >= 0 && j - 1 >= 0 ? map[i-1][j-1] : 0);
                // 이때 i-1, j-1과 같은 범위를 확인해야하기 떄문에 연산된 값이 범위 내인지 확인한 후, 범위 밖(경계)인 경우 0으로 계산합니다.
            }
        }

        // 한 쌍의 쐐기를 반복문을 통해 선택합니다.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 중복 없이 선택하기 위해 i+1부터 선택함에 유의합니다.

                // 직사각형이 아닌 경우 텐트가 완성될 수 없습니다.
                if(data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;

                // 내부에 쐐기가 존재하는지 확인하기 위해 먼저 내부 위치를 특정합니다.
                int startX = Math.min(data[i][0], data[j][0]);
                int startY = Math.min(data[i][1], data[j][1]);
                int endX = Math.max(data[i][0], data[j][0]);
                int endY = Math.max(data[i][1], data[j][1]);

                // 각 지정된 x, y좌표는 내부가 아닌 경계입니다. 경계에는 쐐기가 존재하는 것이 가능하므로 내부의 위치로 지정해줍니다.
                startX++;
                startY++;
                endX--;
                endY--;

                // 만약 내부의 세로 혹은 가로가 1칸 떨어져 위치한다면 index의 위치가 꼬여있습니다. 해당 경우 가능한 것으로 판단 가능합니다.
                if(startX > endX || startY > endY) answer++;

                // 또한 연산을 통해 내부의 쐐기의 수가 0인 경우 텐트 설치 가능합니다.
                else if(map[endX][endY] - map[startX - 1][endY] - map[endX][startY - 1] + map[startX - 1][startY - 1] == 0) answer++;
            }
        }

        return answer;
    }
}
