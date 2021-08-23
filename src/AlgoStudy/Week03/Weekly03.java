package AlgoStudy.Week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Weekly03 {
    private static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static List<int[]> block;

    public static void main(String[] args) {
        int result = solution(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
                        {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
                        {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                        {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                        {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0},
                        {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0},
                        {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0},
                        {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}},
                new int[][]{
                        {1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
                        {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                        {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
                        {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
                        {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
                        {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                        {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},
                        {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                        {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}
                });
        System.out.println(result);
    }

    public static int solution(int[][] game_board, int[][] table) {
        int sum = 0; // 결과적으로 맞춘 블록의 수를 저장.
        List<List<int[]>> blocks = new ArrayList<>();

        // table에서 블록 찾기
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                if(table[i][j] == 1){ // 블록을 발견한 경우
                    block = new ArrayList<>();
                    findBlock(table, i, j, i, j, 1);
                    blocks.add(block);
                }
            }
        }

        // game_board에서 비어있는 블록을 확인하면, 모든 블록들을 회전하면서 확인한다.
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board[i].length; j++){
                if(game_board[i][j] == 0){ // 비어있는 블록을 확인한 경우
                    block = new ArrayList<>();
                    findBlock(game_board, i, j, i, j, 0); // 현재 비어있는 블록을 찾음
                    // 블록 리스트를 확인
                    for(int k = 0; k < blocks.size(); k++){
                        // 블록을 확인함
                        // 1. block 그대로
                        if(isEqual(block, blocks.get(k))){
                            sum += block.size();
                            blocks.remove(k);
                            break;
                        }

                        // 2. 90도씩 회전시키면서 블록 확인
                        for(int l = 0; l < 3; l++){
                            List<int[]> newBlock = rotate90(blocks.get(k));
                            if(isEqual(newBlock, block)){
                                sum += newBlock.size();
                                blocks.remove(k);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return sum;
    }

    private static boolean isEqual(List<int[]> block1, List<int[]> block2){
        if(block1.size() != block2.size()) return false;
        boolean[] isGot = new boolean[block1.size()];
        for(int i = 0; i < block1.size(); i++){
            for(int j = 0; j < block2.size(); j++){
                if(block1.get(i)[0] == block2.get(j)[0] && block1.get(i)[1] == block2.get(j)[1]) {
                    isGot[i] = true;
                    break;
                }
            }
            if(!isGot[i]) return false;
        }
        return true;
    }

    /**
     * 블록을 90도 회전
     * i = j, j = -i
     * @param block
     * @return
     */
    private static List<int[]> rotate90(List<int[]> block){
        List<int[]> rotateBlock = new ArrayList<>();
        for(int i = 0; i < block.size(); i++){
            int[] current = block.get(i);
            rotateBlock.add(new int[]{current[1], (-1)*current[0]});
        }
        return setRotateBlock(rotateBlock);
    }

    /**
     * 1. 제일 위에 있는 블록
     * 2. 제일 위에 여러 블록이라면, 가장 왼쪽에 있는 블록
     * 3. 이렇게 선택된 블록을 기준블록[0,0]으로 잡고, 블록의 상대위치를 다시 설정함.
     * @param block
     * @return
     */
    private static List<int[]> setRotateBlock(List<int[]> block){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < block.size(); i++){
            int[] one = block.get(i);
            if(minX > one[0]){
                minX = one[0];
                index = i;
            }
            if(minX == one[0] && minY > one[1]){
                minY = one[1];
                index = i;
            }
        }

        List<int[]> newBlock = new ArrayList<>();
        int x = block.get(index)[0];
        int y = block.get(index)[1];
        for(int i = 0; i < block.size(); i++){
            newBlock.add(new int[]{block.get(i)[0] - x, block.get(i)[1] - y});
        }
        return newBlock;
    }

    private static void printBlock(List<int[]> block){
        for(int i = 0; i < block.size(); i++){
            System.out.println(block.get(i)[0] + " " + block.get(i)[1]);
        }
    }

    /**
     * 블록이 있는 경우 주변의 블록을 묶어 하나의 블록 객체로 생성하는 매서드
     * 최초에 블록을 발견하면 해당 매서드 호출. 해당 [x,y]를 중신으로 사방의 블록을 찾고, 블록이 있다면 queue에 저장함.
     * 저장한 후 하나씩 방문하면서 주변의 블록을 탐색함.
     * 각 블록들은 처음으로 발견하는 블록을 [0,0]으로 하여, 상대적인 위치를 저장한다.
     *
     * @param table 주어진 블록들이 늘어져있는 table
     * @param firstX 최초에 블록에 진입한 좌표 x
     * @param firstY 최초에 블록에 진입한 좌표 y
     * @param x     x 위치
     * @param y     y 위치
     * @param b     0으로 표기된 블록 / 1로 표기된 블록
     */
    private static void findBlock(int[][] table, int firstX, int firstY, int x, int y, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        block.add(new int[]{x - firstX, y - firstY});
        if(b==0) table[x][y] = 1;
        else table[x][y] = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            // [nx, ny]가 테이블 안에 있고, 블록이 존재하는 경우 queue에 저장하고 블록에 포함
            if(isInMap(table, nx, ny) && table[nx][ny] == b){
                findBlock(table, firstX, firstY, nx, ny, b);
            }
        }
    }

    private static boolean isInMap(int[][] map, int x, int y){
        return (x >= 0 && x < map.length && y >= 0 && y < map[0].length);
    }
}
