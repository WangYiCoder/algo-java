package study.algorithm.search;

import java.util.HashMap;
import java.util.Map;

public class SwapNodes {

    public static void main(String[] args) {
        int[][] indexes = new int[][]{{2,3},{-1,-1},{-1,-1}};
        int[] queries = new int[]{1,1};

        int[][] result = swapNodes(indexes, queries);

        for (int i = 0; i < result.length;i ++){
            for (int j = 0; j < result[i].length;j++){
                System.out.print(result[i][j]+",");
            }
            System.out.println("");
        }
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        int totalElements = 1;

        Node root = new Node(1,1);
        Map<Integer, Map<Integer,Node>> nodesOfEachLevel = new HashMap<>();
        Map<Integer,Node> nodesOfRootLevel = new HashMap<>(1);
        nodesOfRootLevel.put(0,root);
        nodesOfEachLevel.put(1,nodesOfRootLevel);

        Map<Integer,Integer> sonToFather = new HashMap<>();

        sonToFather.put(0,0);

        Tree tree = new Tree(root, nodesOfEachLevel);

        int currentHight = 1;
        int currentLevelEndIndex = 0;
        int currentLevelStartIndex = 0;
        int currentLevelNodesAmount = 0;

        while (true){

            currentHight++;

            Map<Integer,Node> nodesOfCurrentLevel = new HashMap<>();
            nodesOfEachLevel.put(currentHight,nodesOfCurrentLevel);

            for (int i = currentLevelStartIndex; i <= currentLevelEndIndex; i++){
                Integer fatherIndexInItsLevel = sonToFather.get(i);

                Node fatherNode = nodesOfEachLevel.get(currentHight - 1).get(fatherIndexInItsLevel);

                if (indexes[i][0] != -1){
                    currentLevelNodesAmount++;
                    Node leftChild = new Node(indexes[i][0], currentHight);
                    nodesOfCurrentLevel.put(currentLevelNodesAmount-1,leftChild);
                    sonToFather.put(currentLevelEndIndex+currentLevelNodesAmount,currentLevelNodesAmount-1);
                    fatherNode.setLeftChild(leftChild);
                }

                if (indexes[i][1] != -1){
                    currentLevelNodesAmount++;
                    Node rightChild = new Node(indexes[i][1], currentHight);
                    nodesOfCurrentLevel.put(currentLevelNodesAmount-1,rightChild);
                    sonToFather.put(currentLevelEndIndex+currentLevelNodesAmount,currentLevelNodesAmount-1);
                    fatherNode.setRightChild(rightChild);
                }
            }

            if (currentLevelNodesAmount == 0){
                break;
            }

            totalElements = totalElements + currentLevelNodesAmount;

            //init for next level
            currentLevelStartIndex = currentLevelEndIndex + 1;
            currentLevelEndIndex = currentLevelStartIndex + currentLevelNodesAmount - 1;
            currentLevelNodesAmount = 0;

        }

        int[][] result = new int[queries.length][totalElements];
        for (int j = 0; j < queries.length;j++){
            int k = queries[j];

            for (int d = k; d< currentHight; d = d + k){
                swapNodesAtDepth(tree,d);
            }

            int[] travesedResult = travesalTree(tree,totalElements);
            result[j] = travesedResult;
        }



        return result;

    }

    private static int[] travesalTree(Tree tree, int totalElements) {
        int[] result = new int[totalElements];

        Integer index = 0;

        travesalTreeNodes(tree.getRoot(),result, index);


        return result;
    }

    private static int travesalTreeNodes(Node node, int[] result, Integer index) {
        if (node == null){
            return index;
        }

        index = travesalTreeNodes(node.getLeftChild(),result,index);

        result[index] = node.getValue();
        index = index + 1;

        index = travesalTreeNodes(node.getRightChild(),result,index);

        return index;
    }


    private static void swapNodesAtDepth(Tree tree, int d) {

        Map<Integer, Node> nodesAtD = tree.getNodesOfEachLevel().get(d);
        for (Node node : nodesAtD.values()){
            Node leftChild = node.getLeftChild();
            Node tmp = leftChild;
            node.setLeftChild(node.getRightChild());
            node.setRightChild(tmp);
        }

    }

    static class Tree{

        private Node root;

        private Map<Integer, Map<Integer,Node>> nodesOfEachLevel;

        public Tree(Node root, Map<Integer, Map<Integer,Node>> nodesOfEachLevel) {
            this.root = root;
            this.nodesOfEachLevel = nodesOfEachLevel;
        }

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }

        public Map<Integer, Map<Integer, Node>> getNodesOfEachLevel() {
            return nodesOfEachLevel;
        }

        public void setNodesOfEachLevel(Map<Integer, Map<Integer, Node>> nodesOfEachLevel) {
            this.nodesOfEachLevel = nodesOfEachLevel;
        }
    }

    static class Node{
        private int value;

        private int height;

        private Node leftChild;

        private Node rightChild;

        private Node parent;
        public Node(int value, int height) {
            this.value = value;
            this.height = height;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}
