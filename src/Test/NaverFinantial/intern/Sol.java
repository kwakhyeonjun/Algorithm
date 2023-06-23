package Test.NaverFinantial.intern;

public class Sol {



//    public int[] solution(int[][] gates, int[] airlines) {
//
//    }

//    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
//        int[] answer = new int[2];
//        for(int i = 0; i < periods.length; i++) {
//            int curSum = 0;
//            for(int p : payments[i]) {
//                curSum += p;
//            }
//
//            boolean prevStatus = isVIP(periods[i], curSum);
//            boolean nextStatus = isVIP(periods[i] + 1, curSum + estimates[i]);
//            if(!prevStatus && nextStatus) answer[0]++;
//            else if(prevStatus && !nextStatus) answer[1]++;
//        }
//        return answer;
//    }
//
//    private boolean isVIP(int period, int payment) {
//        if(period >= 24 && period < 60 && payment >= 900_000) return true;
//        else return period >= 60 && payment >= 600_000;
//    }
}
