package student;

public class Student {
	String name;
	int age;
	long id;
	String department;
	String universityYear;

	public Student() {}
	
	public Student(String name, int age, long id, String department, String universityYear) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.department = department;
		this.universityYear = universityYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUniversityYear() {
		return universityYear;
	}

	public void setUniversityYear(String universityYear) {
		this.universityYear = universityYear;
	}

}
