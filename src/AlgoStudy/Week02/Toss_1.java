package AlgoStudy.Week02;

/**
 * 조건
 * 1. 부가가치세를 계산하는 프로그램 개발
 * 2. 과세 금액에서 10%, 소수점 첫째자리에서 올림
 * 3. 과세금액: 공급가액 - 비과세금액  (비과세금액이란: 부가가치세가 부과되지 않는 금액)
 * 4. 공급대가 = 공급가액 + 부가가치세.
 * 5. 봉사료가 없다면 공급대가 == 주문금액 BUT 숙박업 등 봉사료가 존재하는 업종은 주문금액 - 봉사료 = 공급대가
 * 6. if(공급대가 - 비과세금액 == 1) 부가가치세 = 0;
 *
 * 정리
 * 1. 부가가치세 = Math.round(과세금액*0.1, 1);
 * 2. 과세금액 = 공급가액 - 비과세금액
 * 3. 공급 대가 = 공급가액 + 부가가치세
 * 4. if(봉사료 없음) then 공급대가 = 주문금액
 * 5. else then 공급대가 = 주문금액 - 봉사료
 * 6. if(공급대가 - 비과세금액 == 1) 부가가치세 = 0;
 */
public class Toss_1 {

    public static void main(String[] args) {

    }

    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료

        long rhdrmqeork; // 공급대가
        long vat; // 부가가치세
        rhdrmqeork = orderAmount - serviceFee; // 정리 4, 5
        if(rhdrmqeork - taxFreeAmount == 1) vat = 0;
        else{
            if((rhdrmqeork - taxFreeAmount)%11 != 0){
                vat = (rhdrmqeork - taxFreeAmount)/11 + 1;
            }else{
                vat = (rhdrmqeork - taxFreeAmount)/11;
            }
        }

        return vat;
    }
}
