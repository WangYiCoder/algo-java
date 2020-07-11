package study.algorithm.greedy;

import java.util.Arrays;

public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {

        int cost = 0;

        Arrays.sort(c);

        for (int i = c.length - 1; i >= 0; i--){

            int times = (c.length - i - 1)/k;

            cost = cost + (1+times)*c[i];
        }

        return cost;
    }
}
