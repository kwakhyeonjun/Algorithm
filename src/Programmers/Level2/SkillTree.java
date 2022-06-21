package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {
    public static void main(String[] args) {
        SkillTree sol = new SkillTree();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(sol.solution(skill, skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree : skill_trees) {
            boolean flag = false;
            Queue<Character> queue = new LinkedList<>();
            for(char c : skill.toCharArray()) queue.add(c);
            for(char c : skill_tree.toCharArray()) {
                if(!queue.contains(c)) continue;
                if(queue.peek() != c) {
                    flag = true;
                    break;
                }
                queue.poll();
            }
            if(!flag) answer++;
        }
        return answer;
    }
}
