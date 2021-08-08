package AlgoStudy.Week01;

import java.util.HashSet;

public class Poncketmon {
    public static void main(String[] args) {
        int max;
    }

    public static int solution(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int n = nums.length/2;
        if(set.size() > n){
            return n;
        }else {
            return set.size();
        }
    }
}
