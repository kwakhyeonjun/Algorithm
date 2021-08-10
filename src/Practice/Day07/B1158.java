package Practice.Day07;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> circle = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            circle.add(i);
        }

        bw.write("<");
        int idx = 0;
        while(!circle.isEmpty()){
            idx = (idx -1 + k)%n;
            bw.write(String.valueOf(circle.get(idx)));
            circle.remove(idx);
            if(circle.size() != 0) bw.write(", ");
            n--;
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}
