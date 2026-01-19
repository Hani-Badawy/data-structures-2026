/**
 * @author Hani Mohammed (Hani Badawy)
 */
package App;
import sample.Student;
import sample.NameComparator;
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
		
		//System.out.println(add(5, 10));
		//System.out.println(add("Hello, ", "World!"));
		
		// Testing the student class
		Student s1 = new Student("Alice", 3.5f);
		Student s2 = new Student("Bob", 3.8f);
		
		//Create Comparators
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
	
	public static String add(String a, String b) {
		return a + b;
	}
	
	public static int add(int a, int b) {
		return a + b;
	}

}
