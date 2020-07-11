package study.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepresentIntegerInBits {

    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8

        int valueA = 0;
        for (int i = 0; i < A.length; i ++){
            valueA =  valueA +A[i] * (int) Math.pow(-2,i);
        }

        int valueB = 0;
        for (int i = 0; i < B.length; i ++){
            valueB = valueB + B[i] * (int)Math.pow(-2,i);
        }

        int toSolve = valueA + valueB;

        //store all solutions
        Map<Integer,List<Result>> allSolution = new HashMap<>();
        List<Result> solutionsOfOneSize = new ArrayList<>();

        //init size 1
        Result result0 = new Result();
        result0.setSize(1);
        int[] arr0 = new int[1];
        arr0[0] = 0;
        result0.setArr(arr0);
        result0.setValue(0);
        solutionsOfOneSize.add(result0);

        Result result1 = new Result();
        result1.setSize(1);
        int[] arr1 = new int[1];
        arr1[0] = 1;
        result1.setArr(arr1);
        result1.setValue(1);
        solutionsOfOneSize.add(result1);

        allSolution.put(1,solutionsOfOneSize);

        if (toSolve == 0){
            return arr0;
        }

        if (toSolve == 1){
            return arr1;
        }


        int size = 1;
        while (true){
           size ++;

            List<Result> solutionsOfLastLayer = allSolution.get(size - 1);
            int currentBaseValue = (int)Math.pow(-2,size - 1);

            List<Result> solutionsOfCurrentLayer = new ArrayList<>(solutionsOfLastLayer.size() * 2);
            allSolution.put(size,solutionsOfCurrentLayer);
            solutionsOfCurrentLayer.addAll(solutionsOfLastLayer);
            for (Result previousResult : solutionsOfLastLayer){

                int currentValue = previousResult.getValue() + currentBaseValue;


                Result currentResult = new Result();

                int[] currentArr = new int[size];
                for (int i = 0; i < size - 1; i++){
                    currentArr[i] = previousResult.getArr()[i];
                }
                currentArr[size - 1] = currentValue;
                if (currentValue == toSolve){
                    return currentArr;
                }

                currentResult.setSize(size);
                currentResult.setValue(currentValue);
                currentResult.setArr(currentArr);

                solutionsOfCurrentLayer.add(currentResult);


            }
        }



    }

    public class Result {
        private int value;

        private int size;

        private int[] arr;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int[] getArr() {
            return arr;
        }

        public void setArr(int[] arr) {
            this.arr = arr;
        }
    }
}
