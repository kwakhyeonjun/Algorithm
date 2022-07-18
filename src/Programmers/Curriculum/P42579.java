package Programmers.Curriculum;

import java.util.*;

public class P42579 {
    public static void main(String[] args) {

    }

    /**
     * 가장 많이 재생된 노래 2개
     * 고유번호로 구분
     * 1. 속한 노래가 많이 재생된 장르를 먼저 수록
     * 2. 장르 내에서 많이 재생된 노래를 먼저 수록
     * 3. 장르 내에서 재생 횟수가 같은 노래 중에서 고유번호가 낮은 노래를 먼저 수록
     */
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Genre> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if(map.containsKey(genres[i])) {
                map.put(genres[i], new Genre());
            }
            map.get(genres[i]).totCount += plays[i];
            map.get(genres[i]).songs.add(new Song(i, plays[i]));
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key).songs);
        }

        return answer;
    }

    private class Song implements Comparable<Song> {
        int number;
        int count;

        Song(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Song o) {
            if(this.count == o.count) {
                return this.number - o.number;
            }
            return this.count - o.count;
        }
    }

    private class Genre implements Comparable<Genre>{
        int totCount;
        List<Song> songs;

        Genre() {
            totCount = 0;
            songs = new ArrayList<>();
        }

        @Override
        public int compareTo(Genre o) {
            return this.totCount - o.totCount;
        }
    }


}
