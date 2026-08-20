package bai19;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
	List<Student> listOfStudent;

	public StudentManagement() {
		this.listOfStudent = new ArrayList<Student>();
		
		Subject s1 = new Subject("Lập trình nâng cao", "1111");
		Subject s2 = new Subject("Lý thuyết đồ thị", "2222");
		Subject s3 = new Subject("Lập trình cơ bản", "3333");
		Subject s4 = new Subject("Thiết kế hướng đối tượng", "9999");
		
		List<Subject> listSubject1 = new ArrayList<Subject>();
		listSubject1.add(new Subject(s1));
		listSubject1.add(new Subject(s2));
		listSubject1.add(new Subject(s3));
		
		Student stu1 = new Student("name 1", "111", new Date(1,1,2020), listSubject1);
		
		List<Subject> listSubject2 = new ArrayList<Subject>();
		listSubject2.add(new Subject(s1));
		listSubject2.add(new Subject(s4));
		
		Student stu2 = new Student("name 2", "222", new Date(1,1,2020), listSubject2);
		
		List<Subject> listSubject3 = new ArrayList<Subject>();
		listSubject3.add(new Subject(s2));
		listSubject3.add(new Subject(s3));
		listSubject3.add(new Subject(s4));
		
		Student stu3 = new Student("name 3", "333", new Date(1,1,2020), listSubject3);
		
//		this.listOfStudent.add(stu1);
//		this.listOfStudent.add(stu2);
//		this.listOfStudent.add(stu3);
		
		this.addStudent(stu1);
		this.addStudent(stu2);
		this.addStudent(stu3);
		
	}
	
	public boolean addStudent(Student stu) {
		if(!listOfStudent.contains(stu)) {
			return this.listOfStudent.add(stu);
		}
		return false;
	}
	
	public boolean addScore(Student stu, Subject subject, double score) {
		for (Student s: this.listOfStudent) {
			if(s.equals(stu)) {
				return s.addScore(subject, score);
			}
		}
		return false;
	}
	
	public void calculateAverageScore() {
		for (int i = 0; i < this.listOfStudent.size(); i++) {
			this.listOfStudent.get(i).setAverageScore(this.listOfStudent.get(i).calculateAverageScore());
		}
	}
	
	public List<Student> findStudentByName(String name) {
		List<Student> result = new ArrayList<Student>();
		for (Student stu: this.listOfStudent) {
			if(stu.getName().equals(name)) {
				result.add(stu);
			}
		}
		return result;
	}
	
	public Student findStudentByID(String id) {
		for (Student stu: this.listOfStudent) {
			if(stu.getId().equals(id)) {
				return stu;
			}
		}
		return null;
	}
	
	public String printStudent() {
		List<Student> newList = new ArrayList<Student>(this.listOfStudent);
		Collections.sort(newList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				
				Double score1 = o1.getAverageScore();
				Double score2 = o2.getAverageScore();
				
				if(name1.compareTo(name2) == 0) {
					return score2.compareTo(score1);
				}
				else return name1.compareTo(name2);
			}
		});
		
		String result = "";
		for (Student s: listOfStudent) {
			result += s.toString() + "\n";
		}
		return result.trim();
	}
}
