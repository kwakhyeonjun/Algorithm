package AlgoStudy.Week01;

public class Keypad {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
    public static String solution(int[] numbers, String hand){
        StringBuilder sb = new StringBuilder();
        int leftX = 1, leftY = 4;
        int rightX = 3, rightY = 4;
        int distR = 0, distL = 0;
        for(int i = 0; i < numbers.length; i++){
            switch (numbers[i]){
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    leftX = 1;
                    leftY = numbers[i]/3 + 1;
                    break;
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    rightX = 3;
                    rightY = numbers[i]/3;
                    break;
                case 2:
                    distL = Math.abs(leftX - 2) + Math.abs(leftY - 1);
                    distR = Math.abs(rightX - 2) + Math.abs(rightY - 1);
                    if(distL > distR){
                        sb.append("R");
                        rightX = 2;
                        rightY = 1;
                    }else if(distL < distR){
                        sb.append("L");
                        leftX = 2;
                        leftY = 1;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rightX = 2;
                            rightY = 1;
                        }else{
                            sb.append("L");
                            leftX = 2;
                            leftY = 1;
                        }
                    }
                    break;
                case 5:
                    distL = Math.abs(leftX - 2) + Math.abs(leftY - 2);
                    distR = Math.abs(rightX - 2) + Math.abs(rightY - 2);
                    if(distL > distR){
                        sb.append("R");
                        rightX = 2;
                        rightY = 2;
                    }else if(distL < distR){
                        sb.append("L");
                        leftX = 2;
                        leftY = 2;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rightX = 2;
                            rightY = 2;
                        }else{
                            sb.append("L");
                            leftX = 2;
                            leftY = 2;
                        }
                    }
                    break;
                case 8:
                    distL = Math.abs(leftX - 2) + Math.abs(leftY - 3);
                    distR = Math.abs(rightX - 2) + Math.abs(rightY - 3);
                    if(distL > distR){
                        sb.append("R");
                        rightX = 2;
                        rightY = 3;
                    }else if(distL < distR){
                        sb.append("L");
                        leftX = 2;
                        leftY = 3;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rightX = 2;
                            rightY = 3;
                        }else{
                            sb.append("L");
                            leftX = 2;
                            leftY = 3;
                        }
                    }
                    break;
                case 0:
                    distL = Math.abs(leftX - 2) + Math.abs(leftY - 4);
                    distR = Math.abs(rightX - 2) + Math.abs(rightY - 4);
                    if(distL > distR){
                        sb.append("R");
                        rightX = 2;
                        rightY = 4;
                    }else if(distL < distR){
                        sb.append("L");
                        leftX = 2;
                        leftY = 4;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rightX = 2;
                            rightY = 4;
                        }else{
                            sb.append("L");
                            leftX = 2;
                            leftY = 4;
                        }
                    }
                    break;
            }
        }
        return sb.toString();
    }
}
