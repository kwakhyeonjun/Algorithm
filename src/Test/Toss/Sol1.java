package Test.Toss;

public class Sol1 {
    public static void main(String[] args) {

        int k = 3;
        int m = 50000;
        String[] names = {"msLEE", "jsKim", "jsKIM", "jskiM", "jskim", "John", "john", "John", "msLEE", "msLEE", "jsKIM", "roy"};
        int[] amounts = {950, 52524, 1400, 6055, 10000, 4512, 512, 52000, 9000, 49000, 1400, 50000};
        System.out.println(solution(k, m, names, amounts));
    }

    /**
     * 둘 중 하나의 조건에 해당한다면 보의스피싱 주의 문자를 발송함.
     * 조건
     * 1. 같은 사람에게 k번 이상 연속으로 송금할 때
     *  - 사람 이름을 비교할 때, 대소문자는 구분하지 않음.
     *  - 해쉬 사용해야할 듯
     * 2. 송금액이 m원 이상일때
     * 두가지 조건이 모두 해당하면 한번만 보내면 됨.
     *
     * 문자가 발송되는 횟수 return
     */
    public static int solution(int k, int m, String[] names, int[] amounts) {

        int answer = 0;

        // 이름 모두 소문자로
        String[] lowerNames = new String[names.length];
        for(int i = 0; i < names.length; i++) lowerNames[i] = names[i].toLowerCase();

        // message를 보내는 경우 표시
        boolean isMessage;

        // 반복 표시
        int serial = 1;

        for(int i = 0; i < names.length; i++) {
            isMessage = false;

            // 조건 1. 같은사람에게 k번 이상
            // i가 1 이상이고, 이전에 같은 숫자라면 serial++
            if(i!=0 && lowerNames[i].equals(lowerNames[i-1])) {
                serial++;
                // 같은 사람으로 k번 연속으로 보낸 경우
                if(serial >= k){
                    isMessage = true;
                    answer++;
                }
            }else{ // 반복되지 않았으면 초기화
                serial = 1;
            }

            // 조건 1을 탐색한 후에 이미 메세지를 보냈다면, 금액은 살피지 않아도 됨.
            if(isMessage) continue;

            // 조건 2. 송금액이 m원 이상인 경우
            if(amounts[i] >= m) {
                answer++;
            }
        }

        return answer;
    }
}
