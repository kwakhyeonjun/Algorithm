package Baekjoon.Levels.level08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10757_ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char[] inputA = st.nextToken().toCharArray();
        char[] inputB = st.nextToken().toCharArray();
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        for(int i = 0; i < inputA.length; i++){
            stackA.push(inputA[i] - '0');
        }
        for(int i = 0; i < inputB.length; i++){
            stackB.push(inputB[i] - '0');
        }
        Stack<Integer> result = new Stack<>();
        int round = 0;
        while(stackA.isEmpty() == false || stackB.isEmpty() == false){
            int a = 0;
            int b = 0;
            if(stackA.isEmpty() == false){
                a=stackA.pop();
            }
            if(stackB.isEmpty() == false){
                b = stackB.pop();
            }
            int sum = (a+b + round)%10;
            round = (a+b + round)/10;
            result.push(sum);
        }
        if(round == 1) result.push(1);
        while(result.isEmpty() == false) System.out.print(result.pop());
    }
}
