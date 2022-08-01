package hw5;

import java.util.ArrayList;

public class Vertex implements IVertex {
    String value;
    ArrayList<Edge> neighbors;
    boolean hasVisited;
    Double totalDistance;
    Vertex source;
    int x;
    int y;

    public Vertex(String value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
        this.hasVisited = false;
        this.totalDistance = 0.0;
        this.source = null;
        this.x = 0;
        this.y = 0;

    }

    public Vertex(String value, int x, int y) {
        this.value = value;
        this.neighbors = new ArrayList<>();
        this.hasVisited = false;
        this.totalDistance = 0.0;
        this.source = null;
        this.x = x;
        this.y = y;
    }

    public void addEdge(Edge e) {
        this.neighbors.add(e);

    }

    public String toString() {
        return this.value;
    }

}

