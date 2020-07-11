package study.algorithm.search;

import java.util.Map;
import java.util.TreeMap;

public class PairsDiff {

    static int pairs(int k, int[] arr) {

        int total = 0;

        Map<Integer,Integer> eleMap = new TreeMap<>();

        for (int i : arr){
            Integer count = eleMap.get(i);
            if (count == null){
                eleMap.put(i,1);
                continue;
            }

            eleMap.put(i,count+1);
        }

       for (Integer key : eleMap.keySet()){
           Integer targetKey = key + k;
           Integer targetCount = eleMap.get(targetKey);
           if (targetCount == null){
               continue;
           }
           total = total + targetCount * eleMap.get(key);

       }

        return total;
    }
}
