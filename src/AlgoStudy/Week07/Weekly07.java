package AlgoStudy.Week07;

import java.util.ArrayList;
import java.util.List;

public class Weekly07 {
    public static void main(String[] args) {
        Weekly07 sol = new Weekly07();

        int[] enter = {1, 4, 2, 3};
        int[] leave = {2, 1, 3, 4};
        int[] answer = sol.solution(enter, leave);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(int[] enter, int[] leave) {
        List<Integer> room = new ArrayList<>();
        boolean[][] view = new boolean[enter.length + 1][enter.length + 1];

        int enterIdx = 0, leaveIdx = 0;

        while(enterIdx != enter.length|| leaveIdx != leave.length){
//            if(!room.isEmpty()) room.add(enter[enterIdx++]);
            if(leaveIdx < leave.length && room.contains(leave[leaveIdx])) {
                room.remove(room.indexOf(leave[leaveIdx++]));
                continue;
            }
            if(enterIdx < enter.length) room.add(enter[enterIdx++]);
            for (int i = 0; i < room.size(); i++) {
                for (int j = 0; j < room.size(); j++) {
                    if(room.get(i) == room.get(j)) continue;
                    view[room.get(i)][room.get(j)] = true;
                }
            }
        }
        int[] answer = new int[enter.length];
        for(int i = 1; i < view.length; i++){
            for (int j = 1; j < view.length; j++) {
                if(view[i][j]) answer[i - 1]++;
            }
        }
        return answer;
    }
}
