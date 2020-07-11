package study.algorithm.stringmanipulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MakeAnagrams {

    static int makeAnagram(String a, String b) {

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Map<String, Integer> aMap = new HashMap<>(aChars.length);
        Map<String, Integer> bMap = new HashMap<>(bChars.length);

        initMap(aMap, aChars);
        initMap(bMap, bChars);

        Iterator<String> keyIterator = aMap.keySet().iterator();
        int total = 0;

        while (keyIterator.hasNext()){
            String kA = keyIterator.next();
            Integer countInA = aMap.get(kA);
            Integer countInB = bMap.get(kA) == null? 0 : bMap.get(kA);
            total = total + Math.abs(countInA - countInB);
            bMap.remove(kA);

        }

        for (String kB : bMap.keySet()){
            total = total + bMap.get(kB);
        }

        return total;
    }

    private static void initMap(Map<String, Integer> map, char[] chars) {

        for (char c : chars) {
            Integer count = map.get(String.valueOf(c));

            if (count == null) {
                map.put(String.valueOf(c), 1);
                continue;
            }

            map.put(String.valueOf(c), count + 1);
        }


    }

}
