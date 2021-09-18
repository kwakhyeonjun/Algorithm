package AlgoStudy.Week06;

public class Picture {
    public static void main(String[] args) {
        Picture cur = new Picture();
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(cur.solution(n, data));
    }

    private int n;
    private String characters = "ACFJMNRT";
    private boolean[] visited = new boolean[8];
    private char[][] cases;

    public int solution(int n, String[] data) {
        this.n = n;
        cases = new char[n][5];
        for(int i = 0; i < data.length; i++){
            for (int j = 0; j < 5; j++) {
                cases[i][j] = data[i].charAt(j);
            }
        }
        perm(0);

        return answer++;
    }

    private char[] picked = new char[8];
    private int answer = 0;

    private void perm(int count){
        if(count == 8){
            if(parseCase()){
                answer++;
            }
        }else{
            for(int i = 0; i < 8; i++){
                if(visited[i]) continue;
                visited[i] = true;
                picked[count] = characters.charAt(i);
                perm(count+1);
                visited[i] = false;
            }
        }
    }

    private boolean parseCase(){
        for(int i = 0; i < n; i++){
            char char1 = cases[i][0];
            char char2 = cases[i][2];
            int term = cases[i][4] - '0';
            int curTerm = Math.abs(getTerm(char1, char2));
            switch (cases[i][3]){
                case '=':
                    if(curTerm != term) return false;
                    break;
                case '<':
                    if(curTerm >= term) return false;
                    break;
                case '>':
                    if(curTerm <= term) return false;
                    break;
            }
        }
        return true;
    }

    private int getTerm(char char1, char char2){
        for(int j = 0; j < 8; j++){
            if(picked[j] == char1 || picked[j] == char2){
                for (int k = j + 1; k < 8; k++) {
                    if(picked[k] == char1 || picked[k] == char2){
                         return k - j - 1;
                    }
                }
            }
        }
        return -1;
    }
}
