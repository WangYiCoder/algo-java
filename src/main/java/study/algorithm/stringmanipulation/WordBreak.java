package study.algorithm.stringmanipulation;

import java.util.*;

/**
 * Created by EricWang on 2020/2/23 10:29 AM.
 * leetcode link: https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    // use dp to solve the problem
    //how to decide that char at index i can be the end of matched word?
    // ---> the char at i - word.lenght is a splitter
    public boolean wordBreak(String s, List<String> wordDict) {

        char[] chars = s.toCharArray();
        boolean[] results = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++){

            for (String word: wordDict){
                if (word.length() > i + 1){
                    continue;
                }

                if (word.length() == i+1 || results[i-word.length()]){
                    if (s.substring(i+1 - word.length(),i+1).equals(word)) {
                        results[i] = true;
                    }
                }

            }
        }

        return results[chars.length -1];
    }


    //the blow solution can't meet the time comlexity
    /*public boolean wordBreak(String s, List<String> wordDict) {


        Set<String> dictSet = new HashSet<>(wordDict.size());
        for (String word : wordDict){
            dictSet.add(word);
        }

        char[] chars = s.toCharArray();
        Stack<LastIndexAndWord> matchedSegments = new Stack<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++){

            stringBuilder.append(String.valueOf(chars[i]));

            if (i == chars.length - 1){
                if (dictSet.contains(stringBuilder.toString())){
                    return true;
                }

                if (matchedSegments.isEmpty()){
                    return false;
                }

                LastIndexAndWord lastMatchedSegments = matchedSegments.pop();

                i = lastMatchedSegments.index;

                stringBuilder = new StringBuilder(lastMatchedSegments.word);

                continue;
            }

            if (dictSet.contains(stringBuilder.toString())){
                LastIndexAndWord matchedSegment = new LastIndexAndWord();
                matchedSegment.index = i;
                matchedSegment.word = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                matchedSegments.push(matchedSegment);
            }


        }


        return false;
    }

    class LastIndexAndWord{

        int index;

        String word;
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> words = new ArrayList<>();
        words.add("aaaa");
        words.add("aaa");
        WordBreak t = new WordBreak();
        System.out.println(t.wordBreak(s,words));
    }*/
}
