package study.algorithm.tree;

import java.util.HashSet;
import java.util.Set;

public class LongestDistinctPath {

    public int solution(Tree T) {
        // write your code in Java SE 8

        return travesal(T,0,new HashSet<>());
    }

    int travesal(Tree node, int max, Set<Integer> existed){

        if (node == null || existed.contains(node.x)){
            return max;
        }

        existed.add(node.x);
        max++;
        int leftMax = travesal(node.l, max, existed);

        int rightMax = travesal(node.r, max, existed);

        existed.remove(node.x);

        return Math.max(rightMax,leftMax);
    }


    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
}
