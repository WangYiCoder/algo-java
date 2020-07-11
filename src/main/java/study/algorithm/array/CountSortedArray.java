package study.algorithm.array;

public class CountSortedArray {

    public static void main(String[] args) {
        int Y = 1;
        int[] A = new int[]{1,4,4,4,8,8,8,12};
        CountSortedArray t = new CountSortedArray();
        System.out.println(t.solution(A,Y));
    }

    public int solution(int[] A, int Y) {
        // write your code in Java

       //input check
        if (A == null || A.length < 1){
            return 0;
        }

        if (Y < A[0] || Y > A[A.length - 1]){
            return 0;
        }

        //use binary search to find a "Y" in the array
        int leftBound = 0;
        int rightBound = A.length - 1;
        int matchedOneIndex = -1;


        while (leftBound < rightBound){

            if (rightBound - leftBound == 1){
                if (A[leftBound] == Y){
                    matchedOneIndex = leftBound;
                    break;
                }

                if (A[rightBound] == Y){
                    matchedOneIndex = rightBound;
                    break;
                }

                break;
            }

            int middleIndex = (leftBound + rightBound)/2;
            if(A[middleIndex] == Y){
                matchedOneIndex = middleIndex;
                break;
            }

            if (A[middleIndex] > Y){
                rightBound = middleIndex;
                continue;
            }

            leftBound = middleIndex;


        }

        if (matchedOneIndex == -1){
            return 0;
        }

        //expand from the the matched index, until find the left and right bound
        int count = 1;
        for (int i = matchedOneIndex+1; i < A.length; i++){
            if (A[i] == Y){
                count ++;
            }
        }

        for (int i = matchedOneIndex - 1; i > -1; i --){
            if (A[i] == Y){
                count++;
            }
        }

        return count;

    }
}
