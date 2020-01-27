package study.algorithm.array;


import java.util.*;

/**
 * Created by EricWang on 2020/1/27 5:41 PM.
 * leetcode link: https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();


        Map<Integer,Integer> numberWithCount = new HashMap<>(nums.length);
        for (int num : nums){
            Integer count = numberWithCount.get(num);

            if (count == null){
                numberWithCount.put(num,1);
                continue;
            }

            numberWithCount.put(num,count + 1);
        }

        Set<SingleResult> resultsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){

                int target = 0 - (nums[i] + nums[j]);

                Integer targetCount = numberWithCount.get(target);

                if (targetCount == null){
                    continue;
                }

                if (target == nums[i] && target == nums[j]){
                    if (targetCount < 3){
                        continue;
                    }
                }else if (target == nums[i] || target == nums[j]){
                    if (targetCount < 2){
                        continue;
                    }
                }


                SingleResult singleResult = buildSingleResult(nums[i],nums[j],target);

                if (resultsSet.contains(singleResult)){
                    continue;
                }

                resultsSet.add(singleResult);

                List<Integer> finalSingleResult = new ArrayList<>(3);
                finalSingleResult.add(singleResult.getFirst());
                finalSingleResult.add(singleResult.getSecond());
                finalSingleResult.add(singleResult.getThird());

                result.add(finalSingleResult);
            }
        }


        return result;
    }

    private SingleResult buildSingleResult(int n1, int n2, int n3) {

        int[] inputs = {n1, n2, n3};
        Arrays.sort(inputs);

        return new SingleResult(inputs[0],inputs[1],inputs[2]);
    }

    class SingleResult{

        private int first;

        private int second;

        private int third;

        public SingleResult(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SingleResult that = (SingleResult) o;
            return first == that.first &&
                    second == that.second &&
                    third == that.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public int getThird() {
            return third;
        }

        public void setThird(int third) {
            this.third = third;
        }
    }
}
