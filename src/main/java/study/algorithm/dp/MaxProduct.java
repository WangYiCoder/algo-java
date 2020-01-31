package study.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricWang on 2020/1/29 10:01 PM.
 *
 * leetcode link: https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProduct {

    //answer from other people, didn't quite understand this yet
    public int maxProduct(int[] nums) {

        if (nums.length == 1){
            return nums[0];
        }


        int maxProduct = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++){
            int preMax = max;
            int preMin = min;

            max = Math.max(Math.max(nums[i],preMin * nums[i]),preMax * nums[i]);

            min = Math.min(Math.min(nums[i],preMin*nums[i]),preMax * nums[i]);

            maxProduct = Math.max(max,maxProduct);

        }


        return maxProduct;

    }

    /*
    time complexity too high

    public int maxProduct(int[] nums) {

        if (nums.length == 1){
            return nums[0];
        }

        List<Integer> allProducts = new ArrayList<>();
        allProducts.add(nums[0]);

        for (int i = 1; i < nums.length; i++){
            allProducts.add(nums[i]);
            int count = 0;
            for (int j = allProducts.size() - 2; ;j--){
                int current = allProducts.get(j) * nums[i];
                allProducts.add(current);
                count ++;

                if (count == i){
                    break;
                }
            }
        }

        int maxProduct = allProducts.get(0);
        for (int i = 1; i < allProducts.size(); i ++){
            if (allProducts.get(i) > maxProduct){
                maxProduct = allProducts.get(i);
            }
        }

        return maxProduct;

    }*/
}
