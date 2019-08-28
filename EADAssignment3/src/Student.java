/*
 * Represents Student
 */
public class Student {
	int id;
	String first_name;
	String last_name;
	String father_name;
	String email;
	int class_student;
	int age;
	
	public Student(int id,String first_name, String last_name, String father_name,
			String email, int class_student, int age) {
		this.id=id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.father_name = father_name;
		this.email = email;
		this.class_student = class_student;
		this.age = age;
	}
}
