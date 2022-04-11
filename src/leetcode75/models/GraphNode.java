package models;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    
    public int value;

    public List<GraphNode> neighbors;

    public GraphNode() {
        this.value = 0;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode(int value, List<GraphNode> neighbors) {
        this.value = value;
        this.neighbors = neighbors;
    }
}
