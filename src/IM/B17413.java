package IM;

import java.util.Scanner;
import java.util.Stack;

public class B17413 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '<') {
                isTag = true;
                while(!stack.isEmpty()) sb.append(stack.pop());
            }
            if(s.charAt(i) == '>'){
                isTag = false;
                sb.append(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ' '){
                while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
                continue;
            }
            if(isTag) sb.append(s.charAt(i));
            else stack.push(s.charAt(i));
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}
