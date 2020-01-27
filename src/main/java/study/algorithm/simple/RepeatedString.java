package study.algorithm.simple;

/**
 * Created by EricWang on 2019/11/8 4:59 PM.
 */
public class RepeatedString {

    public static void main(String[] args) {
        long totalCount = repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L);
        System.out.println(totalCount);
    }

    static long repeatedString(String s, long n) {
        String regexp = "a";
        int orgLength = s.length();
        if (orgLength > n){
            String substring = s.substring(0, (int) (n));
            return countMatchInSmallString(substring,regexp);
        }

        long countInOneS = countMatchInSmallString(s, regexp);

        long repeatTimes = n / orgLength;

        int makeUpLength =(int )( n % orgLength);

        long makeUpCount = countMatchInSmallString(s.substring(0, makeUpLength), regexp);

        return countInOneS * repeatTimes + makeUpCount;

    }

    private static long countMatchInSmallString(String smallString, String regexp) {

        long occurence = 0;
        for (char   ch : smallString.toCharArray()){
            if (regexp.equals(String.valueOf(ch))){
                occurence++;
            }
        }

        return occurence;
    }

}
