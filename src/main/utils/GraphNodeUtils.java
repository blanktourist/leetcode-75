package utils;

import java.util.HashSet;
import java.util.PriorityQueue;

import models.GraphNode;

public class GraphNodeUtils {
    
    public static GraphNode buildGenericGraph() {
        GraphNode n0 = new GraphNode(1);
        GraphNode n1 = new GraphNode(2);
        GraphNode n2 = new GraphNode(3);
        GraphNode n3 = new GraphNode(4);

        n0.neighbors.add(n1);
        n0.neighbors.add(n3);

        n1.neighbors.add(n0);
        n1.neighbors.add(n2);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n0);

        return n0;
    }

    public static void printGraph(GraphNode node) {
        if (node == null) return;

        HashSet<GraphNode> seen = new HashSet<>();
        PriorityQueue<GraphNode> queue = new PriorityQueue<>((a,b) -> a.value - b.value);

        seen.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            System.out.println("Node: " + cur + " , Neighbors: " + cur.neighbors);
            for (GraphNode neighbor : cur.neighbors) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
