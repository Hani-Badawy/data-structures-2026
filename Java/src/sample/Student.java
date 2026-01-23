package sample;

public class Student implements Comparable<Student> {
	private String name;
	private int id;
	private float gpa;

	public Student(String record) {
		String[] data = record.split(" ");
		this.name = data[0];
		this.id = Integer.parseInt(data[1]);
		this.gpa = Float.parseFloat(data[2]);
	}
	
	public Student(String name, int id,  float gpa) {
		this.name = name;
		this.gpa = gpa;
		this.id = id;
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
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", gpa=" + gpa + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Student)obj).name);
	}
	
	
	
}
