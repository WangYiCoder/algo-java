package study.algorithm.dp;

/**
 * Created by EricWang on 2020/3/15 8:54 AM.
 * leetcode link: https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        PartitionEqualSubsetSum t = new PartitionEqualSubsetSum();
        boolean result = t.canPartition(nums);
        System.out.println(result);
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2){
            return false;
        }

        //calculate total sum
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            sum += nums[i];
        }

        if (sum%2 == 1 ){
            //odd value, definetly false

            return false;
        }

        //check if part of the elements sum can be sum/2
        //solution would be similar to knapsack
        int target = sum/2;
        boolean[][] temp = new boolean[nums.length][target+1];
        int tempSum = 0;

        return check(0,tempSum,temp,target,nums);

    }

    private boolean check(int i, int tempSum, boolean[][] temp, int target, int[] nums) {
        if (tempSum == target){
            return true;
        }

        if (tempSum > target){
            return false;
        }

        if (i == nums.length){
            return false;
        }

        if (temp[i][tempSum]){
            return false;
        }

        temp[i][tempSum] = true;

        boolean result = check(i + 1, tempSum, temp, target, nums);
        if (result){
            return true;
        }

        return check(i + 1, tempSum + nums[i], temp, target, nums);

    }
}
