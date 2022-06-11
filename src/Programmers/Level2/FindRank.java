package Programmers.Level2;

public class FindRank {
    public static void main(String[] args) {
        FindRank sol = new FindRank();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = sol.solution(info, query);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[][] parseInfo = new String[info.length][5];
        for (int i = 0; i < info.length; i++) {
            parseInfo[i] = info[i].split(" ");
        }
        for (int q = 0; q < query.length; q++) {
            String[] curQuery = query[q].split(" and ");
            String[] last = curQuery[curQuery.length - 1].split(" ");
            curQuery[curQuery.length - 1] = last[0];
            int score = Integer.parseInt(last[1]);

            for (int i = 0; i < info.length; i++) {
                String[] curInfo = parseInfo[i];
                if(!isEqual(curQuery, curInfo)) continue;
                if(Integer.parseInt(curInfo[4]) < score) continue;

                answer[q]++;
            }
        }
        return answer;
    }

    private boolean isEqual(String[] query, String[] info) {
        for (int i = 0; i < 4; i++) {
            if(!query[i].equals("-") && !query[i].equals(info[i])) return false;

        }
        return true;
    }
}
