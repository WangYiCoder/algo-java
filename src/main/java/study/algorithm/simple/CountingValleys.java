package study.algorithm.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricWang on 2019/11/8 2:54 PM.
 */
public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(12,"DDUUDDUDUUUD"));
    }


    static int countingValleys(int n, String s) {

        char[] chars = s.toCharArray();

        List<Integer> steps = new ArrayList<>(n);

        int totalCount = 0;

        int initWithUpOrDown = 0;

        int tempSum = 0;


        for (int i = 0; i < n; i++){

            if (initWithUpOrDown == 0){
                if ("U".equals(String.valueOf(chars[i]))){
                    initWithUpOrDown = 1;
                }else {
                    initWithUpOrDown = -1;
                }
            }

            if ("U".equals(String.valueOf(chars[i]))){
                steps.add(1);
            }else {
                steps.add(-1);
            }


            tempSum = tempSum + steps.get(i);


            if (tempSum == 0){
                if (initWithUpOrDown == -1){
                    totalCount++;
                }
                if (i < n - 1){
                    if ("U".equals(String.valueOf(chars[i+1]))){
                        initWithUpOrDown = 1;
                    }else {
                        initWithUpOrDown = -1;
                    }
                }


            }
        }

        return totalCount;

    }

}
