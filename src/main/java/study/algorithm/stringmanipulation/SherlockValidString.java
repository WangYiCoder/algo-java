package study.algorithm.stringmanipulation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {

    public static void main(String[] args) {
        String s = "aabbcd";
        System.out.println(isValid(s));
    }

    static String isValid(String s) {

        char[] chars = s.toCharArray();

        Map<String, Integer> charMap = new HashMap<>();

        for (char c : chars){
            String s1 = String.valueOf(c);
            Integer count = charMap.get(s1);
            if (count == null){
                charMap.put(s1,1);
                continue;
            }

            charMap.put(s1,count+1);
        }

        Collection<Integer> values = charMap.values();

        int deviation = 0;
        int minimum = Integer.MAX_VALUE;

        for (Integer count : values){
            if (count < minimum){
                minimum = count;
            }
        }

        for (Integer count : values){
            deviation = deviation + Math.abs(count - minimum);
        }

        if (deviation <= 1){
            return "YES";
        }

        if (minimum == 1){
            int onecount = 0;

            Map<Integer,Integer> countOfCount = new HashMap<>();

            for (Integer count : values){
                if (count == 1){
                    onecount++;
                }
                if (countOfCount.get(count) == null){
                    countOfCount.put(count,1);
                    continue;
                }

                countOfCount.put(count,countOfCount.get(count)+1);
            }

            if (onecount == 1 && countOfCount.size() == 2){
                return "YES";
            }
        }



        return "NO";
    }

}
