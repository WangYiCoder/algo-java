package study.algorithm.stringmanipulation;

public class AlterChars {

    public static void main(String[] args) {

    }

    static int alternatingCharacters(String s) {

        int total = 0;

        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++){
            if (chars[i] == chars[i-1]){
                total++;
            }
        }

        return total;
    }
}
