package study.algorithm.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TripleSum {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7};
        int[] b = new int[]{5,7,9};
        int[] c = new int[]{7,9,11,13};
        System.out.println(triplets(a,b,c));
    }

    static long triplets(int[] a, int[] b, int[] c) {
        long total = 0L;

        Set<Integer> aSet = removeDuplicate(a);
        Set<Integer> bSet = removeDuplicate(b);
        Set<Integer> cSet = removeDuplicate(c);

        List<Integer> aList = new ArrayList<>(aSet);
        List<Integer> bList = new ArrayList<>(bSet);
        List<Integer> cList = new ArrayList<>(cSet);


        int lastIndexInA = 0;
        int lastIndexInC = 0;

        for (Integer currentEleInB : bList){

                int maxAIndex = getMaxQualifiedIndex(currentEleInB,aList,lastIndexInA);
                if (maxAIndex == -1){
                    continue;
                }
                lastIndexInA = maxAIndex;


                int maxCIndex = getMaxQualifiedIndex(currentEleInB,cList,lastIndexInC);
                if (maxCIndex == -1){
                    continue;
                }
                lastIndexInC = maxCIndex;
                total = total + (maxAIndex + 1L)*(maxCIndex + 1L);
        }

        return total;

    }

    private static int getMaxQualifiedIndex(int bVal, List<Integer> cList, int startIndex) {

        int endIndex = cList.size() - 1;
        if (cList.get(startIndex) > bVal){
            return -1;
        }
        if (endIndex == startIndex){
            return endIndex;
        }

        while (true){

            if (endIndex - startIndex == 1){
                if (cList.get(endIndex) <= bVal){
                    return endIndex;
                }else {
                    return startIndex;
                }
            }

            int middleIndex;
            if ((endIndex + startIndex) % 2 == 0){
                middleIndex = (endIndex + startIndex)/2;
            }else {
                middleIndex = (endIndex + startIndex + 1)/2;
            }

            if (cList.get(middleIndex) > bVal){
                endIndex = middleIndex;
                continue;
            }

            if (cList.get(middleIndex) < bVal){
                startIndex = middleIndex;
                continue;
            }
            return middleIndex;

        }

    }




    private static Set<Integer> removeDuplicate(int[] arr) {
        Set<Integer> s = new TreeSet<>();
        for (int i : arr){
            s.add(i);
        }

        return s;
    }

}
