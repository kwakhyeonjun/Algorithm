package AlgoStudy.Week09;

public class Rectangle {
    public static void main(String[] args) {
        Rectangle sol = new Rectangle();
        System.out.println(sol.solution(7, 4));

    }

    public long solution(int w, int h) {
        long max = (long)w * (long)h;
        long answer = 0;

        long gcd = gcd((long)w, (long)h);
        double x = w/gcd;
        double y = h/gcd;

        double degree = y/x;

        int count = 0;
        double cur = 0;
        for (int i = 1; i <= x; i++) {
            double next = degree * i;
            count += (int)(Math.ceil(next) - Math.floor(cur));
            cur = next;
        }

        answer = count * gcd;

        return max - answer;
    }

    /**
     * 이거 왜 됌?????????????????????????????????????
     * @param w
     * @param h
     * @return
     */
    public long sol2(int w, int h){
        return (long) w * (long) h - (w + h - gcd((long)w, (long)h));
    }

    private long gcd(long a, long b){
        long r = a%b;
        if(r == 0) return b;
        return gcd(b, r);
    }
}
