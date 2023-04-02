package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SantaFactory {

    private static Factory factory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int q = Integer.parseInt(input);

        for (int i = 0; i < q; i++) {
            String[] split = br.readLine().split(" ");
            switch(split[0]) {
                case "100":
                    init_build(split);
                    break;
                case "200":
                    drop(split);
                    break;
                case "300":
                    delete(split);
                    break;
                case "400":
                    check(split);
                    break;
                case "500":
                    error(split);
                    break;
            }
        }
    }

    private static boolean isError(int beltNo) {
        return factory.errors.contains(beltNo);
    }

    private static void error(String[] input) {
        int b_num = Integer.parseInt(input[1]) - 1;

        Queue<Gift> belt = factory.belts.get(b_num);

        if(isError(b_num)) {
            System.out.println(-1);
            return;
        }
        factory.errors.add(b_num);

        int index = b_num + 1;

        while(index != b_num) {
            if(index >= factory.belts.size()) index = 0;
            if(!isError(index)) break;
            index++;
        }

        Queue<Gift> nextBelt = factory.belts.get(index);

        while(!belt.isEmpty()) {
            nextBelt.add(belt.poll());
        }
        System.out.println(b_num + 1);
    }

    private static void check(String[] input) {
        int belt_no = -1;
        int f_id = Integer.parseInt(input[1]);

        for (Queue<Gift> belt : factory.belts) {
            int curBeltNo = factory.getBeltNo(belt);
            if(isError(curBeltNo)) continue;
            for (Gift gift : belt) {
                if(gift.id == f_id) {
                    belt_no = factory.belts.indexOf(belt);
                }
            }
        }
        if(belt_no == -1) {
            System.out.println(-1);
            return;
        }
        Queue<Gift> belt = factory.belts.get(belt_no);

        while(!belt.isEmpty() && belt.peek().id != f_id) {
            belt.add(belt.poll());
        }
        System.out.println(belt_no + 1);
    }

    private static void delete(String[] input) {
        boolean isDelete = false;
        int r_id = Integer.parseInt(input[1]);

        for (Queue<Gift> belt : factory.belts) {
            if(isError(factory.getBeltNo(belt))) continue;
            for (Gift gift : belt) {
                if(gift.id == r_id) {
                    belt.remove(gift);
                    isDelete = true;
                    break;
                }
            }
        }

        System.out.println(isDelete ? r_id : -1);
    }

    private static void drop(String[] input) {
        int sum = 0;

        int w_max = Integer.parseInt(input[1]);

        for (Queue<Gift> belt : factory.belts) {
            if(isError(factory.getBeltNo(belt))) continue;
            if(belt.isEmpty()) continue;
            Gift cur = belt.poll();
            if(cur.weight > w_max) belt.add(cur);
            else sum += cur.weight;
        }

        System.out.println(sum);
    }

    private static void init_build(String[] input) {
        int n = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        factory = new Factory(m);
        int count = 0;
        int index = 0;
        for (int i = 3; i < n + 3; i++) {
            if(count == n/m) {
                index++;
                count = 0;
            }
            count++;
            int no = Integer.parseInt(input[i]);
            int weight = Integer.parseInt(input[i + n]);
            factory.addGift(index, new Gift(no, weight));
        }
    }

    static class Gift {
        int id;
        int weight;

        public Gift(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    static class Factory {
        List<Queue<Gift>> belts;
        Set<Integer> errors;

        public Factory(int m) {
            belts = new ArrayList<>();
            errors = new HashSet<>();

            for (int i = 0; i < m; i++) {
                belts.add(new LinkedList<>());
            }
        }

        void addGift(int beltNo, Gift gift) {
            belts.get(beltNo).add(gift);
        }

        int getBeltNo(Queue<Gift> belt) {
            return factory.belts.indexOf(belt);
        }
    }
}
