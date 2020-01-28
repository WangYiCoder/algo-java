package study.algorithm.tree;

/**
 * Created by EricWang on 2020/1/27 6:54 PM.
 * leetcode link: https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {



    public boolean isValidBST(TreeNode root) {

        if (root == null){
            return true;
        }


        NodeTravesalResult result = travesalNode(root);


        return result.isValid;

    }

    private NodeTravesalResult travesalNode(TreeNode node) {

        NodeTravesalResult result = new NodeTravesalResult();

        result.max = node.val;

        result.min  = node.val;

        result.isValid = true;

        if (node.left != null){

            NodeTravesalResult leftResult = travesalNode(node.left);

            if (!leftResult.isValid){
                result.isValid = false;
                return result;
            }

            if (leftResult.max >= node.val){
                result.isValid = false;
                return result;
            }

            result.max = Math.max(leftResult.max,result.max);

            result.min  = Math.min(leftResult.min,result.min);

        }

        if(node.right != null){

            NodeTravesalResult rightResult = travesalNode(node.right);
            if (!rightResult.isValid){

                result.isValid = false;

                return result;
            }

            if (rightResult.min <= node.val){
                result.isValid = false;
                return result;

            }

            result.max = Math.max(rightResult.max,result.max);

            result.min  = Math.min(rightResult.min,result.min);
        }


        return result;
    }

    public class NodeTravesalResult{

        int max;

        int min;

        boolean isValid;

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
