package main.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfConnectedComponents {
    
    public static int returnNumberOfConnectedComponents(int n, int[][] edges) {
        int count = 0;

        List<List<Integer>> edgesTransformed = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            edgesTransformed.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int node0 = edge[0];
            int node1 = edge[1];
            edgesTransformed.get(node0).add(node1); 
            edgesTransformed.get(node1).add(node0); 
        }

        boolean[] seen = new boolean[n];
        for (int i = 0; i< n; i++) {
            if (!seen[i]) {
                count++;
                dfs(seen, edgesTransformed, i);
            }
        }
        return count;
    }

    public static void dfs(boolean[] seen, List<List<Integer>> edgesTransformed, int i) {
        Stack<Integer> stack = new Stack<>();
        stack.add(i);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : edgesTransformed.get(node)) {
                if (seen[neighbor]) {
                    continue;
                } 
                seen[neighbor] = true;
                stack.add(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[][] edges1 = {{0,1}, {1,2}, {3,4}};
        int n2 = 5;
        int[][] edges2 = {{0,1}, {1,2}, {2,3}, {3,4}};

        System.out.println(returnNumberOfConnectedComponents(n1, edges1));
        System.out.println(returnNumberOfConnectedComponents(n2, edges2));
    }
}
