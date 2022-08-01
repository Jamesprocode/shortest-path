package hw5;


public class Edge implements IEdge {
    Double weight;
    Vertex source;
    Vertex destination;

    public Edge(Vertex source, Vertex destination, Double weight) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public String toString() {
        return "(" + this.source + " - " + this.destination + ")";
    }
}

