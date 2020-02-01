package study.algorithm.array;

import java.util.Arrays;

/**
 * Created by EricWang on 2020/1/31 9:20 PM.
 * leetcode link: https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1){
            return;
        }

        if (descendedArray(nums)){
            reverseArray(nums);
            return;
        }

        //search from tail, find the first one that larger than the tail, then swap.
        for (int i = nums.length - 2; i >= 0; i --){

            for (int j = nums.length - 1; j > i; j--){

                if (nums[j] > nums[i]){
                    swapIandJ(nums,i,j);
                    //re-arrange j+1 to end as ascend
                    Arrays.sort(nums,i+1, nums.length);
                    return;
                }
            }

        }



    }

    private void swapIandJ(int[] nums, int i, int j) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    private void reverseArray(int[] nums) {
        for (int i = 0; i < nums.length/2; i++){
            int tailIndex = nums.length - i -1;
            swapIandJ(nums,i,tailIndex);

        }
    }

    private boolean descendedArray(int[] nums) {

        for (int i = 1; i < nums.length; i++){

            if (nums[i] > nums[i-1]){
                return false;
            }
        }

        return true;
    }
}
