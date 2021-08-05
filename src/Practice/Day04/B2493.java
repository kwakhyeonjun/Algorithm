package Practice.Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Tower> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int height = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(new Tower(i, height));
            }else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Tower(i, height));
                        break;
                    }
                    Tower temp = stack.peek();
                    if(temp.height > height){
                        sb.append(temp.idx + " ");
                        stack.push(new Tower(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

class Tower{
    int idx;
    int height;
    Tower (int idx, int height){
        this.idx = idx;
        this.height = height;
    }
}
