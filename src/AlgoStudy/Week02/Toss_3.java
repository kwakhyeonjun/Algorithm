package AlgoStudy.Week02;

/**
 * 가짜영수증 찾기
 * 조건
 * 1. 금액이 옳지 않게 적혀 있음
 * 2. 0~9사이의 숫자, 콤마로만 구성됨 (원, + 등 안됨)
 * 3. 0원을 제외하고는 가장 왼쪽 숫자가 0일 수 없음
 * 4. 세자리 구분자를 포함하거나, 전혀 포함하지 않음.
 * 5. 가장 왼쪽 끝이나 가장 오른쪽 끝에는 구분자가 없어야함.
 */
public class Toss_3 {
    public static void main(String[] args) {
        System.out.println(solution(",999,000"));
    }
    public static boolean solution(String amountText) {
        if(amountText.contains(",")){ // 4번조건
            if(amountText.charAt(0) == ',') return false;
            int comma = 3; // 첫번째 comma 위치
            int n = amountText.length() - 1; // 마지막 원소 위치
            for(int i = amountText.length() - 1; i >= 0; i--){
                if(amountText.charAt(i) == ','){
                    if(i != n - comma) return false; // 5번 조건
                    else{
                        n = i - 1;
                    }
                }
            }
        }
        for(int i = 0; i < amountText.length(); i++){
            char current = amountText.charAt(i);
            if((current >= '0' && current <= '9') || current == ',') {
                if(i == 0 && current == '0' && amountText.length() != 1) return false; // 3번 조건
            }
            else return false; // 2번 조건
        }
        return true;
    }
}
