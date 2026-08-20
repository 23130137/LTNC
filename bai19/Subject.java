package bai19;
import java.util.Objects;

public class Subject {
	private String name;
	private String id;
	private double score;

	public Subject(String name, String id) {
		this.name = name;
		this.id = id;
		this.score = 0;
	}
	
	public Subject(Subject that) {
		this.name = that.name;
		this.id = that.id;
		this.score = that.score;
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

	public double getScore() {
		return score;
	}

	public boolean setScore(double score) {
		this.score = score;
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score);
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", id=" + id + ", score=" + score + "]";
	}

}
