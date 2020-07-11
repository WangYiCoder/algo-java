package study.algorithm.sort;

import java.util.Arrays;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < prices.length; i ++){
            if (sum >= k){
                return count;
            }

            sum = sum + prices[i];
            if (sum < k ){
                count++;
            }
        }

        return count;
    }
}
