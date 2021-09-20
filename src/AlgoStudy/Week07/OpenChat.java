package AlgoStudy.Week07;

import java.util.*;

public class OpenChat {
    public static void main(String[] args) {
        OpenChat sol = new OpenChat();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = sol.solution(record);
        for(String s : result) System.out.print(s + " ");
    }

    public String[] solution(String[] record){
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < record.length; i++){
            String[] cur = record[i].split(" ");
            if(cur[0].equals("Leave")) continue;
            map.put(cur[1], cur[2]);
        }

        StringBuilder sb = null;
        for(int i = 0; i < record.length; i++){
            sb = new StringBuilder();
            String[] cur = record[i].split(" ");
            if(cur[0].equals("Change")) continue;
            sb.append(map.get(cur[1])).append("님이 ");
            if(cur[0].equals("Enter")) sb.append("들어왔습니다.");
            else sb.append("나갔습니다.");
            list.add(sb.toString());
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}
