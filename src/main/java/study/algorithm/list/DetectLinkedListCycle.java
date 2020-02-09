package study.algorithm.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EricWang on 2020/2/9 5:00 PM.
 */
public class DetectLinkedListCycle {

    public ListNode detectCycle(ListNode head) {


        Set<ListNode> nodeSet = new HashSet<>();

        if (head == null){
            return null;
        }

        ListNode current = head;

        while (true){
            nodeSet.add(current);
            if (current.next == null){
                return null;
            }

            if (nodeSet.contains(current.next)){
                return current.next;
            }

            current = current.next;
        }

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
