package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class P17683 {
    public String solution(String m, String[] musicinfos) {

        List<Music> list = new ArrayList<>();
        m = replaceNotes(m);

        // parse musicinfos
        for (String musicInfo : musicinfos) {
            String[] cur = musicInfo.split(",");
            int start = getTime(cur[0]);
            int end = getTime(cur[1]);
            String name = cur[2];
            String notes = replaceNotes(cur[3]);
            list.add(new Music(end - start, name, notes));
        }

        Music selected = null;

        for (Music music : list) {
            // 음악 길이에 맞게 설정
            StringBuilder notes = new StringBuilder();
            while(notes.length() <= m.length()) {
                notes.append(music.notes);
            }

            // 악보에 포함되는 경우
            if(!notes.toString().contains(m)) continue;

            // 처음 선택된 경우
            if (selected == null) {
                selected = music;
                continue;
            }

            // 플레이시간이 기존에 선택된 것 보다 긴 경우
            if(selected.playTime < music.playTime) selected = music;
        }

        // 조건이 일치하지 않는 경우
        if(selected == null) return "(None)";

        return selected.name;
    }

    static class Music {
        int playTime;
        String name;
        String notes;

        public Music() {
        }

        public Music(int playTime, String name, String notes) {
            this.playTime = playTime;
            this.name = name;
            this.notes = notes;
        }
    }

    private String replaceNotes(String notes) {
        notes = notes.replaceAll("A#", "H");
        notes = notes.replaceAll("C#", "I");
        notes = notes.replaceAll("D#", "J");
        notes = notes.replaceAll("F#", "K");
        notes = notes.replaceAll("G#", "L");
        return notes;
    }

    // time {mm:ss}
    private int getTime(String time) {
        String[] sArr = time.split(":");
        return Integer.parseInt(sArr[0]) * 60 + Integer.parseInt(sArr[1]);
    }
}
