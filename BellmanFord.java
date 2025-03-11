import java.util.Arrays;

public class BellmanFord {

    // Method to implement Bellman-Ford algorithm
    public static void bellmanFord(int[][] graph, int V, int source) {
        // Create a distance array and initialize all distances to infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges (V - 1) times
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    // If there's an edge from u to v
                    if (graph[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE 
                        && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // Print the shortest distances from the source
        printSolution(dist);
    }

    // Method to print the solution
    public static void printSolution(int[] dist) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " \t INF");
            } else {
                System.out.println(i + " \t " + dist[i]);
            }
        }
    }

    // Driver method
    public static void main(String[] args) {
        // Create a graph represented by a 2D adjacency matrix
        // graph[i][j] represents the weight of the edge from vertex i to vertex j
        int V = 5;
        int[][] graph = new int[][] {
            {0, 2, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, 3, 1, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 5, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 6},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        int source = 0; // Starting vertex

        // Call the Bellman-Ford algorithm
        bellmanFord(graph, V, source);
    }
}

//output

Vertex   Distance from Source
0        0
1        2
2        4
3        3
4        9
