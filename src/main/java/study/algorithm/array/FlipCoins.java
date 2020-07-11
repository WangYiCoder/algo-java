package study.algorithm.array;

public class FlipCoins {

    public int solution(int[] A) {
        // write your code in Java SE 8

        // input check
        if (A == null || A.length < 2){
            return 0;
        }

        //reversed counts if we decide "010101..."
        int startWithZeroCount = 0;

        //reversed counts, if we decide "10101...."
        int startWithOneCount = 0;

        int startWithZeroCurrentCorrectSide = 0;

        int startWithOneCurrentCorrectSide = 1;

        for (int i = 0; i < A.length; i++){
            if (A[i] != startWithZeroCurrentCorrectSide){
                startWithZeroCount++;
            }else {
                startWithOneCount++;
            }

            //swap correct sides for next round
            int tmp = startWithOneCurrentCorrectSide;
            startWithOneCurrentCorrectSide = startWithZeroCurrentCorrectSide;
            startWithZeroCurrentCorrectSide = tmp;


        }

        return Math.min(startWithOneCount,startWithZeroCount);
    }
}
