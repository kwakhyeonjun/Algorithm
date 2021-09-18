package Test.Line;

import java.util.HashMap;
import java.util.Map;

public class Sol2 {

    public static void main(String[] args) {
        String s = solution(new String[]{"yxxy", "xxyyy"}, 2, 1);
        System.out.println(s);
    }

    /**연속된 n일동안 최소 k번
     * 같은 연속된 n일동안
     * 2 n k번 이상 검색 된 경우 이슈검색어
     * @param research  전월 사용자들의 검색 기록을 일 기준으로 나눈 값
     * @param n         일
     * @param k         번
     * @return
     */
    public static String solution(String[] research, int n, int k) {

        int[][] word = new int[26][research.length + 2];
        boolean[] isIssue = new boolean[26];

        for(int i = 0; i < research.length; i++){
            for(int j = 0; j < research[i].length(); j++){
                char cur = research[i].charAt(j);
                word[cur-'a'][i]++;
            }
        }


        int search = research.length;
        int searchCount = research.length + 1;
        int issue = 2*n*k;
        for(int i = 0; i < 26; i++){
            int count = 0;
            for(int j = 0; j < research.length; j++){
                if(word[i][j] >= k){
                    word[i][search] += word[i][j];
                    word[i][searchCount]++;
                    count++;
                }else{
                    if(count >= n) isIssue[i] = true;
                    count = 0;
                }

                int sum = 0;
                for(int l = j; l < j + n; l++){
                    sum += word[i][l];
                }
                if(sum >= issue) isIssue[i] = true;


//                if(count >= n && !isIssue[i]) isIssue[i] = true;
            }
        }

        int idx = -1;
        int max = 0;
        for(int i = 0; i <26; i++){
            if(word[i][search] >= issue && word[i][searchCount] > max && isIssue[i]){
                idx = i;
                max = word[i][searchCount];
            }
        }

        if(idx == -1) return "None";
        else return String.valueOf((char)('a' + idx));
    }
}
