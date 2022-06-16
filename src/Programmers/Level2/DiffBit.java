package Programmers.Level2;

public class DiffBit {
    public static void main(String[] args) {
        long[] numbers = {2,7};
        DiffBit sol = new DiffBit();
        System.out.println(sol.solution(numbers));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int t = 0; t < numbers.length; t++) {
            String bit = Long.toBinaryString(numbers[t]);
            if(numbers[t]%2 == 0) {
                answer[t] = numbers[t]+1;
            }else{
                int lastIndex = bit.lastIndexOf("0");
                int firstIndex = bit.indexOf("1", lastIndex);
                if(lastIndex == -1) {
                    numbers[t] += 1;
                    bit = Long.toBinaryString(numbers[t]);
                    bit = bit.substring(0, 2) + bit.substring(2, bit.length()).replace("0", "1");
                }else {
                    bit = bit.substring(0, lastIndex) + "1"
                            + bit.substring(lastIndex + 1, firstIndex) + "0"
                            + bit.substring(firstIndex+1, bit.length());
                }
                answer[t] = Long.parseLong(bit, 2);
            }
        }
        return answer;
    }
}
