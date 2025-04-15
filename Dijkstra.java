import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    // Define the GraphEdge class
    static class GraphEdge {
        private final int vertex;
        private final int weight;

        public GraphEdge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public static void main(String[] args) {
            WeightedGraph graph = new WeightedGraph(5);
            graph.addEdge(0, 1, 10);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 8);
            graph.addEdge(3, 4, 7);
    
            int[] shortestPaths = dijkstraShortestPath(graph, 0);
            System.out.println("Shortest paths from source 0: " + Arrays.toString(shortestPaths));
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }
    }


// Removed DijkstraAlgorithm class from this file

    // Define the WeightedGraph class if it is missing
    static class WeightedGraph {
        private final int[][] adjacencyMatrix;

        public WeightedGraph(int vertices) {
            adjacencyMatrix = new int[vertices][vertices];
        }

        public void addEdge(int source, int destination, int weight) {
            adjacencyMatrix[source][destination] = weight;
        }

        public int[] getVertices() {
            return new int[adjacencyMatrix.length];
        }

        public GraphEdge[] getNeighbors(int vertex) {
            // Example implementation to return neighbors
            return new GraphEdge[0]; // Replace with actual logic
        }
    }

    static int [] dijkstraShortestPath(WeightedGraph graph, int source){
        //store all distances
        int [] distances = new int[graph.getVertices().length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<GraphEdge> queue = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));
        //set the distance of the source to 0
        distances[source] = 0;
        //add the source to the queue
        queue.add(new GraphEdge(source, 0));
        //while the queue is not empty
        while (!queue.isEmpty()){
            //get the vertex with the smallest distance
            GraphEdge current = queue.poll();
            int currentVertex = current.getVertex();
            //if the distance is not updated, continue
            if (current.getWeight() > distances[currentVertex]){
                continue;
            }
            //for each neighbor of the current vertex
            for (GraphEdge edge : graph.getNeighbors(currentVertex)){
                int neighbor = edge.getVertex();
                int newDistance = distances[currentVertex] + edge.getWeight();
                //if the new distance is smaller than the current distance, update it and add it to the queue
                if (newDistance < distances[neighbor]){
                    distances[neighbor] = newDistance;
                    queue.add(new GraphEdge(neighbor, newDistance));
                }
            }
        }
        return distances;
    }
}
