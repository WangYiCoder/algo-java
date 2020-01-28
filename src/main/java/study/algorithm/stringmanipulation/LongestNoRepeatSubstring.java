package study.algorithm.stringmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2020/1/28 4:48 PM.
 */
public class LongestNoRepeatSubstring {

    public int lengthOfLongestSubstring(String s) {

        int length = 0;

        if (s == null || s.length() == 0){
            return length;
        }

        char[] chars = s.toCharArray();

        Map<Integer,Integer> charWithIndex = new HashMap<>(26);

        int startIndex = 0;

        for (int i = 0; i < chars.length; i ++){

            Integer index = charWithIndex.get((int)chars[i]);
            if (index == null){
                charWithIndex.put((int)chars[i],i);
                if (charWithIndex.size() > length){
                    length = charWithIndex.size();
                }
                continue;
            }

            for (int c = startIndex; c <= index; c++){
                charWithIndex.remove((int)chars[c]);
            }
            charWithIndex.put((int)chars[i],i);
            startIndex = index + 1;

            if (charWithIndex.size() > length){
                length = charWithIndex.size();
            }


        }


        return length;

    }

    public static void main(String[] args) {
        LongestNoRepeatSubstring t1 = new LongestNoRepeatSubstring();

        System.out.println(t1.lengthOfLongestSubstring("bpfbhmipx"));
    }
}
