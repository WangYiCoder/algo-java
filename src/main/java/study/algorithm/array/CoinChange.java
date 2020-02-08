package study.algorithm.array;

import java.util.*;

/**
 * Created by EricWang on 2020/2/2 3:15 PM.
 * leetcode link: https://leetcode.com/problems/coin-change/
 */
public class CoinChange {


    //basic idea of dp:
    // assume coins are: 2,3,5,6,9
    // so for amount 2,3,5,6,9, the min number of coins would be 1
    //based on this, could use for loop to calculate the min number of coins for amount from 1 to n.
    public int coinChange(int[] coins, int amount) {

        if (amount < 1){
            return 0;
        }

        if (coins.length == 0){
            return -1;
        }

        int[] results = new int[amount+1];

        for (int i = 1; i <= amount; i++){

            int qty = -1;

            for (int coin : coins){
                if (coin == i){
                    qty = 1;
                    break;
                }
                if (i - coin >= 1 && results[i - coin] != -1){
                    // i can be achieved from 'i - coint' + coin
                    if (qty == -1){
                        //no solution yet, so just use this one
                        qty = results[i-coin]+1;
                        continue;
                    }

                    if (results[i-coin] + 1 < qty){
                        //find a better solution
                        qty = results[i-coin] + 1;
                    }

                }
            }
            results[i] = qty;

        }

        return results[amount];

    }

    public static void main(String[] args) {
        CoinChange t = new CoinChange();
        int[] coins = new int[]{1,2,5};
        System.out.println(t.coinChange(coins,11));
    }
}
