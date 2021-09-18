package Practice.part01.Day01;

import java.util.Scanner;

public class B17478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        print(sb, n, n);
        System.out.println(sb);
    }
    public static StringBuilder print(StringBuilder sb, int n, int end) {
        frontPrint(sb, n, end);
        sb.append("\"재귀함수가 뭔가요?\"\n");
        if(n==0) {
            frontPrint(sb, n, end);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            frontPrint(sb, n, end);
            sb.append("라고 답변하였지.\n");
            return sb;
        }else{
            frontPrint(sb, n, end);
            sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            frontPrint(sb, n, end);
            sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            frontPrint(sb, n, end);
            sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            print(sb, n - 1, end);
            frontPrint(sb, n, end);
            sb.append("라고 답변하였지.\n");
        }
        return sb;
    }
    public static StringBuilder frontPrint(StringBuilder sb, int n, int end){
        for(int i = n; i < end; i++){
            sb.append("____");
        }
        return sb;
    }
}
