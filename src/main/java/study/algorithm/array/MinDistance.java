package study.algorithm.array;

import java.util.Arrays;

/**
 * Created by EricWang on 2020/4/5 10:46 AM.
 */
public class MinDistance {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length < 2){
            return 0;
        }
        Arrays.sort(A);
        int minDistance = A[1] - A[0];
        for (int i = 1; i < A.length - 1; i++ ){
            if (A[i+1] - A[i] < minDistance){
                minDistance = A[i+1] - A[i];
            }
        }

        return minDistance;

    }
}
