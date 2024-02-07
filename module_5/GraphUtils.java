package module_5;

// import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Set;

public class GraphUtils<T> {
    public static void main(String[] args) {
        Graph<String> graph = new AdjacencyListGraph<String>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        System.out.println(graph);

        graph.addVertex("A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "E");
        graph.removeVertex("E");
        graph.removeVertex("A");

        System.out.println(graph);

        graph.addVertex("A");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        System.out.println(graph);

        graph.addEdge("D", "C");

        System.out.println(graph);

        graph.addVertex("E");

        graph.addEdge("C", "E");

        System.out.println(graph);

        System.out.println("DFS");
        dfs(graph, "A");

        System.out.println("BFS");
        bfs(graph, "A");

        graph.addEdge("D", "B");

        System.out.println(graph);

        System.out.println("DFS");
        dfs(graph, "A");

        System.out.println("BFS");
        bfs(graph, "A");

        System.out.println("DFS");
        dfs(graph, "B");

        System.out.println("BFS");
        bfs(graph, "B");

        System.out.println(graph);

        List<String> topologicalSort = topologicalSort(graph);
        if (topologicalSort == null) {
            System.out.println("The graph doesn't have a topological sort");
        } else {
            for (String s : topologicalSort) {
                System.out.print(s + " - ");
            }
            System.out.println();

            if (isAcyclic(graph)) {
                System.out.println("The graph is acyclic");
            } else {
                System.out.println("There is a cycle in the graph");
            }
        }

        graph.removeEdge("D", "B");
        System.out.println(graph);

        topologicalSort = topologicalSort(graph);
        if (topologicalSort == null) {
            System.out.println("The graph doesn't have a topological sort");
        } else {
            for (String s : topologicalSort) {
                System.out.print(s + " - ");
            }
            System.out.println();

            if (isAcyclic(graph)) {
                System.out.println("The graph is acyclic");
            } else {
                System.out.println("There is a cycle in the graph");
            }
        }
    }

    public static <T> List<T> dfs(Graph<T> graph, T start) {
        List<T> visited = new LinkedList<T>();
        dfs_visit(graph, start, visited);
        System.out.println();
        return visited;
    }

    public static <T> void dfs_visit(Graph<T> graph, T start, List<T> visited) {
        System.out.print(start + " - ");
        visited.add(start);
        for (T neighbor : graph.neighbors(start)) {
            if (!visited.contains(neighbor)) {
                dfs_visit(graph, neighbor, visited);
            }
        }
    }

    public static <T> List<T> bfs(Graph<T> graph, T start) {
        List<T> visited = new LinkedList<T>();
        Queue<T> queue = new LinkedList<T>();

        queue.add(start);

        while (!queue.isEmpty()) {
            T visitedVertex = queue.remove();
            if (!visited.contains(visitedVertex)) {
                System.out.print(visitedVertex + " - ");
                visited.add(visitedVertex);
            }
            for (T neighbor : graph.neighbors(visitedVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
        return visited;
    }

    public static <T> List<T> topologicalSort(Graph<T> graph) {
        Graph<T> graphCopy = graph.clone();
        List<T> visited = new LinkedList<T>();
        HashMap<T, Integer> incomingEdges = new HashMap<T, Integer>();

        for (T vertex : graphCopy.getVertecesList()) {
            incomingEdges.put(vertex, 0);
        }

        for (T vertex : graphCopy.getVertecesList()) {
            for (T neighbors : graphCopy.neighbors(vertex)) {
                Integer incoming = incomingEdges.get(neighbors);
                incoming++;
                incomingEdges.put(neighbors, incoming);
            }
        }

        boolean thereIsALoop = false;
        while (!thereIsALoop && !graphCopy.getVertecesList().isEmpty()) {
            T selected = null;
            for (T vertex : graphCopy.getVertecesList()) {
                if (incomingEdges.get(vertex) == 0) {
                    selected = vertex;
                }
            }
            if (selected == null) {
                thereIsALoop = true;
            } else {
                for (T neighbors : graphCopy.neighbors(selected)) {
                    Integer incoming = incomingEdges.get(neighbors);
                    incoming--;
                    incomingEdges.put(neighbors, incoming);
                }
                graphCopy.removeVertex(selected);
                visited.add(selected);
            }
        }

        if (thereIsALoop) {
            return null;
        } else {
            return visited;
        }

    }

    public static <T> boolean isAcyclic(Graph<T> graph) {
        return (topologicalSort(graph) != null);
    }
}