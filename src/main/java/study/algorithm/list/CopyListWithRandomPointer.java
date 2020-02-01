package study.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2020/2/1 10:53 AM.
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Map<Node, Node> orgAndCopy = new HashMap<>();

        Node org = head;
        Node copied = new Node(head.val);
        orgAndCopy.put(head,copied);

        while (true){
            Node copy;
            if (orgAndCopy.get(org) == null){
                copy = new Node(org.val);
                orgAndCopy.put(org,copy);
            }else {
                copy = orgAndCopy.get(org);
            }

            if (org.random != null){
                Node copiedRandom;
                if (orgAndCopy.get(org.random) == null){
                    copiedRandom = new Node(org.random.val);
                    orgAndCopy.put(org.random,copiedRandom);
                }else {
                    copiedRandom = orgAndCopy.get(org.random);
                }

                copy.random = copiedRandom;
            }


            if (org.next == null){
                break;
            }

            Node copiedNext;
            if (orgAndCopy.get(org.next) == null){
                copiedNext = new Node(org.next.val);
                orgAndCopy.put(org.next,copiedNext);
            }else {
                copiedNext = orgAndCopy.get(org.next);
            }

            copy.next = copiedNext;

            org = org.next;


        }


        return copied;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
