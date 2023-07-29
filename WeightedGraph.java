import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> map;

    public WeightedGraph() {
        map = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        if (!map.containsKey(source) || !map.containsKey(destination)) {
            throw new IllegalArgumentException("Source or destination vertex not found.");
        }

        source.addAdjacentVertex(destination, weight);
    }

    public List<Vertex<V>> getVertices() {
        return new ArrayList<>(map.keySet());
    }

    public List<Vertex<V>> getAdjacentVertices(Vertex<V> vertex) {
        if (!map.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex not found.");
        }

        return new ArrayList<>(map.get(vertex));
    }

    // You can add other methods as needed
}
