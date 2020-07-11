package study.algorithm.stack;

public class MinMaxRiddle {

    static long[] riddle(long[] arr) {
        // complete this function
        long[] result = new long[arr.length];

        long[] minsOfEachWindow = new long[arr.length];

        long maxInTheArray = arr[0];
        for (int i = 0; i < arr.length;i++){
            minsOfEachWindow[i] = arr[i];
            if (arr[i] > maxInTheArray){
                maxInTheArray = arr[i];
            }

        }
        result[0] = maxInTheArray;

        for (int i = 1; i < arr.length; i ++){
            long maxOfCurrentWindowMins = 0L;

            for (int j = i; j < arr.length; j++){
                if (arr[j] < minsOfEachWindow[j-i]){
                    minsOfEachWindow[j-i] = arr[j];
                }
                if (minsOfEachWindow[j-i] > maxOfCurrentWindowMins){
                    maxOfCurrentWindowMins = minsOfEachWindow[j-i];
                }
            }

            result[i] = maxOfCurrentWindowMins;

        }


        return result;

    }




}
