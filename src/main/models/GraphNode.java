package main.models;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    
    public int value;

    public int indegree;

    public List<GraphNode> neighbors; // For directed graphs, treat this as an out edge.

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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
