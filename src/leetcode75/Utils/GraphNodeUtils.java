package Utils;

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
}
