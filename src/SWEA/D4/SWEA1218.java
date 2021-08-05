package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            stack.push(input.charAt(0));
            for(int i = 1; i < input.length(); i++){
                if(stack.isEmpty()) stack.push(input.charAt(i));
                else if(isPair(stack.peek(), input.charAt(i))) stack.pop();
                else stack.push(input.charAt(i));
            }
            System.out.print("#" + test_case + " ");
            if(stack.isEmpty()) System.out.println(1);
            else System.out.println(0);
        }
    }
    private static boolean isPair(char prev, char c){
        switch (c){
            case ')':
                if(prev == '(') return true;
                break;
            case ']':
                if(prev == '[') return true;
                break;
            case '}':
                if(prev == '{') return true;
                break;
            case '>':
                if(prev == '<') return true;
                break;
        }
        return false;
    }
}
