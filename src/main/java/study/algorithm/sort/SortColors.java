package study.algorithm.sort;

/**
 * Created by EricWang on 2020/3/21 3:30 PM.
 * leetcode link: https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors t = new SortColors();
        //int[] nums = new int[]{2,0,2,1,1,0};
        //int[] nums = new int[]{2,0,1};
        //int[] nums = new int[]{1,2,0};
        int[] nums = new int[]{2,2,1};
        t.sortColors(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    // three way partition quick sort
    public void sortColors(int[] nums) {

        int i =0;
        int leftBound = 0;
        int rightBound = nums.length - 1;

        while (i <= rightBound){
            if (nums[i] == 0){
                if (leftBound == i){
                    leftBound++;
                    i++;
                    continue;
                }
                swap(i,leftBound,nums);
                leftBound++;
                continue;
            }

            if (nums[i] == 2){
                swap(i,rightBound,nums);
                rightBound--;
                continue;
            }
            i++;
        }

    }

    private void swap(int i1, int i2, int[] nums) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
