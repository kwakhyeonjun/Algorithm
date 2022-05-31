package Test.Line.sec;

public class Sol1 {



    public static void main(String[] args) {
        String[] logs = {"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", " team_name : db application_name : dbtest error_level : info message : test", "team_name : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"};
        System.out.println(solution(logs));
    }

    /**
     * 로그 수집 프로그램
     * - team_name : t application_name : a error_level : e message: m 형식
     * 각각 한칸의 공백으로 구분되어야 함.
     * t, a, e, m은 알파벳으로만 이루어진 길이 1 이상의 문자열
     * 로그의 길이는 100 이하여야함.
     * 수집하지 않는 로그의 개수 return
     */
    public static int solution(String[] logs) {
        int answer = 0;

        String[] logName = {"team_name", "application_name", "error_level", "message"};

        for(String log : logs) {
            System.out.println(answer);
            boolean isAnswer = false;
            if(log.length() > 100) {
                answer++;
                continue;
            }
            for(int i = 0; i < 4; i++) {
                if(!log.contains(logName[i])) {
                    isAnswer = true;
                    break;
                }
                log = log.replace(logName[i], "");
            }
            if(isAnswer){
                answer++;
                continue;
            }
            log = log.replace(" : ", "");

            log = log.toLowerCase();
            System.out.println(log);

            String[] st = log.split(" ");
            if(st.length != 4) {
                answer++;
                continue;
            }

            for(int i = 0; i < log.length(); i++) {
                if(log.charAt(i) != ' ' && (log.charAt(i) < 97 || log.charAt(i) > 122)) {
                    answer++;
                    break;
                }
                if(i < log.length() -1 && log.charAt(i) == ' ' && log.charAt(i+1) == ' ') {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

}
