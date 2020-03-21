package study.algorithm.dp;

/**
 * Created by EricWang on 2020/3/21 2:04 PM.
 * leetcode link: https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares t = new PerfectSquares();
        System.out.println(t.numSquares(12));
    }

    //time complexity can be improved
    public int numSquares(int n) {

        if (n <= 1){
            return 1;
        }

        int[] results = new int[n+1];

        int t = 1;
        while (t*t <= n){
            results[t*t] = 1;
            t++;
        }
        t -= 1;
        if (results[n] == 1){
            return 1;
        }

        for (int i = 2; i <= n; i++){
            if (results[i] > 0){
                continue;
            }
            int temp = 0;
            inner: for (int j = 1; j <= t; j++){
                if (i - j * j < 0){
                    break inner;
                }
                if (temp == 0){
                    temp = results[i - j*j] + 1;
                    continue;
                }
                if (temp >  results[i - j*j] + 1){
                    temp = results[i - j*j] + 1;
                }

            }

            results[i] = temp;
        }


        return results[n];

    }
}
