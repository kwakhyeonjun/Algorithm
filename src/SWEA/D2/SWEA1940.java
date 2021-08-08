package SWEA.D2;


import java.io.*;
import java.util.StringTokenizer;

public class SWEA1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int n = Integer.parseInt(br.readLine());
            int speed = 0;
            int distance = 0;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int input = Integer.parseInt(st.nextToken());
                switch (input){
                    case 0:
                        distance += speed;
                        break;
                    case 1:
                        speed += Integer.parseInt(st.nextToken());
                        distance += speed;
                        break;
                    case 2:
                        speed -= Integer.parseInt(st.nextToken());
                        if(speed <= 0) speed = 0;
                        distance += speed;
                        break;
                }
            }
            bw.write("#" + test_case + " " + distance + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
