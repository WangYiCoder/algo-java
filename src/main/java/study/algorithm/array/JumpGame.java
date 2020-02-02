package study.algorithm.array;

/**
 * Created by EricWang on 2020/2/2 2:28 PM.
 * leetcode link: https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums.length == 1){
            return true;
        }

        out: for (int i = nums.length -2; i >= 0; i--){
            if (nums[i] > 0){
                continue;
            }

            //equals 0, must check if can bypass this one
            for (int j = i - 1; j >= 0; j--){
               if (nums[j] > i - j){
                   continue out;
               }
            }

            return false;

        }


        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        JumpGame t = new JumpGame();
        System.out.println(t.canJump(nums));
    }
}
