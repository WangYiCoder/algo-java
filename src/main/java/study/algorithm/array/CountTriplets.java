package study.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by EricWang on 2019/11/20 4:00 PM.
 */
public class CountTriplets {

    public static void main(String[] args) {

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            arr.add(1237L);
        }

        System.out.println(countTriplets(arr, 1L));
    }

    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> uniqNumberWithCount = new TreeMap<>();

        for (Long a : arr) {

            if (uniqNumberWithCount.get(a) == null) {
                uniqNumberWithCount.put(a, 1L);
                continue;
            }

            uniqNumberWithCount.put(a, uniqNumberWithCount.get(a) + 1);
        }

        long totalCount = 0L;

        for (Long key : uniqNumberWithCount.keySet()) {

            if (uniqNumberWithCount.get(key * r) == null || uniqNumberWithCount.get(key * r * r) == null) {
                continue;
            }

            if (r  == 1L){
                Long specialKeyCount = uniqNumberWithCount.get(key);
                if (specialKeyCount < 3){
                    continue;
                }

                for (int i = 1; i <= specialKeyCount - 2; i++){

                    totalCount = totalCount + (1L + i) * i / 2L;
                }
                continue;
            }
            totalCount = totalCount + uniqNumberWithCount.get(key) * uniqNumberWithCount.get(key * r) * uniqNumberWithCount.get(key * r * r);
        }

        return totalCount;

    }

    //166661666700000
    //2325652489

}
