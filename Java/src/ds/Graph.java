package ds;

import java.util.ArrayList;

public class Graph {
ArrayList<ArrayList<Integer>> adjList;
	
	public Graph(int vertices) {
		adjList = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}
	
	// This method adds dest to the adjacency list of src and src to the adjacency list of dest
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		adjList.get(dest).add(src); 
	}
	
	public void  dfs(int start, boolean[] visited) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for (int neighbor : adjList.get(start)) {
			if (!visited[neighbor]) {
				dfs(neighbor, visited);
			}
		}
	}
	
	public void bfs(int start) throws Exception {
		boolean[] visited = new boolean[adjList.size()];
		Queue<Integer> queue = new Queue<>();
		
		visited[start] = true;
		queue.enqueue(start);
		
		while (!queue.isEmpty()) {
			int vertex = queue.dequeue();
			System.out.print(vertex + " ");
			
			for (int neighbor : adjList.get(vertex)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.enqueue(neighbor);
				}
			}
		}
	}
	
	//shortest path from source to destination using BFS
	public int shortestPath(int src, int dest) throws Exception {
		boolean[] visited = new boolean[adjList.size()];
		Queue<Integer> queue = new Queue<>();
		int[] distance = new int[adjList.size()];
		
		visited[src] = true;
		queue.enqueue(src);
		
		while (!queue.isEmpty()) {
			int vertex = queue.dequeue();
			
			for (int neighbor : adjList.get(vertex)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					distance[neighbor] = distance[vertex] + 1;
					queue.enqueue(neighbor);
					
					if (neighbor == dest) {
						return distance[neighbor];
					}
				}
			}
		}
		
		return -1; // return -1 if there is no path from src to dest
	}
	
	//dijkstra's algorithm for shortest path from source to destination
	public int dijkstra(int src, int dest) {
		int[] dist = new int[adjList.size()];
		boolean[] visited = new boolean[adjList.size()];
		
		for (int i = 0; i < adjList.size(); i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		dist[src] = 0;
		
		for (int i = 0; i < adjList.size() - 1; i++) {
			int u = minDistance(dist, visited);
			visited[u] = true;
			
			for (int neighbor : adjList.get(u)) {
				if (!visited[neighbor] && dist[u] != Integer.MAX_VALUE && dist[u] + 1 < dist[neighbor]) {
					dist[neighbor] = dist[u] + 1;
				}
			}
		}
		
		return dist[dest];
	}
	
	private int minDistance(int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int i = 0; i < dist.length; i++) {
			if (!visited[i] && dist[i] < min) {
				min = dist[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	//detect cycle in an undirected graph using DFS
	public boolean hasCycle() {
		boolean[] visited = new boolean[adjList.size()];
		
		for (int i = 0; i < adjList.size(); i++) {
			if (!visited[i]) {
				if (dfsCycle(i, visited, -1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean dfsCycle(int vertex, boolean[] visited, int parent) {
		visited[vertex] = true;
		
		for (int neighbor : adjList.get(vertex)) {
			if (!visited[neighbor]) {
				if (dfsCycle(neighbor, visited, vertex)) {
					return true;
				}
			} else if (neighbor != parent) {
				return true;
			}
		}
		
		return false;
	}
	
//detect cycle in a directed graph using DFS
	public boolean hasCycleDirected() {
		boolean[] visited = new boolean[adjList.size()];
		boolean[] recStack = new boolean[adjList.size()];
		
		for (int i = 0; i < adjList.size(); i++) {
			if (hasCycleDirectedUtil(i, visited, recStack)) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean hasCycleDirectedUtil(int vertex, boolean[] visited, boolean[] recStack) {
		if (recStack[vertex]) {
			return true;
		}
		
		if (visited[vertex]) {
			return false;
		}
		
		visited[vertex] = true;
		recStack[vertex] = true;
		
		for (int neighbor : adjList.get(vertex)) {
			if (hasCycleDirectedUtil(neighbor, visited, recStack)) {
				return true;
			}
		}
		
		recStack[vertex] = false;
		return false;
	}

}

