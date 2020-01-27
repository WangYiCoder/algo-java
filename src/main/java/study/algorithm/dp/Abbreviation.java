package study.algorithm.dp;

import java.util.Objects;

/**
 * Created by EricWang on 2019/12/11 1:08 PM.
 */
public class Abbreviation {

    /**
     * https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
     */
    private static boolean result = false;
    public static void main(String[] args) {
        //String a = "BFZZVHdQYHQEMNEFFRFJTQmNWHFVXRXlGTFNBqWQmyOWYWSTDSTMJRYHjBNTEWADLgHVgGIRGKFQSeCXNFNaIFAXOiQORUDROaNoJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMvSTGEQCYAJSFvbqivjuqvuzafvwwifnrlcxgbjmigkms";
        //String b = "BFZZVHQYHQEMNEFFRFJTQNWHFVXRXGTFNBWQOWYWSTDSTMJRYHBNTEWADLHVGIRGKFQSCXNFNIFAXOQORUDRONJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMSTGEQCYAJSF";
        String a = "AfPZN";
        String b = "APZNC";
        System.out.println(abbreviation(a,b));
    }


    static String abbreviation(String a, String b) {

        if (a.length() < b.length()){
            return "NO";
        }
        char[] toCheck = a.toCharArray();
        CharNode[] checkNodeArr = new CharNode[toCheck.length];
        for (int i = 0; i < toCheck.length; i++){
            CharNode charNode = CharNode.of(i, toCheck[i]);
            checkNodeArr[i] = charNode;
        }

        char[] bChars = b.toCharArray();
        String[] standard = new String[bChars.length];
        for (int i = 0; i < bChars.length;i ++){
            standard[i] = String.valueOf(bChars[i]);
        }
        boolean[][] states = new boolean[toCheck.length + 1][bChars.length + 1];
        checkAbbr(0,checkNodeArr,0,standard,states);
        if (result){
            return "YES";
        }
        return "NO";
    }



    static void checkAbbr(int i, CharNode[] checkNodeArr, int j, String[] standard, boolean[][] states){

        if (states[i][j]){
            return;
        }

        if (i == checkNodeArr.length && j < standard.length){
            return;
        }

        if (j == standard.length && i == checkNodeArr.length){
            result = true;
            return;
        }

        if ( j == standard.length && i < checkNodeArr.length){

            for (int index = i; index < checkNodeArr.length; index ++){
                if (!checkNodeArr[index].isLowerCase()){
                    return;
                }
            }
            result = true;
            return;
        }

        CharNode node = checkNodeArr[i];

        states[i][j] = true;
        if (node.isLowerCase()){
            if (Objects.equals(node.getUpperC(),standard[j])){
                checkAbbr(i+1,checkNodeArr,j+1,standard,states);
            }

            checkAbbr(i+1,checkNodeArr,j,standard,states);
        }else {

            if (Objects.equals(node.getC(),standard[j])){
                checkAbbr(i+1,checkNodeArr,j+1,standard,states);
            }
        }

    }

    public static class CharNode{

        private int index;

        private boolean isLowerCase;

        private String c;

        private String upperC;

        public String getUpperC() {
            return upperC;
        }

        public void setUpperC(String upperC) {
            this.upperC = upperC;
        }

        public static CharNode of(int index, char originChar){
            CharNode charNode = new CharNode();
            charNode.setIndex(index);
            charNode.setC(String.valueOf(originChar));
            charNode.setUpperC(String.valueOf(originChar).toUpperCase());
            charNode.setLowerCase(!Objects.equals(String.valueOf(originChar),String.valueOf(originChar).toUpperCase()));
            return charNode;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean isLowerCase() {
            return isLowerCase;
        }

        public void setLowerCase(boolean lowerCase) {
            isLowerCase = lowerCase;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

    }




    /**
     * the solution below fail at some corner cases
     */
    /*static String abbreviation(String a, String b) {

        if (a.length() < b.length()){
            return "NO";
        }

        char[] toCheck = a.toCharArray();
        char[] standard = b.toCharArray();

        int toCheckIndex = 0;

        //when a mismatch happens and we have make a lowercase to upper case before
        //we may step back to remove that lower case and retry
        int lowerCaseWordIndex = -1;
        int lowerCasedMatchedIndexInB = -1;

        boolean comesFromStepBack = false;

        out: for (int i = 0; i < b.length(); i ++){

            for (; toCheckIndex < a.length();){

                Boolean isLowercase = ! Objects.equals(String.valueOf(toCheck[toCheckIndex]),String.valueOf(toCheck[toCheckIndex]).toUpperCase());
                if (!isLowercase && !Objects.equals(toCheck[toCheckIndex],standard[i])){
                    System.out.println("return no at 1, toCheckIndex = " + toCheckIndex +"standard index = " + i);

                    if (comesFromStepBack){
                        return "NO";
                    }

                    if (lowerCaseWordIndex != -1){
                        toCheckIndex = lowerCaseWordIndex;
                        i = lowerCasedMatchedIndexInB - 1;
                        comesFromStepBack = true;
                        continue out;
                    }

                    return "NO";
                }

                if (!isLowercase && comesFromStepBack){
                    comesFromStepBack = false;
                    lowerCaseWordIndex = -1;
                    lowerCasedMatchedIndexInB = -1;
                }

                if (Objects.equals(standard[i],toCheck[toCheckIndex]) || (Objects.equals(String.valueOf(standard[i]),String.valueOf(toCheck[toCheckIndex]).toUpperCase()) && !comesFromStepBack)){
                    if (toCheckIndex == toCheck.length - 1 && i < standard.length - 1){
                        System.out.println("return no at 2, toCheckIndex = " + toCheckIndex +"standard index = " + i);
                        return "NO";
                    }

                    if (isLowercase && lowerCaseWordIndex == -1){
                        lowerCaseWordIndex = toCheckIndex;
                        lowerCasedMatchedIndexInB = i;
                    }

                    toCheckIndex ++;
                    continue out;
                }
                if (toCheckIndex == toCheck.length - 1){
                    System.out.println("return no at 3, toCheckIndex = " + toCheckIndex +"standard index = " + i);
                    return "NO";
                }
                toCheckIndex ++;

            }

        }

        int lastMatchedIndex = toCheckIndex - 1;

        for (;toCheckIndex < toCheck.length; toCheckIndex++){
            if (Objects.equals(String.valueOf(toCheck[toCheckIndex]),String.valueOf(toCheck[toCheckIndex]).toUpperCase() )){
                System.out.println("return no at 4, toCheckIndex = " + toCheckIndex );
                for (int j = lastMatchedIndex; j < toCheckIndex; j++){

                }

                return "NO";
            }
        }


        return "YES";

    }*/
}
