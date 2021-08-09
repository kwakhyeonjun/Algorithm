package Practice.Day06;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= 10; test_case++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<String> list = new LinkedList<>();
            for(int i = 0; i < n; i++){
                list.add(st.nextToken());
            }
            int T = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int t = 0; t < T; t++){
                String input = st.nextToken();
                if(input.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int i = 0; i < y; i++){
                        list.add(x++, st.nextToken());
                    }
                }
            }
            bw.write("#" + test_case + " ");
            for(int i = 0; i < 10; i++){
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
