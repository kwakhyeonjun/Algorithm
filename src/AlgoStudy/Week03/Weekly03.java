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
                        {1,1,0,0,1,0},
                        {0,0,1,0,1,0},
                        {0,1,1,0,0,1},
                        {1,1,0,1,1,1},
                        {1,0,0,0,1,0},
                        {0,1,1,1,0,0}},
                new int[][]{
                        {1,0,0,1,1,0},
                        {1,0,1,0,1,0},
                        {0,1,1,0,1,1},
                        {0,0,1,0,0,0},
                        {1,1,0,1,1,0},
                        {0,1,0,0,0,0}
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

        // 블록 저장 테스트 - Test Done
//        for(int i = 0; i < blocks.size(); i++){
//            printBlock(blocks.get(i));
//            System.out.println();
//        }

        // game_board에서 비어있는 블록을 확인하면, 모든 블록들을 회전하면서 확인한다.
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board[i].length; j++){
                if(game_board[i][j] == 0){ // 비어있는 블록을 확인한 경우
                    block = new ArrayList<>();
                    findBlock(game_board, i, j, i, j, 0); // 현재 비어있는 블록을 찾음
//                    printBlock(block);
//                    System.out.println();
                    // 블록 리스트를 확인
                    for(int k = 0; k < blocks.size(); k++){
//                        printBlock(block);
//                        System.out.println();
//                        printBlock(blocks.get(k));
//                        System.out.println();
                        // 블록을 확인함
                        // 1. block 그대로
                        if(isEqual(block, blocks.get(k))){
                            sum += block.size();
                            blocks.remove(k);
                            break;
                        }
                        // 2. 90도 회전 - j, i
                        block = rotate90(block);
                        if(isEqual(block, blocks.get(k))){
                            sum += block.size();
                            blocks.remove(k);
                            break;
                        }

                        // 3. 180도 회전 - -i, -j
                        block = rotate180(block);
                        if(isEqual(block, blocks.get(k))){
                            sum += block.size();
                            blocks.remove(k);
                            break;
                        }

                        // 4. 270도 회전 - -j, -i
                        block = rotate270(block);
                        if(isEqual(block, blocks.get(k))){
                            sum += block.size();
                            blocks.remove(k);
                            break;
                        }
                    }
                }
            }
        }

        return sum;
    }

    private static boolean isEqual(List<int[]> block1, List<int[]> block2){
        if(block1.size() != block2.size()) return false;
        for(int i = 0; i < block1.size(); i++){
            if(block1.get(i)[0] != block2.get(i)[0] || block1.get(i)[1] != block2.get(i)[1]) return false;
        }
        return true;
    }

    /**
     * 블록을 90도 회전
     * i = j, j = i
     * @param block
     * @return
     */
    private static List<int[]> rotate90(List<int[]> block){
        List<int[]> rotateBlock = new ArrayList<>();
        for(int i = 0; i < block.size(); i++){
            int[] current = block.get(i);
            rotateBlock.add(new int[]{current[1], current[0]});
        }
        return rotateBlock;
    }

    /**
     * 블록을 180도 회전
     * i = -i
     * j = -j
     * @param block
     * @return
     */
    private static List<int[]> rotate180(List<int[]> block){
        List<int[]> rotateBlock = new ArrayList<>();
        for(int i = 0; i < block.size(); i++){
            int[] current = block.get(i);
            rotateBlock.add(new int[]{(-1)*current[0], (-1)*current[1]});
        }
        return rotateBlock;
    }

    /**
     *  블록을 270도 회전
     *  i = -j
     *  j = -i
     */
    private static List<int[]> rotate270(List<int[]> block){
        List<int[]> rotateBlock = new ArrayList<>();
        for(int i = 0; i < block.size(); i++){
            int[] current = block.get(i);
            rotateBlock.add(new int[]{(-1)*current[1], (-1)*current[0]});
        }
        return rotateBlock;
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
