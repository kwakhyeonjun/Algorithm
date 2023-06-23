package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SantaFactory {
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

    private static void error(String[] input) {
    }

    private static void check(String[] input) {
        
    }

    private static void delete(String[] input) {
        
    }

    private static void drop(String[] input) {
        
    }

    private static void init_build(String[] input) {
        int n = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

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


        }
    }

    static class Factory {
        Map<Integer, Box> boxMap;
        Map<Integer, Belt> beltMap;

        public Factory() {
            this.boxMap = new HashMap<>();
            this.beltMap = new HashMap<>();
        }

        public void addBox(Box box, int beltNo) {
            boxMap.put(box.id, box);
            if(!beltMap.containsKey(beltNo)) {
                Belt belt = new Belt();
                belt.head = box.id;
                belt.tail = box.id;
                beltMap.put(beltNo, belt);
            } else {
                Belt belt = beltMap.get(beltNo);
                
                belt.tail = box.id;
            }
        }
    }

    static class Belt {
        boolean isBroken;
        int head;
        int tail;

        public Belt() {
            isBroken = false;
        }

    }

    static class Box {
        int id;
        int weight;
        int beltNo;
        int prev;
        int next;

        public Box() {}

        public Box(int id, int weight, int beltNo, int prev) {
            this();
            this.id = id;
            this.weight = weight;
        }

        public void setBelt(int beltNo, int prev, int next) {
            this.beltNo = beltNo;
            this.prev = prev;
            this.next = next;
        }
    }
}
