package Test.MonthlyCodeChallenge;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    boolean[] isNums = new boolean[10];
    public int solution(int[] numbers) {
        int sum = 0;
        for(int v : numbers) isNums[v] = true;
        for(int i = 0; i < 10; i++){
            if(!isNums[i]) sum += i;
        }
        return sum;
    }
}
