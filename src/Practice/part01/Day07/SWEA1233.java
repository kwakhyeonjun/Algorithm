package Practice.part01.Day07;

import java.io.*;

public class SWEA1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int test_case = 1; test_case <= 10; test_case++){
            bw.write("#" + test_case + " ");
            int n = Integer.parseInt(br.readLine());
            int log = (int)(Math.log(n) / Math.log(2));
            int leafs = n - (int)Math.pow(2, log) + 1;
            int singleNode = (int)Math.pow(2, log-1) -leafs/2;
            int singleStart = n - leafs - singleNode;
            boolean isRight = true;
            for(int i =0; i < n; i++){
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                int a = Integer.parseInt(st.nextToken());
//                if(a <= singleStart + 1){
//                    String temp = st.nextToken();
//                    if(temp.charAt(0) != '+' && temp.charAt(0) != '-' && temp.charAt(0) != '*' && temp.charAt(0) != '/') {
//                        isRight = false;
//                    }
//                }else{
//                    String temp = st.nextToken();
//                    if(temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*' || temp.charAt(0) == '/') {
//                        isRight = false;
//                    }
//                }

                String[] arr = br.readLine().split(" ");
                if(arr.length == 4){
                    String temp = arr[1];
                    if(temp.charAt(0) != '+' && temp.charAt(0) != '-' && temp.charAt(0) != '*' && temp.charAt(0) != '/') {
                        isRight = false;
                    }
                }else if(arr.length == 2){
                    String temp = arr[1];
                    if(temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*' || temp.charAt(0) == '/') {
                        isRight = false;
                    }
                }
            }
            if(isRight) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
