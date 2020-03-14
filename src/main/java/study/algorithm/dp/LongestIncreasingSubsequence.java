package study.algorithm.dp;

/**
 * Created by EricWang on 2020/3/14 4:16 PM.
 * leetcode link: https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};

        LongestIncreasingSubsequence t = new LongestIncreasingSubsequence();

        System.out.println(t.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return 1;
        }

        int max = 1;

        int[] result = new int[nums.length];
        result[0] = 1;

        out:for (int i = 1; i < nums.length;i++){

           int temp = 1;
           for (int j = i -1; j >= 0; j--){
               if (nums[j] < nums[i]){
                   if (temp < result[j] + 1){
                       temp = result[j] + 1;
                       if (temp > max){
                           max = temp;
                           result[i] = max;
                           continue out;
                       }

                       if (result[j] == j+1){
                           result[i] = temp;
                           continue out;
                       }
                   }
               }
           }

           result[i] = temp;
           if (temp > max){
               max = temp;
           }


        }


        return max;
    }
}
