package Programmers.SkillCheck;

import java.util.Arrays;

public class SkillCheck2_1_1 {
    public static void main(String[] args) {
        SkillCheck2_1_1 sol = new SkillCheck2_1_1();
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(sol.solution(numbers));
    }

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums);

        Arrays.sort(nums, (o1, o2) -> {
            int idx1 = 0, idx2 = 0;
            while(true) {
                if(idx1 == o1.length()) return 1;
                if(idx2 == o2.length()) return -1;
                if(o1.charAt(idx1) == o2.charAt(idx2)) {
                    idx1++;
                    idx2++;
                    continue;
                }
                return o2.charAt(idx2) - o1.charAt(idx1);
            }
        });

        for(String num : nums) answer.append(num);

        return answer.toString();
    }


}
