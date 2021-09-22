package AlgoStudy.Week07;

public class Compression {
    public static void main(String[] args) {
        Compression sol = new Compression();
        String s = "ababcdcdababcdcd";
        int answer = sol.solution(s);
        System.out.println(answer);
    }

    public int solution(String s) {
        int answer = 1001;
        for(int length = 1; length < s.length()/2; length++){
            int count = 1;
            String comp = "";
            for(int i = 0; i <= s.length() - length; i++){
                String cur = s.substring(i, i + length);
                if(i > s.length() - 2 * length) {
                    if(count == 1) comp += cur;
                    else comp += count + cur;
                    count = 1;
                    break;
                }
                String next = s.substring(i + length, i + 2 * length);
                if(i == 0 && !cur.equals(next)) break;

                System.out.println(cur + "," + next);
                if(cur.equals(next)){
                    i += length - 1;
                    count++;
                    System.out.println(count + cur);
                }else {
                    if (count == 1) comp += cur;
                    else comp += count + cur;
                    count = 1;
                }
            }
            System.out.println(comp);
//            if(comp.isBlank()) continue;
            answer = Math.min(answer, comp.length());
        }
        return answer;
    }
}