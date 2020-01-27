package study.algorithm.dp;

/**
 * Created by EricWang on 2019/12/15 8:22 PM.
 */
public class Candies {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,2,6,1,7,8,9,2,1};
        System.out.println(candies(10,arr));
    }

    static long candies(int n, int[] arr) {

        int[] solution1 = new int[n];
        int[] solution2 = new int[n];

        for (int i = 0; i <n; i++){
            solution1[i] = 1;
            solution2[i] = 1;
        }

        for (int i = 1; i < n; i ++){
            if (arr[i] <= arr[i-1]){
                solution1[i] = 1;
            }else {
                solution1[i] = solution1[i-1] + 1;
            }
        }

        for (int i = n-2 ; i >= 0; i--){
            if (arr[i] > arr[i+1]){
                solution2[i] = solution2[i+1] + 1;

            }
        }

        long sum = 0L;
        for (int i = 0; i < n; i++){
            sum = max(solution1[i],solution2[i]) + sum;
        }
        return sum;
    }

    private static long max(int i, int i1) {
        if (i > i1){
            return i;
        }

        return i1;
    }

}
