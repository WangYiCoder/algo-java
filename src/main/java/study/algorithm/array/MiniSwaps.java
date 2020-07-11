package study.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniSwaps {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,3,2,4,5,6};
        System.out.println(minimumSwaps(arr));
    }

    static int minimumSwaps(int[] arr) {

        Map<Integer, Integer> positionAndValue = new HashMap<>(arr.length);

        List<Integer> postions = new ArrayList<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i]) {
                positionAndValue.put(i + 1, arr[i]);
                postions.add(i + 1);
            }
        }
        if (positionAndValue.size() == 0) {
            return 0;
        }

        int totalStep = 0;

        //deal with pairs
        List<Integer> removedPairs = new ArrayList<>(postions.size());
        for (int i = 0; i < postions.size(); i++) {

            Integer position1 = postions.get(i);

            Integer value1 = positionAndValue.get(position1);
            if (position1.equals(value1)) {
                continue;
            }
            Integer value2 = positionAndValue.get(value1);

            if (position1.equals(value2)) {
                totalStep++;
                positionAndValue.put(position1, value2);
                positionAndValue.put(value1, value1);
                continue;
            }
            removedPairs.add(position1);
        }
        int leftSize = removedPairs.size();
        postions = removedPairs;

        for (int i = 0; i < leftSize +1; i++){
            if (postions.size() == 0) {
                return totalStep;
            }
            if (postions.size() == 2) {
                return totalStep + 1;
            }
            Integer positionNeedChange = postions.get(0);
            Integer valueWillBackToNormal = positionAndValue.get(positionNeedChange);
            Integer valueTobeSwapped = positionAndValue.get(valueWillBackToNormal);
            positionAndValue.put(positionNeedChange, valueTobeSwapped);
            positionAndValue.put(valueWillBackToNormal, valueWillBackToNormal);
            postions.remove(valueWillBackToNormal);
            totalStep++;
            //check if this swap makes a new pair
            Integer secondCheckValue = positionAndValue.get(valueTobeSwapped);
            if (positionNeedChange.equals(secondCheckValue)) {
                positionAndValue.put(positionNeedChange, secondCheckValue);
                positionAndValue.put(valueTobeSwapped, valueTobeSwapped);
                postions.remove(positionNeedChange);
                postions.remove(valueTobeSwapped);
                totalStep++;
            }
        }
        return totalStep;
    }
}
