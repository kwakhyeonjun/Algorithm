package Programmers.Study;

import java.util.HashMap;

public class P77486 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int n = enroll.length;
        answer = new int[n];

        map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String parent = referral[i].equals("-") ? null : referral[i];
            map.put(enroll[i], new Node(i, parent));
        }

        for(int i = 0; i < seller.length; i++) {
            map.get(seller[i]).setValue(amount[i] * 100);
        }

        for(String key : map.keySet()) {
            Node cur = map.get(key);
            int cMoney = cur.getValue();
            int pMoney = (int) Math.floor(cMoney * 0.1);
            answer[cur.getIndex()] += cMoney - pMoney;
            sumValues(cur.getParent(), pMoney);
        }

        return answer;
    }

    int[] answer;
    HashMap<String, Node> map;

    private void sumValues(String name, int value) {
        if(name == null) return;
        int pValue = (int) Math.floor(value * 0.1);
        answer[map.get(name).getIndex()] += (value - pValue);
        sumValues(map.get(name).getParent(), pValue);
    }

    static class Node {
        private int index;
        private int value;
        private String parent;

        Node(int index, String parent) {
            this.index = index;
            this.parent = parent;
        }

        public int getIndex() {
            return this.index;
        }

        public void setValue(int value) {
            this.value += value;
        }

        public String getParent() {
            return this.parent;
        }

        public int getValue() {
            return this.value;
        }
    }
}
