package Practice.part01.Day11;

import java.io.*;
import java.util.StringTokenizer;

public class B1074 {
    private static int count, r, c, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n = (int)(Math.pow(2, N));

        // r,c가 어느 위치인지 특정할 필요 있음


        z(n, 0, 0);
        bw.write(String.valueOf(count - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * x, y에서부터 시작하는 것으로 생각
     * mid = N/2
     * 각 파트별로 나누어 진행
     * @param N
     * @param x
     * @param y
     * @return
     */
    private static void z(int N, int x, int y){
        // 카운트 없이 수를 셀 방법 >> 2^(N-1) x 2^(N-1)개만큼 있음.

        if(N==1){
            count++;
            return;
        }
        int mid = N/2;
        int sum = mid*mid;
        if(r < x + mid){
            if(c < y + mid){
                z(N/2, x, y);
            }else{
                count += sum;
                z(N/2, x, y + mid);
            }
        }else{
            if(c < y + mid){
                count += 2*sum;
                z(N/2, x + mid, y);
            }else{
                count += 3*sum;
                z(N/2, x + mid, y + mid);
            }
        }
    }
}
