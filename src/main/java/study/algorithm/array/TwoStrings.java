package study.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EricWang on 2019/11/20 12:44 PM.
 */
public class TwoStrings {

    public static void main(String[] args) {

    }

    static String twoStrings(String s1, String s2) {

        char[] arr1 = s1.toCharArray();

        char[] arr2 = s2.toCharArray();

        Set<String> letters1 = new HashSet<>(arr1.length);
        for (char ch1 : arr1){
            letters1.add(String.valueOf(ch1));
        }

        for (char ch2 : arr2){
            if (letters1.contains(String.valueOf(ch2))){
                return "YES";
            }
        }

        return "NO";
    }
}
