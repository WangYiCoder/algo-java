package study.algorithm.array;

/**
 * Created by EricWang on 2020/3/15 10:07 AM.
 * leetcode link: https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1){
            return false;
        }

        //check from right-upper corner
        int rowIndex = matrix.length -1;
        int columnIndex = 0;

        while (rowIndex >= 0 && columnIndex <= matrix[0].length - 1){
            int currentValue = matrix[rowIndex][columnIndex];
            if (currentValue == target){
                return true;
            }

            if (currentValue > target){
                rowIndex --;
                continue;
            }

            columnIndex++;
        }

        return false;

    }
}
