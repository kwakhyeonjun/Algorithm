package Practice.Day02;

import java.util.Scanner;

public class SWEA1954 {
    enum Direction{LEFT, RIGHT, UP, DOWN;}
    static int map[][];
    static int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            size = sc.nextInt();
            map = new int[size][size];
            Direction dir = Direction.RIGHT;
            int x = 0;
            int y = 0;
            for(int i = 1; i <= size*size; i++){
                map[x][y] = i;
                if(isLast(x, y)) break;
                switch (dir){
                    case UP:
                        if(x-1 < 0 || map[x-1][y] != 0){
                            dir = Direction.RIGHT;
                            i--;
                            break;
                        }
                        x -= 1;
                        break;
                    case DOWN:
                        if(x+1 >= size || map[x+1][y] != 0){
                            dir = Direction.LEFT;
                            i--;
                            break;
                        }
                        x += 1;
                        break;
                    case LEFT:
                        if(y-1 < 0 || map[x][y-1] != 0){
                            dir = Direction.UP;
                            i--;
                            break;
                        }
                        y -= 1;
                        break;
                    case RIGHT:
                        if(y+1 >= size || map[x][y+1] != 0){
                            dir = Direction.DOWN;
                            i--;
                            break;
                        }
                        y +=1;
                        break;
                }
            }
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
    private static boolean isLast(int x, int y){
        if(x-1 >= 0 && x+1 < size && y-1 >= 0 && y+1 <size
            && map[x-1][y] != 0 && map[x+1][y] != 0 && map[x][y-1] != 0 && map[x][y+1] != 0)
            return true;
        else return false;
    }
}
