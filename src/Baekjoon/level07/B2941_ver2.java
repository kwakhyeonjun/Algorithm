package Baekjoon.level07;

import java.util.Scanner;

/**
 * 크로아티아 알파벳에 해당하는 word를 입력받는 str에서 찾고, 만약 있다면 존재하는 모든 크로아티아 알파벳을 "*"으로 변경함.
 * 이때 여러 단어로 구성된 크로아티아 단어가 한 단어로 축약되므로, 한 단어씩으로 고려할 수 있다.
 * 따라서 크로아티아 단어를 모두 변경한 뒤에 입력받은 str의 길이(length)를 출력하면 단어의 수를 출력할 수 있다.
 * Damn
 */
public class B2941_ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(int i = 0; i < word.length; i++){
            if(str.contains(word[i])) {
                str = str.replaceAll(word[i], "*");
            }
        }
        System.out.println(str.length());
    }
}
