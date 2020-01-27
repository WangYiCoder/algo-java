package study.algorithm.stringmanipulation;

/**
 * Created by EricWang on 2020/1/24 7:52 PM.
 */
public class Atoi{


    public int myAtoi(String str) {

        char[] chars = str.toCharArray();

        int whitespaceCharValue = (int)' ';

        int zeroCharValue = (int)'0';

        int nineCharValue = (int)'9';

        int plusCharValue = (int)'+';

        int minusCharValue = (int)'-';

        int max = Integer.MAX_VALUE;

        int min = Integer.MIN_VALUE;

        int maxNumberDigitsLength = String.valueOf(max).length();

        boolean begnningEmptyFinished = false;

        String negativeOrPositveSign = "";

        String numberSeq = "";

        for (int i = 0; i < chars.length; i++){

            int current = (int)chars[i];

            if (current == whitespaceCharValue && !begnningEmptyFinished){
                continue;
            }

            if (current != whitespaceCharValue && !begnningEmptyFinished){
                begnningEmptyFinished = true;
                if (current == plusCharValue || current == minusCharValue){
                    negativeOrPositveSign = String.valueOf(chars[i]);
                    continue;
                }
            }

            if (begnningEmptyFinished){

                if (current > nineCharValue || current < zeroCharValue){
                    break;
                }

                if (current == zeroCharValue && numberSeq.equals("")){
                    continue;
                }
                numberSeq = numberSeq + String.valueOf(chars[i]);
            }

            if (numberSeq.length() > maxNumberDigitsLength){
                if (negativeOrPositveSign.equals("")|| negativeOrPositveSign.equals( "+")){
                    return max;
                }else {
                    return min;
                }
            }

        }

        if (numberSeq.equals("")){
            return 0;
        }

        String finalNumericString = negativeOrPositveSign + numberSeq;

        Long finalLongValue = Long.valueOf(finalNumericString);

        if (finalLongValue > max){
            return max;
        }

        if (finalLongValue < min){
            return min;
        }


        return finalLongValue.intValue();
    }


    public static void main(String[] args) {


        int max = Integer.MAX_VALUE;

        int min = Integer.MIN_VALUE;

        System.out.println(max);
        System.out.println(min);

        String testNegative = "-12432";

        Long testNegativeLongValue = Long.valueOf(testNegative);

        System.out.println(testNegativeLongValue);

        String str = "    +11191657170";
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi(str));

    }
}
