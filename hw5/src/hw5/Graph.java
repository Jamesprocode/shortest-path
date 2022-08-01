package hw5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph implements IGraph {

    ArrayList<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public boolean hasVertex(Vertex v) {
        for (int i = 0; i < vertices.size(); i++) {
            if (this.vertices.get(i).value.equals(v.value)) {
                return true;
            }
        }
        return false;
    }

    public List<Vertex> getVertices() {
        return this.vertices;
    }

    public void addVertex(Vertex v) {
        if (hasVertex(v)) {
            throw new IllegalArgumentException();
        }
        this.vertices.add(v);
    }

    public Vertex getVertex(String name) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).value.equals(name)) {
                return this.vertices.get(i);
            }
        }
        return null;
    }

    public void addEdge(String start, String dest, Double cost) {
        Vertex source = getVertex(start);
        Vertex destination = getVertex(dest);
        Edge add = new Edge(source, destination, cost);
        source.addEdge(add);
        // ask question
    }

    public void addUndirectedEdge(String start, String dest, Double cost) {
        Vertex source = getVertex(start);
        Vertex destination = getVertex(dest);
        Edge add = new Edge(source, destination, cost);
        source.addEdge(add);
        Edge undirected = new Edge(destination, source, cost);
        destination.addEdge(undirected);
    }

    public int findClosestVertex(List<Vertex> list) {
        int close = 0;
        Double min = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).totalDistance < min) {
                min = list.get(i).totalDistance;
                close = i;
            }
        }
        return close;
    }

    public void dijkstra(String s) {        
    	// duplicate the array
        ArrayList<Vertex> verticesCopy = new ArrayList<>();
        for (int i = 0; i < this.vertices.size(); i++) {
            this.vertices.get(i).totalDistance = Double.MAX_VALUE;
        	verticesCopy.add(this.vertices.get(i));
           
        }
        // initialize the fisrt vertex
        Vertex current = this.getVertex(s);
        current.hasVisited = true;
        current.source = null;
        current.totalDistance = 0.0;
        //start looping to update shortest path
        for (int j = 0; j < this.vertices.size() - 1; j++) {
            current.hasVisited = true;
            for (int i = 0; i < current.neighbors.size(); i++) { 
            	Edge currentEdge = current.neighbors.get(i);
                Vertex dest = currentEdge.destination;
                if (currentEdge.weight + current.totalDistance < dest.totalDistance) {
                    dest.totalDistance = currentEdge.weight + current.totalDistance;
                    dest.source = current;
                    
                }
            }
            verticesCopy.remove(current);                   
            int next = findClosestVertex(verticesCopy);
            current = verticesCopy.get(next);
        }

    }

    public List<Edge> getDijkstraPath(String start, String dest) {
    	//run dijkstra on start
    	dijkstra(start);
    	//get vertex
        Vertex initial = getVertex(start);
        LinkedList<Edge> shortestPath = new LinkedList<>();
        Vertex destination = getVertex(dest);
        //loop to find the path
        while (destination.source != null) {
            for (int i = 0; i < destination.source.neighbors.size(); i++) {
                Edge edge = destination.source.neighbors.get(i);
                if (edge.destination.equals(destination)) {
                    shortestPath.addFirst(edge);
                }
            }
            destination = destination.source;
        }
        if (destination.value == initial.value) {
            return shortestPath;
        } else {
        	System.out.println("---------------");
            return new LinkedList<Edge>();
        }
    }
  
    

    public void printGraph() {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex current = vertices.get(i);
            if (current.neighbors.isEmpty()) {
                System.out.println(vertices.get(i).value + ": ");
            } else {
                System.out.print(current.value + ": ");
            }

            for (int j = 0; j < current.neighbors.size(); j++) {
                if (j == current.neighbors.size() - 1) {
                    System.out.println(current.neighbors.get(j));
                } else {
                    System.out.print(current.neighbors.get(j));
                }

            }

        }
    }

}
