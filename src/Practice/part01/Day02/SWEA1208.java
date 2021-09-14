package Practice.part01.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 해결방안
 *  1. 최대값과 최솟값을 찾음
 *  2. 평균값과 비슷하게 수를 맞춤
 *  3. 모두 평균값에 가깝게 1-2반복
 */
public class SWEA1208 {
    static int[] arr = new int[100];
    static int count;
    static int max = 99;
    static int min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            count = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            /*
             *  case 1. sort 후 배열의 앞/뒤부터 중앙으로 수를 맞춰나가는경우
             *  >> 차이 = 채우다 멈춘 부분 or 그 다음배열의 높이
             *  >> 반례 = 앞선 배열이 더 높을 수 있으므로 효율적이지 못함.
             *  >> 해결방안 = 앞의 높이를 비교하며, 앞의 높이와 같은 경우 같이 제거해야함.
             *
             *  case 2. sort 후 수를 맞춰나가면서 뒤에서 오는 경우에 앞의 수와 같다면 같이 빼나감.
             *  >> 차이 = 채우다 멈춘 부분의 높이 - 채우던 부분의 높이
             *  >> 반례 = avg가 무조건 옳은 높이가 되지 않음 >> 배열의 중심값은?
             *  >> 속도 = sort(O(nlogn))정도? x >> n^2 가능성 있음(sort 두번) ( n/2의 배열에 대해 각각 실행해야하는 경우가 발생할 수 있음 )
             *      >> 재귀랑 다를게 없음(하나씩 이동하는 상황이 발생할 수 밖에 없음
             *  >> 짜기 복잡한데...? >> 개손해
             *
             *  case 3. sort 최적화
             *  >> 최초 1회 정렬 후 값을 하나씩 확인(2에서 매번 sort하지 않고 반복함)
             *
             *  case 4. 재귀
             *  >> 제일 높은 것 >> 제일 낮은 것 한개씩 옮김 / avg 필요 없음 = 무조건 동일한 높이로 최적화 가능
             *  >> 반례 >> 있을 수가 없음(하나씩 이동)
             *  >> 속도 >> O(n^2)?
             *
             *
             */

            /*
             * case 2. sort 후 하나씩 줄이고 다시 sort - 반복
             */
//            Arrays.sort(arr);
//            for(int i = 0; i < count; i++){
//                if(arr[99] - arr[0] < 2) break;
//                if(--arr[99] - ++arr[0] < 2) break;
//                Arrays.sort(arr);
//            }
//            System.out.printf("#%d %d", test_case, (arr[99] - arr[0]));

            /*
             * case 3. sort 한번만 하고 각 data 확인하면서 정렬
             */


            /*
             * case 3. 재귀
             */
//            change(count);
//            int max = Integer.MIN_VALUE;
//            int min = Integer.MAX_VALUE;
//            for(int i = 0; i < 100; i++){
//                max = Math.max(max, arr[i]);
//                min = Math.min(min, arr[i]);
//            }
//            System.out.printf("#%d %d\n", test_case, max-min);
        }
    }

    /**
     * case 3. sort 최적화화
     */
    private static int solve(){
        Arrays.sort(arr);
        int max = 99;
        int min = 0;
        for(int i = 0; i < count; i++){
            int v = diff();
            if(v<2){
                return v;
            }
            arr[min]++;
            arr[max]--;

            changeMin();
            changeMax();
        }
        return diff();
    }
    private  static void changeMax(){
        if(arr[min] <= arr[min-1]) max = 99;
        else max--;
    }

    private static void changeMin(){
        if(arr[min] <= arr[min+1]) min = 0;
        else min++;
    }

    private static int diff(){
        return arr[99] - arr[0];
    }
   /**
     * case 4. 재귀
     * @param count
     */
    public static void change(int count){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIdx = 0;
        int minIdx = 0;
        for(int i = 0; i < 100; i++){
            if(max < arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
            if(min > arr[i]){
                min = arr[i];
                minIdx = i;
            }
        }
        if(count == 0) {
            return;
        }
        arr[maxIdx]--;
        arr[minIdx]++;
        change(count - 1);
    }
}
