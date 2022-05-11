package main.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import main.models.GraphNode;

public class CourseSchedule {
    
    public static List<GraphNode> returnTopologicalSorting(int numCourses, int[][] prereqs) {
        
        // Initialize the nodes representing the courses
        GraphNode[] nodes = new GraphNode[numCourses];
        for (int i = 0; i< numCourses; i++) {
            GraphNode node = new GraphNode(i);
            nodes[i] = node;
        }

        // Process the edges
        for (int[] prereq : prereqs) {
            int to = prereq[0];
            int from = prereq[1];

            nodes[to].indegree++;
            nodes[from].neighbors.add(nodes[to]);
        }

    // Do topological sort
        // Init variables
        ArrayList<GraphNode> sorting = new ArrayList<>();
        Stack<GraphNode> nodesWithIndegree0 = new Stack<>();
        for (int i = 0; i< numCourses; i++) {
            GraphNode node = nodes[i];
            if (node.indegree == 0) {
                nodesWithIndegree0.add(node);
            }
        }

        // Remove nodes with 0 InDegree
        while (!nodesWithIndegree0.isEmpty()) {
            GraphNode node = nodesWithIndegree0.pop();
            sorting.add(node);
            for (GraphNode neighbor : node.neighbors) {
                neighbor.indegree--;
                if (neighbor.indegree == 0) {
                    nodesWithIndegree0.add(neighbor);
                }
            }
            node.neighbors = new ArrayList<>();
        }

        // Check results of the alg
        for (int i = 0; i< numCourses; i++) {
            GraphNode node = nodes[i];
            if (node.neighbors == null || node.neighbors.size() != 0) {
                return null;
            }
        }

        return sorting;
    }

    public static void main(String[] args) {
        int numCourese1 = 2;
        int[][] prereqs1 = {{1,0}};
        int numCourese2 = 2;
        int[][] prereqs2 = {{1,0}, {0,1}};
        int numCourese3 = 6;
        int[][] prereqs3 = {{0,5}, {0,4}, {2,5}, {1,4}, {3,2}, {3,1}};

        System.out.println(returnTopologicalSorting(numCourese1, prereqs1));
        System.out.println(returnTopologicalSorting(numCourese2, prereqs2));
        System.out.println(returnTopologicalSorting(numCourese3, prereqs3));
    }
}
