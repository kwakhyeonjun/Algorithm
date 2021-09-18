package Practice.part01.Day07;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= 10; test_case++){
            int n = Integer.parseInt(br.readLine());

            Stack<Integer>[] stack = new Stack[n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    if(stack[j] == null) stack[j] = new Stack<>();
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp != 0) {
                        stack[j].add(temp);
                    }
                }
            }

            int count = 0;
            for(int i = 0; i < n; i++){
                int top = 0;
                if(stack[i].size() < 2) continue;
                while(stack[i].size() > 1){
                    if((top = stack[i].pop()) == 2 && stack[i].peek() == 1) count++;
                }
            }

            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
