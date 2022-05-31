package Test.Toss;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Sol3 {
    public static void main(String[] args) throws ParseException {
        String[] ledgers = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
        System.out.println(solution(ledgers));
    }

    /**
     * 입금 날짜 별로 서로 다른 금리가 적용될 수 있음.
     * 출금시에는 가장 최근에 입금된 금액부터 출금, 출금 금액에 대해서는 입금 당시 금리와 예치 기간으로 이자 계산
     * 12/31에는 잔액이 자동으로 모두 출금, 출금액에 대해서는 2번으로 계산
     * 소수점 이하는 버림.
     */
    public static int solution(String[] ledgers) throws ParseException {
        int answer = 0;

        Account[] accounts = new Account[ledgers.length];

        int total = 0;

        // 모든 이력 순회
        for(int i = 0; i < ledgers.length; i++) {
            // 파싱
            StringTokenizer st = new StringTokenizer(ledgers[i], " ");
            String mmdd = st.nextToken();
            String date = "2022/" + mmdd;
            // 날짜 객체로 생성
            Date curDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
            // 이자율
            double rate = Double.parseDouble(st.nextToken())/100;
            // 금액
            double price = Double.parseDouble(st.nextToken());

            // 계좌 정보 업데이트
            accounts[i] = new Account(curDate, rate, price);

            // 출금한 경우
            if(price < 0) {
                int prev = i - 1; // 이전 계좌내역부터 확인
                price = Math.abs(price);
                while(prev >= 0 && price > 0) {
                    // 이전에 남은 금액이 있다면,
                    if(accounts[prev].price > 0) {
                        // 몇일 되었는지 확인
                        double diff = (double)(curDate.getTime() - accounts[prev].date.getTime())/(24*60*60*1000);
                        // 출금 금액보다 금액이 큰 경우
                        if(accounts[prev].price > price) {
                            accounts[prev].price -= price;
                            answer += (int)(price * accounts[prev].rate * (diff/365));
                        } else {
                            price -= accounts[prev].price;
                            answer += (int)(accounts[prev].price * accounts[prev].rate * (diff/365));
                            accounts[prev].price = 0;
                        }
                    }
                    prev--;
                }
            }
        }

        // 12/31 자동출금
        int prev = accounts.length - 1;
        String date = "2022/12/31";
        Date curDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
        while(prev >= 0) {
            if(accounts[prev].price > 0) {
                double diff = (double) (curDate.getTime() - accounts[prev].date.getTime()) / (24 * 60 * 60 * 1000);
                answer += (int) (accounts[prev].price * accounts[prev].rate * (diff / 365));
            }
            prev--;
        }

        return answer;
    }

    static class Account {
        Date date;
        double rate;
        double price;

        public Account(Date date, double rate, double price) {
            this.date = date;
            this.rate = rate;
            this.price = price;
        }
    }
}
