package Practice.Day08;

import java.io.*;
import java.util.StringTokenizer;

public class B16935 {

    private static int[][] arr;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < r; i++){
            console(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void console(int n){
        switch(n){
            case 1:
                upsideDown();
                break;
            case 2:
                reverse();
                break;
            case 3:
                right();
                break;
            case 4:
                left();
                break;
            case 5:
                clockwise();
                break;
            case 6:
                counterclockwise();
                break;
        }
    }

    private static void upsideDown(){
        int mid = n/2;
        for(int i = 0; i < mid; i++){
            for(int j = 0; j < m; j++){
                swap(i, j, n - i - 1, j);
            }
        }
    }

    private static void reverse(){
        int mid = m/2;
        for(int j = 0; j < mid; j++){
            for(int i = 0; i < n; i++){
                swap(i, j, i, m - j - 1);
            }
        }
    }

    private static void right(){
        int[][] tempArr = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                 tempArr[j][n-i-1] = arr[i][j];
            }
        }
        arr = tempArr;
        int temp = n;
        n = m;
        m = temp;
    }

    private static void left(){
        int[][] tempArr = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                tempArr[m-j-1][i] = arr[i][j];
            }
        }
        arr = tempArr;
        int temp = n;
        n = m;
        m = temp;
    }

    private static void clockwise(){
        int midX = n/2;
        int midY = m/2;
        int[][][] tempArr = new int[4][midX][midY];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i < midX && j < midY){
                    tempArr[0][i][j] = arr[i][j];
                }else if(i >= midX && j < midY){
                    tempArr[1][i%midX][j] = arr[i][j];
                }else if(i >= midX && j >= midY){
                    tempArr[2][i%midX][j%midY] = arr[i][j];
                }else{
                    tempArr[3][i][j%midY] = arr[i][j];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i < midX && j < midY){
                    arr[i][j] = tempArr[1][i][j];
                }else if(i >= midX && j < midY){
                    arr[i][j] = tempArr[2][i-midX][j];
                }else if(i >= midX && j >= midY){
                    arr[i][j] = tempArr[3][i-midX][j-midY];
                }else{
                    arr[i][j] = tempArr[0][i][j-midY];
                }
            }
        }
    }

    private static void counterclockwise(){
        int midX = n/2;
        int midY = m/2;
        int[][][] tempArr = new int[4][midX][midY];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i < midX && j < midY){
                    tempArr[0][i][j] = arr[i][j];
                }else if(i >= midX && j < midY){
                    tempArr[1][i%midX][j] = arr[i][j];
                }else if(i >= midX && j >= midY){
                    tempArr[2][i%midX][j%midY] = arr[i][j];
                }else{
                    tempArr[3][i][j%midY] = arr[i][j];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i < midX && j < midY){
                    arr[i][j] = tempArr[3][i][j];
                }else if(i >= midX && j < midY){
                    arr[i][j] = tempArr[0][i-midX][j];
                }else if(i >= midX && j >= midY){
                    arr[i][j] = tempArr[1][i-midX][j-midY];
                }else{
                    arr[i][j] = tempArr[2][i][j-midY];
                }
            }
        }
    }

    private static void swap(int x1, int y1, int x2, int y2){
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }


}
