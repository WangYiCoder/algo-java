package study.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2019/11/20 12:09 PM.
 */
public class RansomNotes {

    public static void main(String[] args) {

        String[] magazine = new String[]{"give", "me", "one", "grand", "today", "night"};
        String[] note = new String[]{"give", "one", "grand", "today"};
        checkMagazine(magazine, note);
    }

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> magazineWordStatistic = new HashMap<>(magazine.length);

        for (String magazineword : magazine) {
            Integer count = magazineWordStatistic.get(magazineword);
            if (count == null) {
                magazineWordStatistic.put(magazineword, 1);
                continue;
            }
            magazineWordStatistic.put(magazineword, count + 1);

        }

        for (String noteWord : note) {
            Integer count = magazineWordStatistic.get(noteWord);
            if (count == null || count < 1) {
                System.out.println("No");
                return;
            }

            magazineWordStatistic.put(noteWord, count - 1);
        }

        System.out.println("Yes");
    }

}
