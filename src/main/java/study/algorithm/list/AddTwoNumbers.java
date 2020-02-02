package study.algorithm.list;

/**
 * Created by EricWang on 2020/2/2 9:57 AM.
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int length1 = getLengthOfList(l1);
        int length2 = getLengthOfList(l2);

        ListNode longer = null;
        ListNode shorter = null;

        if (length1 > length2){
            longer = l1;
            shorter = l2;
        }else {
            longer = l2;
            shorter = l1;
        }

        ListNode nodeInLongerList = longer;
        ListNode nodeInShorterList = shorter;
        ListNode headInSum = new ListNode(0);
        ListNode nodeInSum = headInSum;

        boolean nextDigitPlusOne = false;
        while (nodeInLongerList != null){
            int currentDigitSum = 0;
           if (nextDigitPlusOne){
             currentDigitSum += 1;
             nextDigitPlusOne = false;
           }

           if (nodeInShorterList != null){
               currentDigitSum += nodeInLongerList.val + nodeInShorterList.val;
           }else {
               currentDigitSum += nodeInLongerList.val;
           }

           if (currentDigitSum >= 10){
               currentDigitSum = currentDigitSum % 10;
               nextDigitPlusOne = true;
           }

           nodeInSum.val = currentDigitSum;
           nodeInLongerList = nodeInLongerList.next;

           if(nodeInShorterList != null){
               nodeInShorterList = nodeInShorterList.next;
           }


           if (nodeInLongerList == null){
               break;
           }

            ListNode nextNodeInSum = new ListNode(0);
            nodeInSum.next = nextNodeInSum;
            nodeInSum = nextNodeInSum;
        }

        if (nextDigitPlusOne){
            ListNode tail = new ListNode(1);
            nodeInSum.next = tail;
        }


        return headInSum;

    }

    private int getLengthOfList(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node!= null){
            length++;
            node = node.next;
        }

        return length;
    }

    /*
    can't handle when number exceed maxim long value
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long n1 = getNumberFromList(l1);
        long n2 = getNumberFromList(l2);

        long sum = n1 + n2;

        char[] chars = String.valueOf(sum).toCharArray();

        ListNode head = new ListNode(Integer.valueOf(String.valueOf(chars[chars.length-1])));

        ListNode currentBuildNode = head;
        for (int i = chars.length - 2; i >= 0; i--){
            ListNode nextNode = new ListNode(Integer.valueOf(String.valueOf(chars[i])));
            currentBuildNode.next = nextNode;
            currentBuildNode = nextNode;
        }


        return head;
    }

    private long getNumberFromList(ListNode node) {

        long n = 0L;

        ListNode currentNode = node;
        int position = 0;
        while (currentNode != null){
            n += Math.pow(10, position) * currentNode.val;
            position++;
            currentNode = currentNode.next;
        }

        return n;
    }*/

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
