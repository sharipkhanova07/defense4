import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        // Create a weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Add vertices to the graph
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        // Add edges with weights (directed)
        graph.addEdge(v1, v2, 3.0);
        graph.addEdge(v1, v3, 2.0);
        graph.addEdge(v2, v4, 1.5);
        graph.addEdge(v3, v4, 2.5);

        // Perform BFS
        System.out.println("BFS Traversal:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsTraversal = bfs.bfsTraversal(v1);
        for (Vertex<String> vertex : bfsTraversal) {
            System.out.print(vertex.getData() + " ");
        }
        System.out.println();

        // Perform Dijkstra's algorithm
        System.out.println("\nDijkstra's Shortest Paths:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        Map<Vertex<String>, Double> shortestPaths = dijkstra.dijkstra(v1);
        for (Vertex<String> vertex : shortestPaths.keySet()) {
            System.out.println("Shortest path from " + v1.getData() + " to " + vertex.getData() +
                    " is " + shortestPaths.get(vertex));
        }
    }
}
