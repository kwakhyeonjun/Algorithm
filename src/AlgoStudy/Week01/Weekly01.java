package AlgoStudy.Week01;

public class Weekly01 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count){
        long sum = 0;
        for(int i = 1; i <= count; i++){
            sum += i * price;
        }
        if(money < sum) return sum - money;
        return 0;
    }

    /**
     * 등비순열의 합
     * sum = n*(n+1)/2 활용
     */
    public static long solution2 (int price, int money, int count){
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}
