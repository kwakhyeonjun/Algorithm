package AlgoStudy.Week06;

public class dart {
    public static void main(String[] args) {
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        int idx = -1;
        String zone = "_SDT";
        for(int i = 0; i < dartResult.length(); i++){
            char current = dartResult.charAt(i);
            if(current >= '0' && current <= '9'){
                if(current == '1' && dartResult.charAt(i+1) == '0'){
                    i++;
                    score[++idx] = 10;
                }else{
                    score[++idx] = current - '0';
                }
            }else if(zone.contains(String.valueOf(current))){
                score[idx] = (int)Math.pow(score[idx], zone.indexOf(current));
            }else{
                if(current == '*'){
                    for(int j = idx; j > idx - 2 && j >= 0; j--){
                        score[j] *= 2;
                    }
                }else{
                    score[idx] *= -1;
                }
            }
        }

        for(int v : score) answer += v;

        return answer;
    }
}
