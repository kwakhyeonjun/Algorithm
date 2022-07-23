package Programmers.Level2;

public class TelList {
    public static void main(String[] args) {
        TelList sol = new TelList();
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(sol.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i < phone_book.length; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) answer = false;
                if(phone_book[j].startsWith(phone_book[i])) answer = false;
            }
        }

        return answer;
    }
}
