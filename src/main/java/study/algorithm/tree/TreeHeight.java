package study.algorithm.tree;

public class TreeHeight {

    static class Node {
        int data;
        Node left;
        Node right;
        int height = 0;

        public Node(int data) {
            this.data = data;
        }
    }
    static int maxHeight = 0;
    public static int height(Node root) {
        // Write your code here.
        recursiveTree(root);

        return maxHeight;
    }

    private static void recursiveTree(Node node) {

        if (node.height > maxHeight){
            maxHeight = node.height;
        }

        if (node.left != null){
            node.left.height = node.height+1;
            recursiveTree(node.left);
        }

        if (node.right != null){
            node.right.height = node.height+1;
            recursiveTree(node.right);
        }
    }
}
