package bai19;

import java.util.List;
import java.util.Objects;

public class Student {
	private String name;
	private String id;
	private Date birthday;
	private List<Subject> listOfSubject;

	private double averageScore;

	public Student(String name, String id, Date birthday, List<Subject> listOfSubject) {
		super();
		this.name = name;
		this.id = id;
		this.birthday = birthday;
		this.listOfSubject = listOfSubject;
		this.averageScore = 0.0;
	}
	
	public Subject findSubjectByID(String id) {
		for (Subject sub: this.listOfSubject) {
			if(sub.getId().equals(id))
				return sub;
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setAverageScore(double score) {
		this.averageScore = score;
	}

	public double getAverageScore() {
		return this.averageScore;
	}

	public List<Subject> getListOfSubject() {
		return listOfSubject;
	}

	public void setListOfSubject(List<Subject> listOfSubject) {
		this.listOfSubject = listOfSubject;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", averageScore=" + averageScore + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, id, listOfSubject, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(id, other.id)
				&& Objects.equals(listOfSubject, other.listOfSubject) && Objects.equals(name, other.name);
	}

	public boolean addScore(Subject subject, double score) {
		for (Subject s : this.listOfSubject) {
			if (s.equals(subject)) {
				return s.setScore(score);
			}
		}
		return false;
	}

	public double calculateAverageScore() {
		double sum = 0;
		for (int i = 0; i < this.listOfSubject.size(); i++) {
			sum += this.listOfSubject.get(i).getScore();
		}
		return sum / this.listOfSubject.size();
	}

}
