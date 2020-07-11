package study.algorithm.greedy;

import java.util.Arrays;

public class MinUnfair {

    static int maxMin(int k, int[] arr) {

        int minUnfair = Integer.MAX_VALUE;

        Arrays.sort(arr);
        for (int i = k-1; i< arr.length; i++){
            int deviation = arr[i] - arr[i-k+1];

            if (deviation < minUnfair){
                minUnfair = deviation;
            }
        }

        return minUnfair;

    }
}
