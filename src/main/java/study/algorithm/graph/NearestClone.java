package study.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestClone {


    public static void main(String[] args) {
        int graphNodes = 5;
        int[] graphFrom= new int[]{1,1,2,3};
        int[] graphTo= new int[]{2,3,4,5};
        long[] ids = new long[]{1,2,3,3,2};
        int val = 2;
        int shortest = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        System.out.println(shortest);
    }

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        int length = -1;

        Graph graph = new Graph(new LinkedList[graphNodes]);

        for (int i = 0; i < graphFrom.length; i ++ ){
            LinkedList<Integer> linkedList = graph.adjLinkedLists[graphFrom[i]-1];

            if (linkedList == null){
                linkedList = new LinkedList<>();
                linkedList.add(graphTo[i]-1);
                graph.adjLinkedLists[graphFrom[i]-1] = linkedList;
            }else {
                linkedList.add(graphTo[i] - 1);
            }

            LinkedList<Integer> backwards = graph.adjLinkedLists[graphTo[i] - 1];
            if (backwards == null){
                backwards = new LinkedList<>();
                backwards.add(graphFrom[i] - 1);
                graph.adjLinkedLists[graphTo[i] - 1] = backwards;
            }else {
                backwards.add(graphFrom[i] - 1);
            }
        }

        List<Integer> nodesNeedTravesal = new ArrayList<>();
        for (int i = 0; i < ids.length; i++){
            if ((long) val == ids[i]){
                nodesNeedTravesal.add(i);
            }
        }

        if (nodesNeedTravesal.isEmpty() || nodesNeedTravesal.size() == 1){
            return -1;
        }

        //travesal each node of the required color
        for (Integer node : nodesNeedTravesal){

            boolean[] visisted = new boolean[graphNodes];
            visisted[node] = true;
            Queue<Integer>  queue = new LinkedList<>();
            queue.add(node);
            int[] prev = new int[graphNodes];
            for (int i = 0; i < prev.length; i++){
                prev[i] = -1;
            }
            boolean foundMatch = false;
            int matchedIndex = -1;
            while (!queue.isEmpty()){
                Integer ele = queue.poll();
                LinkedList<Integer> connectedNodes = graph.adjLinkedLists[ele];
                for (Integer connectedNode : connectedNodes){
                    if (!visisted[connectedNode]){
                        prev[connectedNode] = ele;

                        if (ids[connectedNode] == (long)val){
                            foundMatch = true;
                            matchedIndex = connectedNode;
                            break;
                        }
                        visisted[connectedNode] = true;
                        queue.add(connectedNode);


                    }
                }
            }

            if (foundMatch == false){
                continue;
            }

            int currentLength = 0;
            while (true){
                if (prev[matchedIndex] == node ){
                    currentLength++;
                    break;
                }

                matchedIndex = prev[matchedIndex];
                currentLength++;
            }

            if (length == -1){
                length = currentLength;
                continue;
            }
            if (currentLength < length ){
                length = currentLength;
            }

        }



        return length;
    }

    static class Graph{
        LinkedList<Integer>[] adjLinkedLists;

        public Graph(LinkedList<Integer>[] adjLinkedLists) {
            this.adjLinkedLists = adjLinkedLists;
        }
    }

}
