package AlgoStudy.Week03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Crane {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}}, new int[]{1, 2, 3, 3, 2, 3, 1}));
    }
    public static int solution(int[][] board, int[] moves) {
        int count = 0;
        Queue<Integer>[] map = new LinkedList[board[0].length];
        for(int i = 0; i < board[0].length; i++){
            map[i] = new LinkedList<>();
        }
        for(int i = 0; i  < board[0].length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != 0)
                    map[i].add(board[j][i]);
            }
        }

        Stack<Integer> picked = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            if(picked.isEmpty()){
                if(map[moves[i]-1].isEmpty()) continue;
                picked.add(map[moves[i]-1].poll());
            }else{
                if(!map[moves[i]-1].isEmpty()) {
                    int current = map[moves[i] - 1].poll();
                    int past = picked.pop();
                    if (current != past) {
                        picked.add(past);
                        picked.add(current);
                    }else{
                        count += 2;
                    }
                }
            }
        }
        return count;
    }
}
