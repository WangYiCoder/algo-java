package study.algorithm.dp;

/**
 * Created by EricWang on 2020/1/31 3:53 PM.
 * go up a stair case, one step on cross one stair or two stairs, how many different ways to finish the staircase with n stairs
 */
public class NStairCases {

    public int nStairCase(int n){

        if (n == 1){
            return 1;
        }

        if (n == 2){

            return 2;
        }

        int result = 0;

        int previous = 2;

        int preprevious = 1;
        for (int i = 3; i <= n; i++){

            result = previous + preprevious;

            preprevious = previous;

            previous = result;
        }

        return result;

    }
}
