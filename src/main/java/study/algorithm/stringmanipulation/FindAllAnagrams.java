package study.algorithm.stringmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by EricWang on 2020/3/1 5:12 PM.
 * leetcode link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        FindAllAnagrams t = new FindAllAnagrams();
        List<Integer> result = t.findAnagrams(s, p);
        System.out.println(result);
    }

    //use slide window
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() <  p.length()){
            return result;
        }

        char[] standardChars = p.toCharArray();


        Map<Integer,Integer> standCharStat = new HashMap<>();
        for (char c : standardChars){

            Integer charValue = (int)c;
            Integer count = standCharStat.get(charValue) == null ? 1 : standCharStat.get(charValue) + 1;
            standCharStat.put(charValue,count);
        }

        int startIndex = 0, endIndex = 0;

        while (endIndex < s.length()){
            Integer currentValue = (int)s.charAt(endIndex);
            if (standCharStat.containsKey(currentValue)){
                removeOrReduce(standCharStat,currentValue);
                if (standCharStat.isEmpty()){
                    result.add(startIndex);
                    Integer tempValue = (int)s.charAt(startIndex);
                    standCharStat.put(tempValue,1);
                    startIndex++;
                }

                endIndex++;
                continue;
            }

            if (startIndex == endIndex){
                startIndex = ++endIndex;
                continue;
            }

            Integer tempValue = (int)s.charAt(startIndex);
            addElement(standCharStat, tempValue);
            startIndex++;


        }

        return result;

    }

    private void addElement(Map<Integer, Integer> standCharStat, Integer tempValue) {
        Integer currentCount = standCharStat.get(tempValue);
        if (currentCount == null){
            standCharStat.put(tempValue,1);
            return;
        }
        standCharStat.put(tempValue,currentCount+1);
    }

    private void removeOrReduce(Map<Integer, Integer> standCharStat, Integer charValue) {
        Integer currentCount = standCharStat.get(charValue);
        if (currentCount > 1){
            standCharStat.put(charValue,currentCount - 1);
            return;
        }

        standCharStat.remove(charValue);

    }


}
