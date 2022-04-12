package main.problems.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import main.models.GraphNode;
import main.utils.GraphNodeUtils;

public class CloneGraph {
    public static GraphNode cloneGraph(GraphNode node) {
        HashSet<GraphNode> seen = new HashSet<>();
        HashMap<GraphNode, GraphNode> mapFromOriginalToCopy = new HashMap<>();
        dfsAdd(seen, mapFromOriginalToCopy, node);
        
        for (GraphNode n : seen) {
            List<GraphNode> neighbors = n.neighbors;
            List<GraphNode> neighborsOfCopy = mapFromOriginalToCopy.get(n).neighbors;
            for (GraphNode neighbor : neighbors) {
                neighborsOfCopy.add(mapFromOriginalToCopy.get(neighbor));
            }
        }

        return mapFromOriginalToCopy.get(node);
    }

    public static void dfsAdd(HashSet<GraphNode> seen, HashMap<GraphNode, GraphNode> map, GraphNode node) {
        if (node == null) return;
        if (seen.contains(node)) return;

        seen.add(node);

        GraphNode copy = new GraphNode(node.value);
        map.put(node, copy);

        for (GraphNode neighbor : node.neighbors) {
            dfsAdd(seen, map, neighbor);
        }
    }

    public static void main(String[] args) {
        GraphNode node = GraphNodeUtils.buildGenericGraph();
        GraphNodeUtils.printGraph(node);
        System.out.println();
        GraphNode copy = cloneGraph(node);
        GraphNodeUtils.printGraph(copy);
    }
}
