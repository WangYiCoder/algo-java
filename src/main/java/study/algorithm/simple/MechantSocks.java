package study.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2019/11/8 2:41 PM.
 */
public class MechantSocks {

    public static void main(String[] args) {

    }


    static int sockMerchant(int n, int[] ar) {

        Map<Integer,Integer> colorCount = new HashMap<>();

        int totalPairs = 0;

        for (int i = 0; i < n; i++){
            Integer colour = ar[i];

            if (colorCount.get(colour) == null){
                colorCount.put(colour,1);
                continue;
            }

            Integer currentCount = colorCount.get(colour);

            if (currentCount % 2 == 1){
                totalPairs++;
            }

            colorCount.put(colour,currentCount+1);
        }


        return totalPairs;
    }
}
