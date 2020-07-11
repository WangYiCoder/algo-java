package study.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        Set<Integer> intSets = new HashSet<>();

        for (int i : A){
            if ( i > 0){ intSets.add(i);
            }

        }

        if (intSets.isEmpty()){
            return 1;
        }

        for (Integer i = 1; ; i++){
            if (!intSets.contains(i)){
                return i;
            }
        }

    }
}
