package study.algorithm.stringmanipulation;

import java.util.ArrayList;
import java.util.List;

public class SpecialStringAgain {

    static long substrCount(int n, String s) {
        long count = 0L;

        char[] chars = s.toCharArray();
        List<RepeatCount> charRepeatCount = new ArrayList<>();

        for (int i = 0; i < chars.length;i++){

            if (i - 1 >= 0 && chars[i] == chars[i-1]){
                RepeatCount lastEle = charRepeatCount.get(charRepeatCount.size() - 1);
                lastEle.setCount(lastEle.getCount() + 1L);
                continue;
            }
            RepeatCount repeatCount = new RepeatCount(chars[i], 1L);
            charRepeatCount.add(repeatCount);
        }

        for (int i = 0; i < charRepeatCount.size(); i++){

            RepeatCount current = charRepeatCount.get(i);
            long currentCount = current.getCount();

            //get all substring count with mode like"a" or "aa"....
            count = count + (currentCount + currentCount * currentCount )/2;

            //check if matches "aba"
            if (i > 0 && i < charRepeatCount.size() - 1 && currentCount == 1L){

                RepeatCount previous = charRepeatCount.get(i - 1);
                RepeatCount next = charRepeatCount.get(i + 1);

                if (previous.getC() == next.getC()){

                    count = count + Math.min(previous.getCount(),next.getCount());
                }
            }


        }

        return count;

    }


    public static class RepeatCount {

        private char c;

        private long count;

        public RepeatCount(char c, long count) {
            this.c = c;
            this.count = count;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }
    }
}
