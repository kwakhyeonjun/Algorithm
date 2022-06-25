package Programmers.SkillCheck;


public class SkillCheck2_2_1 {
    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));
    }
    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String temp = "";
        int min = Integer.MAX_VALUE;

        for(int t = 1; t < s.length()/2; t++){
            int idx = 0;
            while(idx < s.length()){
                boolean isFind = false;
                int count = 0;
                if(idx+t < s.length()){
                    temp = s.substring(idx, idx + t);
                    if(s.charAt(idx) == s.charAt(idx+t)){
                        count = 1;
                        for(int j = idx+t; j < s.length(); j += t){
                            if(temp.equals(s.substring(j, j+t))){
                                isFind = true;
                                count++;
                            }else{
                                idx = j;
                                break;
                            }
                            if(j == s.length() - t) idx = j + t;
                        }
                    }
                }
                if(isFind){
                    sb.append(count + temp);
                }else{
                    sb.append(s.charAt(idx));
                    idx += t;
                }
            }
            min = Math.min(min, sb.length());
            System.out.println(sb);
            sb.delete(0, sb.length());
        }
        return min;
    }
}
