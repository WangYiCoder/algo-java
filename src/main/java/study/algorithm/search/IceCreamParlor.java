package study.algorithm.search;

import java.util.*;

public class IceCreamParlor {
    public static void main(String[] args) {
        int[] cost = new int[]{7,2,5,4,11};
        int money = 12;

        whatFlavors(cost,money);
    }
    static void whatFlavors(int[] cost, int money) {

        Set<CostIndex> costSet = new TreeSet<>(new Comparator<CostIndex>() {
            @Override
            public int compare(CostIndex o1, CostIndex o2) {
                if (o1.getCost() >= o2.getCost()){
                    return 1;
                }

                return -1;
            }
        });

        for (int i = 0; i < cost.length; i++){
            CostIndex costIndex = new CostIndex(i + 1, cost[i]);
            costSet.add(costIndex);
        }

        List<CostIndex> sortedCostList = new ArrayList<>(costSet);

        for (int i = 0; i < cost.length; i++){
            CostIndex firstHalf = sortedCostList.get(i);
            int firstHalCost = firstHalf.getCost();

            if (firstHalCost >= money){
                continue;
            }



            CostIndex secondHalf = binarySearch(i,sortedCostList,money - firstHalCost);
            if (secondHalf == null){
                continue;
            }

            int index1 = firstHalf.getIndex();
            int index2 = secondHalf.getIndex();
            if (index1 < index2){
                System.out.println(index1 + " "+ index2);
            }else {
                System.out.println(index2 + " "+ index1);
            }

            break;

        }

    }

    private static CostIndex binarySearch(int i, List<CostIndex> sortedCostList, int target) {
        int lowerBound = i+1;
        int upperBound = sortedCostList.size() - 1;
        if (upperBound < i){
            return null;
        }


        int middleIndex = 0;

        while (true){
            if (upperBound == lowerBound){
                CostIndex checked = sortedCostList.get(upperBound);
                if (checked.getCost() == target){
                    return checked;
                }
                return null;
            }

            if (upperBound == lowerBound + 1){

                CostIndex checked1 = sortedCostList.get(upperBound);
                if (checked1.getCost() == target){
                    return checked1;
                }
                CostIndex checked2 = sortedCostList.get(lowerBound);
                if (checked2.getCost() == target){
                    return checked2;
                }

                return null;
            }
            if ((upperBound + lowerBound) % 2 == 0){
               middleIndex =  (upperBound + lowerBound)/2;
            }else {
                middleIndex = (upperBound + lowerBound - 1)/2;
            }
            CostIndex checked = sortedCostList.get(middleIndex);
            if (checked.getCost() == target){
                return checked;
            }
            if (checked.getCost() > target){
                upperBound = middleIndex;
                continue;
            }

            if (checked.getCost() < target){
                lowerBound = middleIndex;
                continue;
            }
        }

    }

    static class CostIndex{

        private int index;

        private int cost;

        public CostIndex(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}
