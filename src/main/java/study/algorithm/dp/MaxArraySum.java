package study.algorithm.dp;

import java.util.Scanner;

/**
 * Created by EricWang on 2019/12/9 9:45 PM.
 */
public class MaxArraySum {

    private static final Scanner scanner = new Scanner(System.in);

    private static int maxSum = 0;

    private static int maxELement = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //int[] arr = new int[]{3,5,-7,-9,-10,8,7,-10,1,1,88};
        //System.out.println(maxSubsetSum(arr));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int res = maxSubsetSum(arr);

        System.out.println(res);
    }

    //the below solution can't solve some corner cases
    static int maxSubsetSum(int[] arr) {

        int max = 0;
        int previousMax = 0;

        int maxIntheArray = Integer.MIN_VALUE;

        boolean isLastOneIncluded = false;

        for (int i = 0; i < arr.length; i++){

            maxIntheArray = getMax(maxIntheArray,arr[i]);

            if (i == 0){
                max = getMax(max,arr[0]);
                previousMax = max;
            }

            if (i == 1){
                if (arr[1] > max){
                    previousMax = max;
                    isLastOneIncluded = true;
                    max = arr[1];
                }
            }

            if (i > 1){

                if (isLastOneIncluded){
                    if (previousMax + arr[i] > max){
                        int tmp = max;
                        max = previousMax + arr[i];
                        isLastOneIncluded = true;
                        previousMax = tmp;
                        continue;
                    }
                    previousMax = max;
                    isLastOneIncluded = false;
                    continue;

                }
                if (max + arr[i] > max){
                    int tmp = max;
                    max = max + arr[i];
                    previousMax = tmp;
                    isLastOneIncluded = true;
                    continue;
                }
                previousMax = max;

            }
        }

        if(maxIntheArray < 0){
            return maxIntheArray;
        }

        return max;
    }

    private static int getMax(int max, int i) {

        if (max < i){
            return i;
        }

        return max;
    }

}
