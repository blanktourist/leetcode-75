package main.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphValidTree {
    
    public static boolean isValidTree(int numNodes, int[][] edges) {
        if (edges.length != numNodes -1) return false;
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : adjacencyList.get(node)) {
                // Avoid trivial cycle in an undirected graph
                if (parent.get(node) == neighbor) {
                    continue;
                }

                if (parent.containsKey(neighbor)) {
                    return false;
                }

                stack.push(neighbor);
                parent.put(neighbor, node);
            }
        }

        return parent.size() == numNodes;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(isValidTree(n1, edges));
    }
}
