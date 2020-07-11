package study.algorithm.sort;

import java.util.*;

public class FradulentActivityNotifications {

    public static void main(String[] args) {
        int[] expenditure = new int[]{2,3,4,2,3,6,8,4,5};
        System.out.println(activityNotifications(expenditure,5));
    }

    static int activityNotifications(int[] expenditure, int d) {

       Set<IndexValue> init = new TreeSet<>(new Comparator<IndexValue>() {
           @Override
           public int compare(IndexValue o1, IndexValue o2) {
               if (o1.getValue() >= o2.getValue()){
                   return 1;
               }
               return -1;
           }
       });

        for (int i = 0; i < d;i ++){
            IndexValue indexValue = new IndexValue(i, expenditure[i]);
            init.add(indexValue);
        }

        List<IndexValue> currentSample = new ArrayList<>(d);
        for (IndexValue indexValue : init){
            currentSample.add(indexValue);
        }


        int total = 0;
        for (int i = d; i < expenditure.length; i++){
            int doubleMedian = getDoubleMedian(d, currentSample);
            if (expenditure[d] >= doubleMedian){
                total++;
            }

            if (i == expenditure.length - 1){
                break;
            }

            List<IndexValue> newSample = new ArrayList<>(d);

            int newValue = expenditure[i];
            boolean alreadyAddNewValue = false;
            for (IndexValue orgElement :  currentSample){
                if (orgElement.getIndex() == i - d){
                    continue;
                }

                if (!alreadyAddNewValue){
                    if (orgElement.getValue() >= newValue){
                        newSample.add(new IndexValue(i,newValue));
                        alreadyAddNewValue = true;
                    }
                }

                newSample.add(orgElement);
            }

            if (!alreadyAddNewValue){
                newSample.add(new IndexValue(i,newValue));
            }

            currentSample = newSample;

        }


        return total;
    }

    private static int getDoubleMedian(int d, List<IndexValue> currentSample) {

        if (d % 2 == 1){
            return currentSample.get((d-1)/2).getValue() * 2;
        }else {
           return currentSample.get(d/2).getValue() + currentSample.get(d/2 -1).getValue();
        }

    }

    public static class IndexValue{

        private int index;

        private int value;

        public IndexValue(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
