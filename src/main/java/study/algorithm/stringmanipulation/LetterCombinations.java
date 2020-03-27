package study.algorithm.stringmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by EricWang on 2020/3/27 11:43 AM.
 * leetcode link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations t = new LetterCombinations();
        System.out.println(t.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()){
            return new ArrayList<>();
        }
        Map<Integer,List<String>> numberToLetter = new HashMap<>(8);
        List<String> number2 = new ArrayList<>();
        List<String> number3 = new ArrayList<>();
        List<String> number4 = new ArrayList<>();
        List<String> number5 = new ArrayList<>();
        List<String> number6 = new ArrayList<>();
        List<String> number7 = new ArrayList<>();
        List<String> number8 = new ArrayList<>();
        List<String> number9 = new ArrayList<>();
        number2.add("a");
        number2.add("b");
        number2.add("c");

        number3.add("d");
        number3.add("e");
        number3.add("f");

        number4.add("g");
        number4.add("h");
        number4.add("i");

        number5.add("j");
        number5.add("k");
        number5.add("l");

        number6.add("m");
        number6.add("n");
        number6.add("o");

        number7.add("p");
        number7.add("q");
        number7.add("r");
        number7.add("s");

        number8.add("t");
        number8.add("u");
        number8.add("v");

        number9.add("w");
        number9.add("x");
        number9.add("y");
        number9.add("z");

        numberToLetter.put((int)'2',number2);
        numberToLetter.put((int)'3',number3);
        numberToLetter.put((int)'4',number4);
        numberToLetter.put((int)'5',number5);
        numberToLetter.put((int)'6',number6);
        numberToLetter.put((int)'7',number7);
        numberToLetter.put((int)'8',number8);
        numberToLetter.put((int)'9',number9);

        List<String> result = new ArrayList<>();

        recursive(0,new StringBuilder(),numberToLetter,result,digits);

        return result;

    }

    void recursive(int i, StringBuilder sb, Map<Integer,List<String>> numberToLetter, List<String> result, String digits){
        int number = (int)digits.charAt(i);

        List<String> letters = numberToLetter.get(number);

        for (String letter : letters){
            sb.append(letter);
            if (i == digits.length() - 1){
                result.add(sb.toString());
                sb.replace(i,i+1,"");
                continue;
            }

            recursive(i+1,sb,numberToLetter,result,digits);
            sb.replace(i,i+1,"");
        }

    }



}
