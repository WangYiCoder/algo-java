package study.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RoadsAndLibs {

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        if (c_lib <= c_road){
            return (long)n * c_lib;
        }

        //c_road is cheaper than c_lib, find minimum libs that make sure all cities can reach to a lib at least
        Graph graph = new Graph(n);
        for (int i = 0; i < cities.length; i++){
            int c1 = cities[i][0] - 1;
            int c2 = cities[i][1] - 1;
            if (graph.adj[c1] == null){
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(c2);
                graph.adj[c1] = linkedList;
            }else {
                graph.adj[c1].add(c2);
            }

            if (graph.adj[c2] == null){
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(c1);
                graph.adj[c2] = linkedList;
            }else {
                graph.adj[c2].add(c1);
            }
        }

        //travesal graph
        boolean[] visited = new boolean[n];

        long libs = 0;
        for (int i = 0; i < n; i ++){
            if (graph.adj[i] == null){
                libs++;
                continue;
            }
            if (visited[i]){
                continue;
            }

            libs++;
            visited[i] = true;
            Queue<Integer> bfs = new LinkedList<>();
            bfs.add(i);
            while (!bfs.isEmpty()){
                Integer head = bfs.poll();
                LinkedList<Integer> nextLayer = graph.adj[head];
                for (Integer v : nextLayer){
                    if (visited[v]){
                        continue;
                    }
                    visited[v]=true;
                    bfs.add(v);
                }
            }

        }


        return  libs * c_lib + (n - libs) * c_road;

    }

    static class Graph{
        int v;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
        }
    }
}
