package study.algorithm.array;

import java.util.List;

public class MinX {

    public static int minX(List<Integer> arr) {
        // Write your code here
        if (arr == null || arr.isEmpty()){
            return 1;
        }

        if (arr.size() == 1){
            return 1 - arr.get(0);
        }

        int arrEleSum = arr.get(0);
        int minArrEleSum = arr.get(0);

        for (int i = 1; i < arr.size(); i++){
            arrEleSum += arr.get(i);
            if (arrEleSum < minArrEleSum){
                minArrEleSum = arrEleSum;
            }
        }

        return  1 - minArrEleSum;

    }
}
