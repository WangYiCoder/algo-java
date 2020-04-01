package study.algorithm.tree;

/**
 * Created by EricWang on 2020/3/31 5:07 PM.
 * leetcode link:https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class RebuildBinaryTreeII {

    public static void main(String[] args) {
        RebuildBinaryTreeII t = new RebuildBinaryTreeII();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = t.buildTree(preorder, inorder);

        System.out.println(root);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0){
            return null;
        }

        return buildTreeWithSpan(preorder,inorder,0,preorder.length - 1,0,preorder.length - 1);
    }

    private TreeNode buildTreeWithSpan(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderStart == preorderEnd){
            return new TreeNode(preorder[preorderStart]);
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int rootAtInorder = -1;
        for (int i = inorderStart; i <= inorderEnd; i++){
            if (inorder[i] == preorder[preorderStart]){
                rootAtInorder = i;
                break;
            }
        }

        if (rootAtInorder > inorderStart){
            int leftSubNodesAmount = rootAtInorder - inorderStart;
            TreeNode leftChild = buildTreeWithSpan(preorder,inorder,preorderStart+1,preorderStart+leftSubNodesAmount, inorderStart,rootAtInorder - 1);
            root.left = leftChild;
        }

        if (rootAtInorder < inorderEnd){
            int rightSubNodesAmount = inorderEnd - rootAtInorder;
            TreeNode rightChild = buildTreeWithSpan(preorder, inorder, preorderEnd - rightSubNodesAmount + 1 , preorderEnd ,rootAtInorder + 1, inorderEnd);
            root.right = rightChild;
        }


        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
