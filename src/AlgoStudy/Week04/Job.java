package AlgoStudy.Week04;

import java.util.StringTokenizer;

public class Job {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7, 5, 5};
        System.out.println(solution(table, languages, preference));
    }

    private static String[] language = new String[5];
    public static String solution(String[] table, String[] languages, int[] preference) {
        int[] score = new int[5];
        for(int i = 0; i < table.length; i++) {
            StringTokenizer st = new StringTokenizer(table[i]);
            language[i] = st.nextToken();
            for(int j = 0; j < 5; j++){
                String skill = st.nextToken();
                for(int k = 0; k < languages.length; k++){
                    if(skill.equals(languages[k]))
                        score[i] += (5 - j) * preference[k];
                }
            }
        }

        int sum = 0;
        int idx = 0;
        for(int i = 0; i < 5; i++){
            if(sum < score[i]){
                sum = score[i];
                idx = i;
            }
            if(sum == score[i] && language[idx].compareTo(language[i]) > 0){
                sum = score[i];
                idx = i;
            }
        }

        for(int i = 0; i < 5; i++){
            System.out.println(score[i]);
        }

        return language[idx];
    }
}
