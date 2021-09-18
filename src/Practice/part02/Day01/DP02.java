package Practice.part02.Day01;

public class DP02 {
    public static void main(String[] args) {
        int[] stick = new int[7];
        stick[1] = 2;
        stick[2] = 5;
        for(int i = 3; i <= 6; i++){
            stick[i] = stick[i-1] *2 + stick[i-2];
        }
        System.out.println(stick[6]);
    }
}
