package AlgoStudy.Week05;

public class year2016 {
    private String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
    public String solution(int a, int b) {
        int day = b-1;
        switch (a){
            case 12:
                day += 30;
            case 11:
                day += 31;
            case 10:
                day += 30;
            case 9:
                day += 31;
            case 8:
                day += 31;
            case 7:
                day += 30;
            case 6:
                day += 31;
            case 5:
                day += 30;
            case 4:
                day += 31;
            case 3:
                day += 29;
            case 2:
                day += 31;
            case 1:
                break;
        }
        return week[day%7];
    }
}
