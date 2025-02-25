import java.util.*;

public class Dijkstra {
    // Method to perform Dijkstra's algorithm to find the shortest path
    public static void dijkstra(int graph[][], int source) {
        int numVertices = graph.length;
        // Array to store the shortest distance from the source to each vertex
        int[] distances = new int[numVertices];
        // Set all distances initially to infinity
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        // Boolean array to track visited vertices
        boolean[] visited = new boolean[numVertices];
        // PriorityQueue to extract the vertex with the minimum distance
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));
        pq.add(new Vertex(source, 0));
        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            int u = current.vertex;
            // If already visited, skip
            if (visited[u])
                continue;
            visited[u] = true;
            // Check all adjacent vertices of the current vertex
            for (int v = 0; v < numVertices; v++) {
                // If there is an edge between u and v and v is not visited
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDist = distances[u] + graph[u][v];
                    // If a shorter path is found, update the distance and add to the queue
                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                        pq.add(new Vertex(v, newDist));
                    }
                }
            }
        }
        // Output the result
        System.out.println("Vertex\tDistance from Source (" + source + ")");
        for (int i = 0; i < numVertices; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println(i + "\tINF");
            } else {
                System.out.println(i + "\t" + distances[i]);
            }
        }
    }

    // Helper class to represent a vertex and its distance in the priority queue
    static class Vertex {
        int vertex;
        int distance;

        Vertex(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    // Main function to run the Dijkstra's algorithm
    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int graph[][] = {
                { 0, 10, 0, 0, 0, 0 }, // Vertex 0 connected to vertex 1 with weight 10
                { 10, 0, 5, 0, 0, 0 }, // Vertex 1 connected to vertex 2 with weight 5
                { 0, 5, 0, 15, 0, 0 }, // Vertex 2 connected to vertex 3 with weight 15
                { 0, 0, 15, 0, 10, 0 }, // Vertex 3 connected to vertex 4 with weight 10
                { 0, 0, 0, 10, 0, 5 }, // Vertex 4 connected to vertex 5 with weight 5
                { 0, 0, 0, 0, 5, 0 } // Vertex 5 connected to vertex 4 with weight 5
        };
        // Call the Dijkstra algorithm with the graph and starting vertex (0)
        dijkstra(graph, 0);
    }
}

output:-
Vertex  Distance from Source (0)
0        0
1        10
2        15
3        30
4        40
5        45
