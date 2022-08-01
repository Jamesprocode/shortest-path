package hw5;

public class GraphTester {
    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        // Edge ab = new Edge(a, b, 10.0);
        Edge bc = new Edge(b, c, 20.0);
        b.addEdge(bc);
        // a.addEdge(ab);

        // System.out.println(ab);
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(b.edges);
        // System.out.println(a.edges);

        System.out.println("graph-----------------------------------");

        Graph g = new Graph();
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.printGraph();
        System.out.println("-----------------------------------");

        g.addEdge("b", "a", 5.0);
        g.addUndirectedEdge("c", "a", 1.0);
        g.printGraph();
        System.out.println(g.hasVertex(a)); // a
        System.out.println(g.getVertex("a")); // a
        System.out.println(g.getVertices()); // a,b,c
        c.totalDistance = 1.0;
        System.out.println(g.findClosestVertex(g.vertices));

        System.out.println("dijkstra tester 1-------------------------------------");
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Graph dijkstra = new Graph();
        dijkstra.addVertex(A);
        dijkstra.addVertex(B);
        dijkstra.addVertex(C);
        dijkstra.addVertex(D);
        dijkstra.addVertex(E);
        dijkstra.addVertex(F);
        dijkstra.addVertex(G);
        dijkstra.addEdge("A", "B", 2.0);
        dijkstra.addEdge("A", "D", 1.0);
        dijkstra.addEdge("B", "D", 3.0);
        dijkstra.addEdge("B", "E", 10.0);
        dijkstra.addEdge("E", "G", 6.0);
        dijkstra.addEdge("D", "E", 2.0);
        dijkstra.addEdge("D", "C", 2.0);
        dijkstra.addEdge("D", "F", 8.0);
        dijkstra.addEdge("D", "G", 4.0);
        dijkstra.addEdge("C", "F", 5.0);
        dijkstra.addEdge("C", "A", 4.0);
        dijkstra.addEdge("G", "F", 1.0);
        dijkstra.printGraph();
        System.out.println(dijkstra.getDijkstraPath("G", "F"));       
        System.out.println(dijkstra.getDijkstraPath("A", "F"));

        
        

        // dijkstra tester 2
        System.out.println("dijkstra tester 2-------------------------------------");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        Vertex J = new Vertex("J");
        Vertex K = new Vertex("K");
        Vertex L = new Vertex("L");
        Graph d = new Graph();
        d.addVertex(H);
        d.addVertex(I);
        d.addVertex(J);
        d.addVertex(K);
        d.addVertex(L);
        d.addEdge("H", "I", 7.0);
        d.addEdge("H", "J", 2.0);
        d.addEdge("I", "J", 2.0);
        d.addEdge("I", "L", 1.0);
        d.addEdge("J", "I", 3.0);
        d.addEdge("J", "K", 5.0);
        d.addEdge("J", "L", 8.0);
        d.addEdge("K", "L", 5.0);
        d.addEdge("L", "K", 4.0);
        d.printGraph();
        System.out.println("shortest path tester2-------------------------------");
        System.out.println(d.getDijkstraPath("H", "K"));
        System.out.println(d.getDijkstraPath("H", "K"));


    }
}
