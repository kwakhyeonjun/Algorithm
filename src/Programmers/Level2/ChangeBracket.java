package Programmers.Level2;

import java.util.Stack;

public class ChangeBracket {
    public static void main(String[] args) {
        ChangeBracket sol = new ChangeBracket();
        String p = "()))((()";
        String answer = sol.solution(p);
        System.out.println(answer);
    }

    /**
     * 균형잡힌 괄호 문자열 : '('와 ')'의 개수가 같음
     * 올바른 괄호 문자열 : '('와 ')'의 짝이 모두 맞는 경우
     *  0)if(균형잡힌 괄호 문자열)
     *   then
     *  1) if("") then return ""
     *  2) w -> u, v (u : 균형잡힌 괄호 문자열"로 더이상 분리할 수 없음. v는 빈문자열일 수 있음
     *  3) if(u == 올바른괄호문자열) to 1
     *   3-1) 수행한 결과 문자열을 u에 이어붙인 후 반환
     *  4) else
     *   4-1) 빈 문자열에 '('
     * ??  4-2) 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 붙임.
     *   4-3) ')'를 다시 붙임
     *   4-4) ''u의 첫번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호방향을 뒤집어서 뒤에 붙임
     *   4-5) 생성된 문자열을 반환
     * @param p : 균형잡힌 괄호 문자열
     * @return answer : 올바른 괄호 문자열
     */
    public String solution(String p) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int pair = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') pair++;
            else pair--;

            sb.append(p.charAt(i));

            if(stack.isEmpty()) {
                stack.add(p.charAt(i));
            }else{
                char prev = stack.pop();
                char cur = p.charAt(i);
                if(prev != '(' || cur != ')') {
                    stack.add(prev);
                    stack.add(cur);
                }
            }

            if(pair == 0) {
                if(stack.isEmpty()) {
                    String u = sb.toString();
                    String v = solution(p.substring(i + 1));
                    return u + v;
                }
                StringBuilder tempBuilder = new StringBuilder();
                tempBuilder.append('(');
                String v = solution(p.substring(i + 1));
                tempBuilder.append(v);
                tempBuilder.append(')');
                for (int j = 1; j < sb.length() - 1; j++) {
                    if(sb.charAt(j) == ')') tempBuilder.append('(');
                    else tempBuilder.append(')');
                }
                return tempBuilder.toString();
            }
        }
        return sb.toString();
    }
}
