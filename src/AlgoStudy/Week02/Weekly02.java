package AlgoStudy.Week02;

public class Weekly02 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{70, 70, 70, 70}, {50, 50, 50, 50}, {70, 70, 70, 70}, {50, 50, 50, 50}}));
    }

    /**
     * 조건
     * 1. score[i][j] = i번 학생이 매긴 j번 학생의 점수
     * 2. 자기 자신을 평가한 점수가 유일한 최고점 혹은 유일한 최저점인 경우 그 점수는 제외한다.
     * 3. 평균을 구한 뒤 각 기준에 맞춰 학점을 부여함.
     * @param scores
     * @return
     */
    public static String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < scores.length; i++){
            // 점수 확인
            double sum = 0;
            double avg = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean isOnlyMax = false;
            boolean isOnlyMin = false;
            for(int j = 0; j < scores[i].length; j++){
                int currentScore = scores[j][i];
                sum += currentScore;
                if(min >= currentScore){
                    if(i == j) isOnlyMin = true;
                    else isOnlyMin = false;
                    if(min == currentScore) isOnlyMin = false;

                    min = currentScore;
                }
                if(max <= currentScore){
                    if(i == j) isOnlyMax = true;
                    else isOnlyMax = false;
                    if(max == currentScore) isOnlyMax = false;

                    max = currentScore;
                }
            }
            if(isOnlyMax || isOnlyMin){
                avg = (sum - scores[i][i])/(scores.length-1);
            }else{
                avg = sum/scores.length;
            }
            sb.append(getGrade(avg));
        }
        return sb.toString();
    }

    private static String getGrade(double avg){
        if(avg >= 90) return "A";
        else if(avg >= 80) return "B";
        else if(avg >= 70) return "C";
        else if(avg >= 50) return "D";
        else return "F";
    }
}
