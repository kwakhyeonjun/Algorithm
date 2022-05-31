package Test.Line.sec;

public class Sol2 {

    public static void main(String[] args) {
        String[] sentences = {"line in line", "LINE", "in lion"};
        int n = 5;
        System.out.println(solution(sentences, n));
    }


    /**
     * 대문자인 경우 shift키 필요함.
     * 문자열 배열에 있는 문자열을 완성하면 문자열의 길이만큼 점수를 받음.
     * 대문자가 있는 경우 대문자 개수만큼 점수를 얻음.
     * 스페이스바도 점수에 포함.
     *
     */
    public static int solution(String[] sentences, int n) {
        maxPoint = 0;
        maxKey = n;
        boolean[] visited = new boolean[sentences.length];
        for(int i = 1; i <= sentences.length; i++) {
            comb(sentences, visited, 0, sentences.length, i);
        }

        return maxPoint;
    }

    private static int maxPoint, maxKey;

    public static void comb(String[] sentences, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int point = 0;
            int keyCount = 0;
            boolean[] keys = new boolean[27];
            for(int i = 0; i < n; i++) {
                if(!visited[i]) continue;

                point += sentences[i].length();

                for(char c : sentences[i].toCharArray()) {
                    if(c == ' ') continue;
                    if(c >= 65 && c <= 90) {
                        keys[26] = true;
                        c += 32;
                        point++;
                    }
                    keys[c-97] = true;
                }
            }
            for(int j = 0; j < 27; j++) {
                if(keys[j]) keyCount++;
            }
            if(keyCount > maxKey) return;
            maxPoint = Math.max(point, maxPoint);
            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            comb(sentences, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
