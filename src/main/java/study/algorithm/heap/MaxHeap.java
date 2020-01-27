package study.algorithm.heap;

/**
 * Created by EricWang on 2019/12/24 1:04 PM.
 */
public class MaxHeap {

    private int[]  container;

    private int nodesAmount;

    private static float loadFactor = 0.75f;

    public MaxHeap(int[] origin){
        buildMaxHeap(origin);
    }

    private int[] buildMaxHeap(int[] origin) {
        nodesAmount = origin.length;
        int[] container = new int[origin.length*2 + 1];
        for (int i = 0; i < origin.length; i ++){
            container[i+1] = origin[i];
        }
        this.container = container;
        for (int i = origin.length/2; i >= 1; i--){
            maxHeapify(i);
        }

        return container;
    }

    private void maxHeapify(int index){

        int leftChildIndex = index * 2;

        int rightChildIndex = index * 2 + 1;

        if (leftChildIndex > nodesAmount){
            return;
        }

        if (rightChildIndex > nodesAmount){
            swapIfNeed(index,leftChildIndex);
            return;
        }

        int largeChildIndex = getChildIndexWithLargerValue(leftChildIndex,rightChildIndex);
        swapIfNeed(index,largeChildIndex);
    }

    private int getChildIndexWithLargerValue(int leftChildIndex, int rightChildIndex) {
        if (container[leftChildIndex] > container[rightChildIndex]){
            return leftChildIndex;
        }
        return rightChildIndex;
    }

    private void swapIfNeed(int index, int childIndex) {
        if (container[index] < container[childIndex]){
            int tmp = container[index];
            container[index] = container[childIndex];
            container[childIndex] = tmp;
            maxHeapify(childIndex);
        }

    }

    public void print(){
        for (int i = 0; i < this.container.length; i++){
            System.out.println(this.container[i]);
        }
    }

    public Integer removeTop(){

        if (nodesAmount == 1){
            return container[1];
        }

        int max = container[1];

        container[1] = container[nodesAmount];
        container[nodesAmount] = 0;
        nodesAmount--;
        maxHeapify(1);

        return max;
    }

    public void add(Integer newEle){

        nodesAmount++;
        container[nodesAmount] = newEle;

        maxHeapifyFromBottom(nodesAmount);

    }

    private void maxHeapifyFromBottom(int index) {

        if (index == 1){
            return;
        }

        int parentIndex = index/2;

        if (container[parentIndex] >= container[index]){
            return;
        }

        int tmp = container[parentIndex];
        container[parentIndex] = container[index];
        container[index] = tmp;
        maxHeapifyFromBottom(parentIndex);
    }


}
