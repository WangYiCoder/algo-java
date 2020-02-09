package study.algorithm.array;

/**
 * Created by EricWang on 2020/2/9 11:12 AM.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        if (nums.length == 1){
            if (nums[0] == target){
                return 0;
            }
            return -1;
        }

        int minInBiggerPart = nums[0];
        if (target == minInBiggerPart) {
            return 0;
        }
        int maxInSmallerPart = nums[nums.length - 1];
        if (target == maxInSmallerPart) {
            return nums.length - 1;
        }

        if (maxInSmallerPart > minInBiggerPart){
            return binarySearch(0, nums.length-1,nums,target);
        }


        //find the two area
        int leftBound = 0;
        int rightBound = nums.length - 1;

        //
        int biggerPartEnd = 0;

        while (true) {

            if (rightBound - leftBound == 1){
               biggerPartEnd = leftBound;
               break;
            }

            int midIndex = (leftBound + rightBound) / 2;
            int midValue = nums[midIndex];

            if (midValue == target) {
                return midIndex;
            }

            if (midIndex+1 < nums.length && nums[midIndex] > nums[midIndex+1]){
                biggerPartEnd = midIndex;
                break;
            }

            if (midIndex > 0 && nums[midIndex] < nums[midIndex - 1]){
                biggerPartEnd = midIndex - 1;
                break;
            }

            if (midValue > maxInSmallerPart) {
                leftBound = midIndex;
                continue;
            } else {
                rightBound = midIndex;
                continue;
            }
        }


        if (target == nums[biggerPartEnd]){
            return biggerPartEnd;
        }

        if (target == nums[biggerPartEnd + 1]){
            return biggerPartEnd + 1;
        }

        if (target > nums[biggerPartEnd] || target < nums[biggerPartEnd+1]){
            return -1;
        }

        //choose a proper area to do binary search
        if (target > minInBiggerPart){
            leftBound = 0;
            rightBound = biggerPartEnd;
        }else {
            leftBound = biggerPartEnd + 1;
            rightBound = nums.length -1;
        }


        return binarySearch(leftBound,rightBound,nums,target);
    }

    private int binarySearch(int leftBound, int rightBound, int[] nums,int target) {

        while (true){

            if (rightBound - leftBound <= 1){
                return -1;
            }
            int midIndex = (rightBound+leftBound)/2;

            if (nums[midIndex] == target){
                return midIndex;
            }

            if (target > nums[midIndex]){
                leftBound = midIndex;
                continue;
            }else {
                rightBound = midIndex;
                continue;
            }

        }
    }
}
