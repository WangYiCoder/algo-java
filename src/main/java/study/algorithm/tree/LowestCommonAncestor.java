package study.algorithm.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor {

    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;


        public Node(int data) {
            this.data = data;
        }
    }

    private static int alreadyFound = 0;

    private static List<Node> targetNodeList = new ArrayList<>(2);
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        travesalNodes(root,v1,v2);

        if (alreadyFound != 2){
            return null;
        }

        Set<Node> parentNodes = new HashSet<>();

        Node node1 = targetNodeList.get(0);
        while (true){
            parentNodes.add(node1);
            if (node1.parent == null){
                break;
            }

            node1 = node1.parent;
        }

        Node node2 = targetNodeList.get(1);

        while(true){
            if (parentNodes.contains(node2)){
                return node2;
            }

            if (node2 == null){
                break;
            }

            node2 = node2.parent;
        }


        return null;
    }

    private static void travesalNodes(Node node, int v1, int v2) {

        if (node.data == v1 || node.data == v2){
            alreadyFound ++;
            targetNodeList.add(node);
            if (alreadyFound == 2){
                return;
            }
        }

        if (node.left != null){
            node.left.parent = node;
            travesalNodes(node.left,v1,v2);
        }

        if (node.right != null){
            node.right.parent = node;
            travesalNodes(node.right,v1,v2);
        }
    }
}
