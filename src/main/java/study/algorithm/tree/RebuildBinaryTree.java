package study.algorithm.tree;

/**
 * Created by EricWang on 2020/1/31 12:41 PM.
 * given the results of preorder traversal and inorder traversal, rebuild the tree
 */
public class RebuildBinaryTree {



    public Node rebuildTree(int[]preorderResult,int[] inorderResult ){

        Node root = new Node();
        if (preorderResult.length == 0){
            return null;
        }

        int rootValue = preorderResult[0];
        root.setValue(rootValue);

        int leftSubtreeNodeAmount = getleftSubTreeNodeAmount(inorderResult,rootValue);


        if (leftSubtreeNodeAmount > 0){
            int[] preOrderForLeftSubTree = new int[leftSubtreeNodeAmount];
            int[] inOrderForLeftSubTree = new int[leftSubtreeNodeAmount];

            for (int i = 0; i < leftSubtreeNodeAmount; i ++){
                preOrderForLeftSubTree[i] = preorderResult[i+1];
                inOrderForLeftSubTree[i] = inorderResult[i];
            }

            Node leftChild = rebuildTree(preOrderForLeftSubTree, inOrderForLeftSubTree);

            root.setLeftChild(leftChild);


        }else {

            root.setLeftChild(null);
        }

        int rightSubtreeNodeAmount = inorderResult.length - leftSubtreeNodeAmount - 1;

        if (rightSubtreeNodeAmount > 0){
            int[] preOrderFoRightSubTree = new int[rightSubtreeNodeAmount];
            int[] inOrderForRightSubTree = new int[rightSubtreeNodeAmount];
            for (int i = 0; i < rightSubtreeNodeAmount; i++){
                preOrderFoRightSubTree[i] = preorderResult[i+1+leftSubtreeNodeAmount];
                inOrderForRightSubTree[i] = inorderResult[i+1+leftSubtreeNodeAmount];
            }

            Node rightChild = rebuildTree(preOrderFoRightSubTree, inOrderForRightSubTree);

            root.setRightChild(rightChild);

        }else {
            root.setRightChild(null);
        }





        return root;
    }

    private int getleftSubTreeNodeAmount(int[] inorderResult, int rootValue) {

        for (int i = 0; i < inorderResult.length; i++){
            if (inorderResult[i] == rootValue){
                return i;
            }
        }

        throw new RuntimeException("wrong.input");
    }


    class Node{
        private int value;

        private Node leftChild;

        private Node rightChild;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
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
    }

    public static void main(String[] args) {
        int[] preorderResult = new int[]{1,2,4,7,3,5,6,8};
        int[] inorderResult = new int[]{4,7,2,1,5,3,8,6};

        RebuildBinaryTree builder = new RebuildBinaryTree();
        Node root = builder.rebuildTree(preorderResult, inorderResult);
        System.out.println(root);
    }
}
