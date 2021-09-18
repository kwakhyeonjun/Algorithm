package Practice.part01.Day14;

import java.io.*;
import java.util.Stack;

public class SWEA1223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int test_case = 1; test_case <= 10; test_case++){
            int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            char[] postfix = new char[size];
            int idx = 0;
            //input to postfix operation
            for(int i = 0; i < size; i++){
                if(isNumber(input.charAt(i))){
                    postfix[idx++] = input.charAt(i);
                }else{
                    idx = operatorHandle(input, stack, postfix, idx, i);
                }
            }
            while(!stack.isEmpty()){
                postfix[idx++] = stack.pop();
            }
            //calculate
            bw.write("#" + test_case + " " + calculate(postfix) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isNumber(char input){
        if(input >= '0' && input <= '9') return true;
        else return false;
    }

    private static int calculate(char[] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(isNumber(arr[i])) stack.add(arr[i] - '0');
            else{
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                if(arr[i] == '+') stack.add(operand1 + operand2);
                else stack.add(operand1 * operand2);
            }
        }
        return stack.pop();
    }

    private static int operatorHandle(String input, Stack<Character> stack, char[] result, int idx, int i) {
        if(stack.isEmpty()) stack.add(input.charAt(i));
        else{
            if(input.charAt(i) == ('+')){
                result[idx++] = stack.pop();
                idx = operatorHandle(input, stack, result, idx, i);
            }else{
                if(stack.peek().equals('*')){
                    result[idx++] = stack.pop();
                    idx = operatorHandle(input, stack, result, idx, i);
                }else{
                    stack.add(input.charAt(i));
                }
            }
        }
        return idx;
    }
}
