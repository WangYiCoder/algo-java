package study.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by EricWang on 2020/3/15 11:43 AM.
 * leetcode link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LCAOfBTree {

    public static void main(String[] args) {
       TreeNode root = new TreeNode(3);
       TreeNode n11 = new TreeNode(    5);
       TreeNode n12 = new TreeNode(1);
       TreeNode n21 = new TreeNode(6);
       TreeNode n22 = new TreeNode(2);
       TreeNode n23 = new TreeNode(0);
       TreeNode n24 = new TreeNode(8);
       TreeNode n33 = new TreeNode(7);
       TreeNode n34 = new TreeNode(4);


       root.left = n11;
       root.right = n12;
       n11.left = n21;
       n11.right = n22;
       n12.left = n23;
       n12.right = n24;
       n22.left = n33;
       n22.right = n34;

        LCAOfBTree t = new LCAOfBTree();
        TreeNode treeNode = t.lowestCommonAncestor(root, n11, n34);
        System.out.println(treeNode.val);
    }

    //a more simplified solution from discussion area which fully utilized recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        if (leftResult!= null && rightResult != null){
            return root;
        }

        if (leftResult != null){
            return leftResult;
        }

        if (rightResult != null){
            return rightResult;
        }

        return null;

    }


    //todo time and space complexity can be improved
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //try to use preOrder travesal
        if (root == null){
            return null;
        }

        Map<Integer, Map<Integer,TreeNode>> locateNodes = new HashMap<>();

        List<NodeWithPosition> targetNodes = new ArrayList<>(2);

        preOrderTravesal(root,p,q,1,1,locateNodes,targetNodes);

        NodeWithPosition target1 = targetNodes.get(0);
        NodeWithPosition target2 = targetNodes.get(1);

        if (target1.depth > target2.depth){
            return getAncestor(target1,target2,locateNodes);
        }else {
            return getAncestor(target2,target1,locateNodes);
        }

    }

    private TreeNode getAncestor(NodeWithPosition lower, NodeWithPosition higher, Map<Integer, Map<Integer, TreeNode>> locateNodes) {

        int lowerDepth = lower.depth;
        int higherDepth = higher.depth;
        //first catch up with higher one
        int gap = lowerDepth - higherDepth;
        int lowerHorizontal = lower.horizontal;
        while (gap > 0){
            lowerHorizontal = (lowerHorizontal + 1)/2;
            gap--;
        }

        int higherHoriztonal = higher.horizontal;
        int ancestorDepth = higherDepth;

        while (higherHoriztonal != lowerHorizontal){
            ancestorDepth--;
            lowerHorizontal = (lowerHorizontal + 1)/2;
            higherHoriztonal = (higherHoriztonal + 1)/2;
        }

        return locateNodes.get(ancestorDepth).get(lowerHorizontal);
    }

    private void preOrderTravesal(TreeNode node, TreeNode p, TreeNode q, int depth, int horizontal, Map<Integer, Map<Integer, TreeNode>> locateNodes, List<NodeWithPosition> targetNodes) {

        if (node == null || targetNodes.size() == 2){
            return;
        }

        //check node itself
        if (node.val == p.val || node.val == q.val){
            NodeWithPosition targetNode = new NodeWithPosition(node, depth, horizontal);
            targetNodes.add(targetNode);
            if (targetNodes.size() == 2){
                return;
            }
        }

        if (locateNodes.get(depth) == null){
            Map<Integer,TreeNode> currentLevelNodes  =  new HashMap<>();
            currentLevelNodes.put(horizontal,node);
            locateNodes.put(depth,currentLevelNodes);
        }else {
            locateNodes.get(depth).put(horizontal,node);
        }


        //travesal left child
        preOrderTravesal(node.left, p, q, depth+1, 2*horizontal-1, locateNodes, targetNodes);

        //travesal right child
        preOrderTravesal((node.right), p, q, depth+1, 2*horizontal, locateNodes, targetNodes);


    }

    public class NodeWithPosition{
        TreeNode node;
        int depth;
        int horizontal;

        public NodeWithPosition(TreeNode node, int depth, int horizontal) {
            this.node = node;
            this.depth = depth;
            this.horizontal = horizontal;
        }
    }*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
