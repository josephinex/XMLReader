package student;

import java.util.ArrayList;
import java.util.List;

public class Students {
	
	public static List<Student> getStudentList() {
		Student s1 = new Student("Alice", 19, 678945, "Physics", "first");
		Student s2 = new Student("John", 21, 678445, "Mathematics", "third");
		Student s3 = new Student("Ralf", 23, 674445, "Computer Science", "fourth");
		
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		return list;
	}
	
}
