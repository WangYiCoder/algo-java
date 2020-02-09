package study.algorithm.array;

/**
 * Created by EricWang on 2020/2/9 3:38 PM.
 */
public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums.length == 0){
            return result;
        }

        if (nums.length == 1){
            if (nums[0] == target){
                result[0] = 0;
                result[1] = 0;
            }

            return result;
        }

        int leftBound = 0;
        int rightBound = nums.length - 1;

        if (nums[leftBound] == target){
            getStartAndEnd(leftBound,nums,target,result);
            return result;
        }

        if (nums[rightBound] == target){
            getStartAndEnd(rightBound,nums,target,result);
        }

        while (true){

            if (rightBound - leftBound <= 1){
                break;
            }

            int midIndex = (leftBound + rightBound)/2;
            if (nums[midIndex] == target){
                getStartAndEnd(midIndex,nums,target,result);
                break;
            }

            if (nums[midIndex] >  target){
                rightBound = midIndex;
                continue;
            }

            leftBound = midIndex;

        }


        return result;
    }

    private void getStartAndEnd(int hitIndex, int[] nums, int target, int[] result) {

        int start = hitIndex;
        int end = hitIndex;

        while (start > 0){
            if (nums[start-1] != target){
                break;
            }
            start--;
        }

        while (end < nums.length - 1){
            if (nums[end+1] != target){
                break;
            }

            end++;
        }

        result[0] = start;
        result[1] = end;

    }
}
