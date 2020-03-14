package study.algorithm.graph;

import java.util.*;

/**
 * Created by EricWang on 2020/3/14 2:27 PM.
 * leetcode link: https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {


    public static void main(String[] args) {
        int numCourse = 2;
        int[][] prerequisites = new int[][]{{0,1},{1,0}};
        CourseSchedule t = new CourseSchedule();
        boolean result = t.canFinish(numCourse, prerequisites);
        System.out.println(result);
    }

    //todo the complexity can be improved
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 1 || prerequisites == null || prerequisites.length == 0){
            return true;
        }


        Graph graph = new Graph(numCourses);

        initGraph(graph,prerequisites);

        //depth search graph to see if there is a violation

        //find first course that has dependencies
        int i = 0;
        while (i < numCourses){

            if (graph.adjecents[i] == null){
                i++;
                continue;
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            Set<Integer> dependencyChain = new HashSet<>();
            dependencyChain.add(i);

            boolean result = depthSearch(graph, stack, dependencyChain);

            if (!result){
                return false;
            }


            i++;
        }

        return true;
    }

    private boolean depthSearch(Graph graph, Stack<Integer> stack, Set<Integer> dependencyChain) {
        Integer currentCourse = stack.peek();
        if (graph.adjecents[currentCourse] == null){
            stack.pop();
            dependencyChain.remove(currentCourse);
            return true;
        }

        for (Integer dependency : graph.adjecents[currentCourse]){

            if (dependencyChain.contains(dependency)){
                return false;
            }

            stack.push(dependency);
            dependencyChain.add(dependency);
            boolean result = depthSearch(graph, stack, dependencyChain);

            if (!result){
                return false;
            }

        }

        dependencyChain.remove(currentCourse);
        stack.pop();

        return true;

    }

    private void initGraph(Graph graph, int[][] prerequisites) {

        for (int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int dependency = prerequisites[i][1];

            if (graph.adjecents[course] == null){
                List<Integer> dependencies = new ArrayList<>();
                dependencies.add(dependency);
                graph.adjecents[course] = dependencies;
                continue;
            }

            graph.adjecents[course].add(dependency);

        }
    }


    class Graph{

        int vertices;
        List<Integer>[] adjecents;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjecents = new List[vertices];
        }
    }
}
