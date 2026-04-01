/**
 * @author Hani Mohammed (Hani Badawy)
 */
package App;

import sample.Student;
import util.Reader;
import sample.NameComparator;

import java.util.HashMap;
import java.util.Vector;

import algo.Searcher;
import algo.Sorter;
import ds.Array;
import ds.Graph;
import ds.Queue;
import ds.Stack;
import sample.GpaComparator;
import sample.IdComparator;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Array<Integer> arr = new Array<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);

		for (var item : arr) {
			System.out.println(item);
		}

		String filePath = Main.class.getResource("/students_data.txt").getPath();

		Reader<Student> reader = new Reader<>(filePath, Student.class);
		reader.readData();
		Object[] objects = reader.getData();
		Student[] students = new Student[objects.length];
		for (int i = 0; i < objects.length; i++) {
			print(objects[i]);
			students[i] = objects[i] instanceof Student ? (Student) objects[i] : null;
		}

		Sorter<Student> sorter = new Sorter<>();
		sorter.selectionSort(students);
		print("After Sorting:");
		int i = 0;
		for (Object student : students) {
			print(i++ + " " + student);
		}

		Student s1 = new Student("QuinnK", 2732, 2.69f);
		Student s2 = new Student("YaraY", 2153, 2.92f);
		int index = -1;
		Searcher<Student> searcher = new Searcher<>();
		index = searcher.linearSearch(students, s1);
		if (index != -1) {
			print("Student found at index " + index + ": " + students[index]);
		} else {
			print("Student not found: " + s1);
		}

		index = searcher.binarySearch(students, s2);
		if (index != -1) {
			print("Student found at index " + index + ": " + students[index]);
		} else {
			print("Student not found: " + s2);
		}

		// test validation
		String expression = "( { [  } )";
		boolean isValid = validateExpression(expression);
		if (isValid) {
			print("The expression is valid.");
		} else {
			print("The expression is invalid.");
		}

		try {
			testGraph();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			testShortestPath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		testHasCycle();
		
		hasCycleDirected();
	}

	private static void print(Object obj) {
		System.out.println(obj);
	}

	public static String add(String a, String b) {
		return a + b;
	}

	public static int add(int a, int b) {
		return a + b;
	}

	private static void testGraph() throws Exception {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		System.out.println("BFS starting from vertex 0:");
		graph.bfs(0);
		System.out.println();
	}

	private static void testShortestPath() throws Exception {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(4, 5);

		int shortestPath = graph.shortestPath(0, 5);
		System.out.println("Shortest path from vertex 0 to vertex 5: "
		+ shortestPath);
	}

	private static void testStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Top element: " + stack.peek());
		System.out.println("Popped element: " + stack.pop());
		System.out.println("Top element after pop: " + stack.peek());
	}
	
	private static void testQueue() throws Exception {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println("Front element: " + queue.peek());
		System.out.println("Dequeued element: " + queue.dequeue());
		System.out.println("Front element after dequeue: " + queue.peek());
	}
	
	private static void testHasCycle() {
		Graph graph = new Graph(5);
		graph.addEdge(3, 4);
		graph.addEdge(3, 2);
		graph.addEdge(2, 1);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		
		boolean hasCycle = graph.hasCycle();
		if (hasCycle) {
			System.out.println("The graph has a cycle.");
		} else {
			System.out.println("The graph does not have a cycle.");
		}
	}
	
	private static void hasCycleDirected() {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 2); // This edge creates a cycle in the directed graph
		
		boolean hasCycle = graph.hasCycleDirected();
		if (hasCycle) {
			System.out.println("The directed graph has a cycle.");
		} else {
			System.out.println("The directed graph does not have a cycle.");
		}
	}
	
	private static void testComparison() {
		// Create Comparators
		Student s1 = new Student("Alice", 456, 3.5f);
		Student s2 = new Student("Bob", 123, 3.8f);
		NameComparator nameComparator = new NameComparator();
		GpaComparator gpaComparator = new GpaComparator();
		IdComparator idComparator = new IdComparator();
		int nameComparison = nameComparator.compare(s1, s2);
		int gpaComparison = gpaComparator.compare(s1, s2);
		int idComparison = idComparator.compare(s1, s2);
		if (nameComparison < 0) {
			System.out.println(s1.getName() + " comes before " + s2.getName() + " alphabetically.");
		} else if (nameComparison > 0) {
			System.out.println(s1.getName() + " comes after " + s2.getName() + " alphabetically.");
		} else {
			System.out.println(s1.getName() + " and " + s2.getName() + " have the same name.");
		}
		if (gpaComparison < 0) {
			System.out.println(s1.getName() + " has a lower GPA than " + s2.getName());
		} else if (gpaComparison > 0) {
			System.out.println(s1.getName() + " has a higher GPA than " + s2.getName());
		} else {
			System.out.println(s1.getName() + " has the same GPA as " + s2.getName());
		}
		if (idComparison < 0) {
			System.out.println(s1.getName() + " has a lower ID than " + s2.getName());
		} else if (idComparison > 0) {
			System.out.println(s1.getName() + " has a higher ID than " + s2.getName());
		} else {
			System.out.println(s1.getName() + " and " + s2.getName() + " have the same ID.");
		}

		int comparison = s1.compareTo(s2);
		if (comparison < 0) {
			System.out.println(s1.getName() + " has a lower GPA than " + s2.getName());
		} else if (comparison > 0) {
			System.out.println(s1.getName() + " has a higher GPA than " + s2.getName());
		} else {
			System.out.println(s1.getName() + " has the same GPA as " + s2.getName());
		}
	}

	private static boolean validateExpression(String expression) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		map.put('>', '<');
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char token = expression.charAt(i);
			if (map.containsValue(token)) {
				stack.push(token);
			} else if (map.containsKey(token)) {
				if (stack.isEmpty() || !stack.peek().equals(map.get(token))) {
					return false;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
