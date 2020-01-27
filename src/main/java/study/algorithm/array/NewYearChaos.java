package study.algorithm.array;

/**
 * Created by EricWang on 2019/11/19 6:02 PM.
 */
public class NewYearChaos {

    public static void main(String[] args) {

    }

    static void minimumBribes(int[] q) {

        int totalBribeCount = 0;

        for (int i = q.length - 1; i >= 0; i --){
            if (q[i] - i > 3){
                System.out.println("Too chaotic");
                return;
            }

            int lowerBound = q[i] > 2 ? q[i] -2 : 0;
            for (int j = i - 1; j >= lowerBound; j --){
                if (q[j] > q [i]){
                    totalBribeCount++;
                }
            }
        }

        System.out.println(totalBribeCount);

    }
}
