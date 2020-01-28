package study.algorithm.dp;

/**
 * Created by EricWang on 2020/1/28 9:56 AM.
 * Leetcode link: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();

        if (chars.length == 0) {
            return sb.toString();
        }

        if (chars.length == 1) {
            sb.append(chars[0]);
            return sb.toString();
        }

        int maxLength = 1;
        sb.append(chars[0]);

        int startIndex = 0;
        int endIndex = 0;

        for (int i = 1; i < chars.length; i++) {

            if (chars.length - i < maxLength/2){
                break;
            }

            if (chars[i] == chars[i - 1]) {
                int currentMaxLength = 2;
                int j = 1;

                while (i - j - 1 >= 0 && i + j < chars.length) {
                    if (chars[i + j] == chars[i - j - 1]) {
                        j++;
                        currentMaxLength += 2;

                        continue;
                    } else {

                        break;
                    }
                }

                if (currentMaxLength > maxLength) {
                    maxLength = currentMaxLength;
                    startIndex = i - j;
                    endIndex = i + j -1;

                }

            }

            int j = 1;
            int currentMaxLength = 1;
            while (i -j >= 0 && i + j < chars.length){

                if (chars[i-j] == chars[i +j]){
                    j++;
                    currentMaxLength += 2;
                    continue;

                }else {

                    break;
                }

            }

            if (currentMaxLength > maxLength){
                maxLength = currentMaxLength;
                startIndex = i - j + 1;
                endIndex = i + j - 1;
            }

        }

        if (maxLength > 1){
            StringBuilder newSb = new StringBuilder();
            for (int n = startIndex; n <= endIndex; n++){
                newSb.append(chars[n]);
            }
            return newSb.toString();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring t1 = new LongestPalindromicSubstring();
        System.out.println(t1.longestPalindrome("cbbd"));
    }
}
