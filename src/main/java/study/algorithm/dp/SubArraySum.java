package study.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2020/3/19 10:16 AM.
 * leetcode link: https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubArraySum {

    //key, sum(i,j) = sum(0,j) - sum(0,i)
    //so what we need to do is just calculate all sum(0,0), sum(0,1)....sum(0,n)
    //let's assume, if there exists sum(i,j) equals to K, there will be a sum(0,j) and sum(0,i-1) and sum(0,i-1) == k.
    public int subarraySum(int[] nums, int k) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,0);
        for (int i = 0; i < nums.length;i++){
            sum+=nums[i];
            if (preSum.containsKey(sum-k)){
                count += preSum.get(sum-k);
            }
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }


        return count;
    }
}
