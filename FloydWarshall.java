public class FloydWarshall {

    // Method to implement Floyd-Warshall algorithm
    public static void floydWarshall(int[][] graph) {
        int V = graph.length; // Number of vertices in the graph

        // dist[][] will hold the shortest distance between every pair of vertices
        int[][] dist = new int[V][V];

        // Initialize the solution matrix same as the input graph matrix.
        // dist[][] will be the output matrix that will eventually have the shortest distances
        // between every pair of vertices.
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0; // Distance from a vertex to itself is always 0
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j]; // Distance from i to j is the edge weight
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // If no edge exists, set it as infinity
                }
            }
        }

        // Update the distance matrix by considering each vertex as an intermediate vertex.
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // If a shorter path from i to j through k is found, update dist[i][j]
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && 
                        dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    // Method to print the solution
    public static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("The shortest distances between every pair of vertices are:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Driver method
    public static void main(String[] args) {
        // Create a graph represented by a 2D array
        // graph[i][j] represents the weight of the edge from vertex i to vertex j
        int[][] graph = {
            {0, 3, 0, 0, 0, 0},
            {3, 0, 1, 0, 0, 0},
            {0, 1, 0, 7, 0, 2},
            {0, 0, 7, 0, 1, 3},
            {0, 0, 0, 1, 0, 6},
            {0, 0, 2, 3, 6, 0}
        };

        // Call the Floyd-Warshall algorithm
        floydWarshall(graph);
    }
}

