package Test.Line;

public class Sol1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,0,0}, 1));
    }

    public static int solution(int[] student, int k) {
        int answer = 0;

        for(int i = 0; i < student.length; i++){
            for(int j = i; j < student.length; j++){
                int count = 0;
                for(int l = i; l <= j; l++){
                    if(student[l] == 1) count++;
                }
                if(count == k) answer++;
            }
        }
        return answer;
    }
}
