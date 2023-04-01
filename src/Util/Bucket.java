package Util;

public class Bucket {
    public static void main(String[] args) {
        String input = ""; // fill here;

        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '[':
                    sb.append("{");
                    break;
                case ']':
                    sb.append("}");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
