package Programmers.Level2;

import java.util.ArrayList;
import java.util.Locale;

public class NewsClustering {
    public static void main(String[] args) {
        NewsClustering sol = new NewsClustering();
        String str1 = "handshake";
        String str2 = "shake hands";
        int answer = sol.solution(str1, str2);
        System.out.println(answer);
    }

    /**
     * 자카드 유사도 J(A, B) = A*B / A+B
     * if(A == 0 && B == 0) J(A, B) = 1
     *
     *
     * @param str1
     * @param str2
     * @return
     */
    public int solution(String str1, String str2) {
        ArrayList<String> subSet1 = subSet(str1.toLowerCase(Locale.ROOT));
        ArrayList<String> subSet2 = subSet(str2.toLowerCase(Locale.ROOT));

        if(subSet1.size() == 0 && subSet2.size() == 0) return 65536;

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        union.addAll(subSet1);
        union.addAll(subSet2);


        int idx1 = 0, idx2 = 0;

        while(idx1 < subSet1.size()) {
            String cur1 = subSet1.get(idx1);
            boolean flag = false;
            idx2 = 0;
            while(idx2 < subSet2.size()) {
                String cur2 = subSet2.get(idx2);
                if(cur1.equals(cur2)) {
                    subSet1.remove(idx1);
                    subSet2.remove(idx2);
                    intersection.add(cur2);
                    flag = true;
                    break;
                }
                idx2++;
            }
            if(!flag) idx1++;
        }
        ArrayList<String> temp = new ArrayList<>();
        temp.addAll(intersection);

        idx1 = 0; idx2 = 0;
        while(idx1 < union.size()) {
            String cur1 = union.get(idx1);
            boolean flag = false;
            idx2 = 0;
            while(idx2 < temp.size()) {
                String cur2 = temp.get(idx2);
                if(cur1.equals(cur2)) {
                    temp.remove(idx2);
                    union.remove(idx1);
                    flag = true;
                    break;
                }
                idx2++;
            }
            if(!flag) idx1++;
        }

        return 65536 * intersection.size() / union.size();
    }

    private ArrayList<String> subSet(String s) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length()-1; i++) {
            if((s.charAt(i+1) >= 'a' && s.charAt(i+1) <= 'z') && (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
                list.add(s.substring(i, i+2));
            }
        }
        return list;
    }
}
