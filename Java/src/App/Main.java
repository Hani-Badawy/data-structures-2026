/**
 * @author Hani Mohammed (Hani Badawy)
 */
package App;

import sample.Student;
import util.Reader;
import sample.NameComparator;
import algo.Searcher;
import algo.Sorter;
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

		// System.out.println(add(5, 10));
		// System.out.println(add("Hello, ", "World!"));
		// testComparison();
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
			print(i++ +" "+student);
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

}
