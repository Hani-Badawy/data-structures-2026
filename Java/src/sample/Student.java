package sample;

public class Student implements Comparable<Student> {
	private String name;
	private int id;
	private float gpa;

	public Student(String name, float gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public int compareTo(Student other) {
		if (this.gpa < other.gpa) {
			return -1;
		} else if (this.gpa > other.gpa) {
			return 1;
		} else {
			return 0;
		}
	}
}
