package study.algorithm.array;

public class LinkedListSize {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0){
            return 0;
        }
        int length = 1;
        int index = 0;
        while (true){
            int nextIndex = A[index];
            if (nextIndex == -1){
                return length;
            }
            index = nextIndex;
            length++;
        }
    }
}
