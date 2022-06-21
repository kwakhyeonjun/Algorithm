package Programmers.Level2;

public class Quad {
    public static void main(String[] args) {
        Quad sol = new Quad();
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[] answer = sol.solution(arr);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public int[] solution(int[][] arr) {
        answer = new int[2];
        this.arr = arr;
        quadZip(0, 0, arr.length);
        return answer;
    }

    private int[] answer;
    private int[][] arr;

    private void quadZip(int x, int y, int n) {
        if(n == 1) {
            answer[arr[x][y]]++;
            return;
        }
        if(arrEquals(x, y, n)) {
            answer[arr[x][y]]++;
            return;
        }
        int mid = n / 2;
        // sec 1
        quadZip(x, y, mid);
        // sec 2
        quadZip(x, y + mid, mid);
        // sec3
        quadZip(x + mid, y, mid);
        // sec 4
        quadZip(x + mid, y + mid, mid);
    }

    private boolean arrEquals(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }
}
