package study.algorithm.array;

/**
 * Created by EricWang on 2019/11/8 5:57 PM.
 */
public class HourGlass {

    public static void main(String[] args) {

    }


    static int hourglassSum(int[][] arr) {

        int maxSum = 0;

        for (int i = 0; i < arr.length -2; i++){
            for (int j = 0; j < arr[0].length -2; j++){

                int sumOfOneHourGlass = arr[i][j] + arr[i][j+1]+ arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                if (i == 0 && j ==0){
                    maxSum = sumOfOneHourGlass;
                    continue;
                }

                if (sumOfOneHourGlass > maxSum){
                    maxSum = sumOfOneHourGlass;
                }

            }
        }



        return maxSum;

    }

}
