package AlgoStudy.Week07;

public class Plus {
    public int solution(int[] numbers) {
        boolean[] tot = new boolean[10];
        for(int v : numbers) tot[v] = true;
        int answer = 0;
        for(int i = 0; i < 10; i++)
            if(!tot[i]) answer += i;
        return answer;
    }
}
