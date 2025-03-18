import java.util.Scanner;
public class FloydWarshall {
    // Function to implement Floyd-Warshall Algorithm
    public static void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        // Initialize the distance matrix with input graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0; // The distance from a vertex to itself is 0
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j]; // Initialize with the edge weights
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // Use Integer.MAX_VALUE to represent infinity
                }
            }
        }
        // Floyd-Warshall algorithm to find the shortest path between all pairs of vertices
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the distance matrix
        printSolution(dist, V);
    }

    // Function to print the solution matrix
    public static void printSolution(int dist[][], int V) {
        System.out.println("Shortest distances between every pair of vertices:");
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

    // Main function to test the algorithm
    public static void main(String[] args) {
        // Input for the graph
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        
        // Create the adjacency matrix (graph representation)
        int graph[][] = new int[V][V];
        
        System.out.println("Enter the adjacency matrix (enter 0 for no direct edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Apply the Floyd-Warshall algorithm to find all pairs shortest path
        floydWarshall(graph, V);
        
        scanner.close();
    }
}
