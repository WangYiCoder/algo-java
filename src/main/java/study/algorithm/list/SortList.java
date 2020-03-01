package study.algorithm.list;

/**
 * Created by EricWang on 2020/2/23 12:33 PM.
 * leetcode link: https://leetcode.com/problems/sort-list/
 */
public class SortList {

    //using bottom-up merge sort
    //didn't run test yet, not confident about the solution
    public ListNode sortList(ListNode head) {

        if (head == null){
            return null;
        }

        //1, get length of list
        ListNode node = head;
        int length = 0;
        while (node != null){
            length ++;
            node = node.next;
        }

        //i is the merge sort unit
        for (int i = 1; i <= length/2+1; i *= 2){
            head = mergeSort(i,length,head);
        }



         return head;
    }

    private ListNode mergeSort(int step, int length, ListNode head) {

        int leftPointer = 1;
        int rightPointer = 1 + step;
        ListNode leftPrev = null;
        ListNode rightPrev = null;
        ListNode leftOne = head;
        ListNode rightOne = head;
        while (rightPointer <= length){
            if (rightOne == leftOne){
                //move right-pointer to the start position
                ListNode leftNode = leftOne;
                int i = 0;
                while ( i < step && leftNode != null){
                    rightPrev = leftNode;
                    rightOne = leftNode.next;
                    leftNode = leftNode.next;
                    i++;
                }
            }

            //start to compare and swap if need
            int rightMove = 0;
            int leftMove = 0;
            while ( rightMove < step && leftMove < step){
                if (leftOne.val <= rightOne.val){
                    leftPrev = leftOne;
                    leftOne = leftOne.next;
                    leftMove++;
                    continue;
                }
                rightMove++;
                //move right to the left
                rightPrev.next = rightOne.next;
                if (leftPrev != null){
                    leftPrev.next = rightOne;
                }else {
                    head = rightOne;
                }

                rightOne.next = leftOne;
                leftPrev = rightOne;
                rightOne = rightPrev.next;

            }

            leftPointer = rightPointer + 1;
            rightPointer = leftPointer + step;

            //move to the next segment
            int m = 0;
            leftPrev = rightPrev;
            while (m < step - rightMove && rightOne != null){
                leftPrev = rightPrev = rightOne;
                rightOne = rightOne.next;
                m++;
            }

            leftOne = rightOne;
        }



        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
