package study.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by EricWang on 2020/2/9 6:11 PM.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0){
            return new int[0][0];
        }

        if (intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Stack<int[]> tempResults = new Stack<>();

        int[] init = new int[]{intervals[0][0],intervals[0][1]};
        tempResults.push(init);

        for (int i = 1; i < intervals.length; i++ ){
            int[] lastOne = tempResults.peek();

            if (lastOne[1] >= intervals[i][0]){
                lastOne[1] = Math.max(lastOne[1],intervals[i][1]);
                continue;
            }


            tempResults.push(intervals[i]);

        }

        int[][] result = new int[tempResults.size()][2];

        for (int i = tempResults.size() - 1; i >= 0; i--){
            result[i] = tempResults.pop();
        }

        return result;
    }
}
