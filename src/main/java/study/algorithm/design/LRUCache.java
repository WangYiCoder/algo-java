package study.algorithm.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricWang on 2020/1/28 9:21 PM.
 */
public class LRUCache {

    private int capacity;

    private int size = 0;

    private Node head;

    private Node tail;

    private Map<Integer,Node> keyNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap<>();
    }

    public int get(int key) {

        Node node = keyNodeMap.get(key);
        if (node == null){
            return -1;
        }

        moveNodeToTail(node);

        return node.getValue();
    }

    private void moveNodeToTail(Node node) {

        if (node == tail){
            return;
        }


        if (node == head){
            if (node.next != null){
                this.head = node.next;
            }

            node.next.prev = null;
            node.prev = tail;
            node.next = null;
            tail.next = node;
            tail = node;
            return;

        }


        if (node.prev != null){
            node.prev.next = node.next;
        }

        if (node.next != null){
            node.next.prev = node.prev;
        }
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }

    public void put(int key, int value) {
        Node existedNode = keyNodeMap.get(key);
        if (existedNode == null){
            deleteHeadIfNecessary();
            appendNodeToTail(key,value);
            return;
        }

        existedNode.setValue(value);
        moveNodeToTail(existedNode);

    }

    private void deleteHeadIfNecessary() {
        if (size >= capacity){
            keyNodeMap.remove(this.head.getKey());
            this.head = this.head.next;
            if (this.head != null){
                this.head.prev = null;
            }
            size--;
        }
    }

    private void appendNodeToTail(int key, int value) {

        Node node = new Node(key,value);

        if (tail != null){
            node.prev = tail;
            tail.next = node;
        }
        this.tail = node;

        if (this.head == null){
            this.head = node;
        }

        keyNodeMap.put(key,node);

        size++;

    }

    class Node{

        private int value;

        private int key;

        private Node prev;

        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(1);
        c.put(2,1);
        System.out.println(c.get(2));
    }


}
