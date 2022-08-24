package Programmers.Curriculum;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P17686 {
    public String[] solution2(String[] files) {

        Arrays.sort(files, (o1, o2) -> {
            FileInfo headerO1 = getHeader(o1);
            FileInfo headerO2 = getHeader(o2);
            int numberO1 = getNumber(o1, headerO1.index).index;
            int numberO2 = getNumber(o2, headerO2.index).index;

            if(headerO1.value.equals(headerO2.value)) {
                return numberO1 - numberO2;
            }
            return headerO1.value.compareTo(headerO2.value);
        });

        return files;
    }

    private FileInfo getHeader(String file) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < file.length(); i++) {
            index = i;
            if(file.charAt(i) <= '9' && file.charAt(i) >= '0') break;
            sb.append(file.charAt(i));
        }
        return new FileInfo(sb.toString().toLowerCase(), index);
    }

    private FileInfo getNumber(String file, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i = index; i < file.length(); i++) {
            if(file.charAt(i) > '9' || file.charAt(i) < '0') break;
            sb.append(file.charAt(i));
        }
        if(sb.toString().equals("")) {
            return new FileInfo(null, 1);
        }

        return new FileInfo(null, Integer.parseInt(sb.toString()));
    }

    private static class FileInfo {
        String value;
        int index;

        FileInfo(String value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public String[] solution(String[] files) {
        Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

        Arrays.sort(files, (o1, o2) -> {
            Matcher m1 = p.matcher(o1.toLowerCase());
            Matcher m2 = p.matcher(o2.toLowerCase());
            m1.find();
            m2.find();

            if(m1.group(1).equals(m2.group(1))) {
                return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
            }
            return m1.group(1).compareTo(m2.group(1));
        });

        return files;
    }
}
