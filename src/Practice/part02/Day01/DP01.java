package Practice.part02.Day01;

public class DP01 {
    public static void main(String[] args) {
        int[] blocks = new int[9];

        blocks[0] = 1;
        blocks[1] = 2;

        for (int i = 2; i <= 8; i++) {
            blocks[i] = blocks[i-1] + blocks[i-2];
        }
        System.out.println(blocks[8]);
    }
}