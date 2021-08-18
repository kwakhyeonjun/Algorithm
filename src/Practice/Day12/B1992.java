package Practice.Day12;

import java.io.*;

public class B1992 {
    private static int[][] matrix;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for(int i = 0; i < N; i++){
            String st = br.readLine();
            for(int j = 0; j < N; j++){
                matrix[i][j] = st.charAt(j) - '0';
            }
        }
        quad(N, 0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void quad(int N, int x, int y){
        int mid = N/2;
        int c = matrix[x][y];
        boolean isSame = true;
        loop:
        for(int i = x; i < x + N; i++){
            for(int j = y; j < y + N; j++){
                if(c != matrix[i][j]){
                    isSame = false;
                    break loop;
                }
            }
        }
        if(isSame){
            sb.append(c);
        }else{
            sb.append("(");
            quad(mid, x, y);
            quad(mid, x, y + mid);
            quad(mid, x + mid, y);
            quad(mid, x + mid, y + mid);
            sb.append(")");
        }
    }
}
