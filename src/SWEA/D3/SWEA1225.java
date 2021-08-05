package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < 8; i++){
                queue.add(Integer.parseInt(st.nextToken()));
            }

            out:
            while(true){
                for(int i = 1; i <= 5; i++){
                    if(queue.peek() - i <= 0){
                        queue.poll();
                        queue.add(0);
                        break out;
                    }else{
                        queue.add(queue.poll() - i);
                    }
                }
            }
            sb.append("#").append(test_case).append(" ");
            for(int v : queue) sb.append(v).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
