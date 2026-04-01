package ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Simple adjacency-list implementation of a weighted graph.
 * Supports directed or undirected graphs and provides Dijkstra's
 * shortest-path algorithm (for non-negative weights).
 */
public class WeightedGraph {

	private final ArrayList<ArrayList<Edge>> adjList;
	private final boolean directed;

	/**
	 * Lightweight edge representation (destination + weight).
	 */
	public static class Edge {
		public final int dest;
		public final int weight;

		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return dest + "(" + weight + ")";
		}
	}

	/**
	 * Create a WeightedGraph with the given number of vertices.
	 *
	 * @param vertices number of vertices (must be >= 0)
	 * @param directed true for a directed graph, false for undirected
	 */
	public WeightedGraph(int vertices, boolean directed) {
		if (vertices < 0) {
			throw new IllegalArgumentException("Number of vertices must be >= 0");
		}
		this.directed = directed;
		adjList = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	/**
	 * Add a weighted edge from src to dest. For undirected graphs, an
	 * edge from dest to src will also be added.
	 *
	 * @param src source vertex
	 * @param dest destination vertex
	 * @param weight non-negative weight
	 */
	public void addEdge(int src, int dest, int weight) {
		checkVertex(src);
		checkVertex(dest);
		if (weight < 0) {
			throw new IllegalArgumentException("Dijkstra requires non-negative weights");
		}
		adjList.get(src).add(new Edge(dest, weight));
		if (!directed) {
			adjList.get(dest).add(new Edge(src, weight));
		}
	}

	/**
	 * Get the neighbors (edges) of the given vertex.
	 */
	public List<Edge> getNeighbors(int v) {
		checkVertex(v);
		return Collections.unmodifiableList(adjList.get(v));
	}

	/**
	 * Number of vertices in the graph.
	 */
	public int size() {
		return adjList.size();
	}

	private void checkVertex(int v) {
		if (v < 0 || v >= adjList.size()) {
			throw new IndexOutOfBoundsException("Vertex index out of bounds: " + v);
		}
	}

	/**
	 * Dijkstra's algorithm from source vertex. Returns an array of distances
	 * where distance[i] is the shortest path weight from src -> i. If a vertex
	 * is unreachable, its distance will be Integer.MAX_VALUE.
	 *
	 * Note: All weights must be non-negative.
	 */
	public int[] dijkstra(int src) {
		checkVertex(src);
		int n = size();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[n];
		
		// min-heap by distance
		PriorityQueue<VertexDist> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
		dist[src] = 0;
		pq.add(new VertexDist(src, 0));

		while (!pq.isEmpty()) {
			VertexDist vd = pq.poll();
			int u = vd.vertex;
			if (visited[u]) continue;
			visited[u] = true;

			for (Edge e : adjList.get(u)) {
				int v = e.dest;
				int w = e.weight;
				if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
					pq.add(new VertexDist(v, dist[v]));
				}
			}
		}

		return dist;
	}

	/**
	 * Find one shortest path (as vertex list) from src to dest using Dijkstra.
	 * Returns an empty list if no path exists. The returned list starts with
	 * src and ends with dest.
	 */
	public List<Integer> shortestPath(int src, int dest) {
		checkVertex(src);
		checkVertex(dest);
		int n = size();
		int[] dist = new int[n];
		int[] prev = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(prev, -1);

		PriorityQueue<VertexDist> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
		dist[src] = 0;
		pq.add(new VertexDist(src, 0));

		while (!pq.isEmpty()) {
			VertexDist vd = pq.poll();
			int u = vd.vertex;
			if (vd.dist != dist[u]) continue; // stale entry

			for (Edge e : adjList.get(u)) {
				int v = e.dest;
				int w = e.weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
					prev[v] = u;
					pq.add(new VertexDist(v, dist[v]));
				}
			}
		}

		List<Integer> path = new LinkedList<>();
		if (dist[dest] == Integer.MAX_VALUE) {
			return path; // empty -> unreachable
		}

		// reconstruct path
		for (int at = dest; at != -1; at = prev[at]) {
			path.add(at);
		}
		// reverse
		Collections.reverse(path);
		return path;
	}

	/**
	 * Simple printable representation of adjacency list.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < adjList.size(); i++) {
			sb.append(i).append(": ");
			for (Edge e : adjList.get(i)) {
				sb.append(e.toString()).append(" ");
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	// helper class for priority queue
	private static class VertexDist {
		int vertex;
		int dist;
		VertexDist(int vertex, int dist) {
			this.vertex = vertex;
			this.dist = dist;
		}
	}
}