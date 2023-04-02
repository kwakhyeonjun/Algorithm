package Test.devMaching;


public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] img = {".########......" ,
                ".####...#......" ,
                ".#.####.#.#####" ,
                ".#.#..#.#.#..##" ,
                ".#.##.#.#.#...#" ,
                ".#.####.#.#...#" ,
                ".#....###.#####" ,
                ".########......"};
        System.out.println(sol.solution(25, 51, img));

    }


    public int solution(int low, int high, String[] img) {
        int answer = 0;

        System.out.println(img.length);

        for(int i = 0; i < img.length - 3; i++) {
            for(int j = 0; j < img[i].length() - 3; j++) {
                if(img[i].charAt(j) == '.') continue;
                for(int k = 3; ; k++) {
                    if(i + k >= img.length || j + k >= img[i].length()) break;

                    // QR 확인
                    if(!case01(img, i, j, k)) continue;
                    System.out.println("case Check!!");
                    case01(img, i, j, k);
                    System.out.println("case01 pass! " + "x = " + i + ", y = " + j + ", k = " + k);
                    for(int x =i ; x < i + k; x++) {
                        for(int y = j; y < j+ k; y++) {
                            System.out.print(img[x].charAt(y));
                        }
                        System.out.println();
                    }
                    int count = 0;
                    for(int x = i + 1; x < i + k - 1; x++) {
                        for(int y = j + 1; y < j + k - 1; y++) {
                            if(img[x].charAt(y) == '#') count++;
                        }
                    }

                    if(case02(low, high, k, count)) answer++;
                }
            }
        }

        return answer;
    }

    private boolean case01(String[] img, int x, int y, int n) {
        for(int i = x; i < n; i++) {
            if(img[i].charAt(y) != '#' || img[i].charAt(y + n - 1) != '#') return false;
        }

        for(int i = y; i < n; i++) {
            if(img[x].charAt(i) != '#' || img[x + n - 1].charAt(i) != '#') return false;
        }

        return true;
    }

    private boolean case02(int low, int high, int n, int k) {
        int val = k / (int)Math.pow((n - 2), 2) * 100;
        if(val < high && val >= low) return true;
        return false;
    }


}
