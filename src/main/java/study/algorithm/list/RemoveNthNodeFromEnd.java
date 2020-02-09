package study.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2020/2/9 10:19 AM.
 * leetecode link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer,ListNode> nodesWithIndex = new HashMap<>();

        ListNode current = head;
        int index = 1;

        while (current!=null){

            nodesWithIndex.put(index,current);
            current = current.next;
            if (current!= null){
                index++;

            }

        }

        if (n == index){
            head = head.next;
            return head;
        }

        if (index == 1){
            return null;
        }

        nodesWithIndex.get(index - n).next = nodesWithIndex.get(index+2-n);

        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveNthNodeFromEnd t = new RemoveNthNodeFromEnd();
        ListNode head = t.removeNthFromEnd(node1, 2);

        System.out.println(head);
    }

     // Definition for singly-linked list.
     static public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

}
