package study.algorithm.greedy;

import java.util.Arrays;

public class MinAbsDiff {

    static int minimumAbsoluteDifference(int[] arr) {
        int minAbsDiff = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++){

            int currentDiff = Math.abs(arr[i] - arr[i - 1]);

            if (currentDiff == 0){
                return currentDiff;
            }

            if (currentDiff < minAbsDiff){
                minAbsDiff = currentDiff;
            }

        }


        return minAbsDiff;

    }
}
