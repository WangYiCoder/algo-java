package study.algorithm.heap;

/**
 * Created by EricWang on 2019/12/31 3:14 PM.
 */
public class TestMyMaxHeap {

    public static void main(String[] args) {
        int[] origin = new int[]{2,3,19,1,7,8,9,11,12,15,1617,18,19,20,21,22,24};
        MaxHeap maxHeap = new MaxHeap(origin);
        maxHeap.print();

        System.out.println(maxHeap.removeTop());
        maxHeap.print();

        maxHeap.add(16);
        System.out.println("===========================");
        maxHeap.print();
    }
}
