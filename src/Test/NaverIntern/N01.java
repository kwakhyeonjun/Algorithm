package Test.NaverIntern;

/**
 * 한사람당 30장 1~30 / R, G, B 세종류
 * 가장 적은 가트로 점수 결정
 */
public class N01 {
    public static void main(String[] args) {
        N01 solution = new N01();
        System.out.println(solution.solution("encrypt this sentence", "something", new int[]{0, 1, 3, 2, 9, 2, 0, 3, 0, 2, 4, 1, 3}));
    }
    public String solution(String sentence, String keyword, int[] skips){
        StringBuilder answer = new StringBuilder();

        int keywordIndex = 0;
        int sentenceIndex = 0;

        for (int i = 0; i < skips.length; i++) {
            for (int j = 0; j < skips[i]; j++) {
//                System.out.println(sentenceIndex + " " + sentence.length());
                if(sentenceIndex + 1 > sentence.length()) {
                    answer.append(sentence.charAt(sentenceIndex));
                    break;
                }
                answer.append(sentence.charAt(sentenceIndex++));
                System.out.println(answer.toString());
            }
            if(keywordIndex + 1> keyword.length()) keywordIndex = 0;
            answer.append(keyword.charAt(keywordIndex++));
        }
        if(sentenceIndex < sentence.length()) {
            while(sentenceIndex < sentence.length()){
                answer.append(sentence.charAt(sentenceIndex++));
            }
        }
        return answer.toString();
    }
}
