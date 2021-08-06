package SWEA.D3;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            Queue<String> a = new LinkedList<>();
            Queue<String> b = new LinkedList<>();

            for(int i = 0; i < n; i++){
                if(n%2==1){
                    if(i<=arr.length/2){
                        a.add(arr[i]);
                    }else{
                        b.add(arr[i]);
                    }
                }else{
                    if(i < arr.length/2){
                        a.add(arr[i]);
                    }
                    else b.add(arr[i]);
                }
            }

            sb.append("#").append(test_case).append(" ");
            while(a.size() != 0 || b.size() != 0){
                if(a.size() == 0) {
                    sb.append(b.poll()).append(" ");
                    break;
                }
                if(b.size() == 0){
                    sb.append(a.poll()).append(" ");
                    break;
                }
                sb.append(a.poll()).append(" ").append(b.poll()).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
