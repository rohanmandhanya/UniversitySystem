package edu.university.Module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.university.Enum.Scholarshiptype;
import edu.university.student.Student;

@Entity
@Table(name = "scholarship")
public class Scholarship {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Column(name = "scholarship")
	private Integer scholarship;
	
	@Column(name = "type")
	private Scholarshiptype type;
	
	public Scholarship() {
	}

	public Scholarship(Student student, Integer scholarship, String type) {
		this.student = student;
		this.scholarship = scholarship;
		this.type = Scholarshiptype.valueOf(type);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getScholarship() {
		return scholarship;
	}

	public void setScholarship(Integer scholarship) {
		this.scholarship = scholarship;
	}

	public Scholarshiptype getType() {
		return type;
	}

	public void setType(Scholarshiptype type) {
		this.type = type;
	}
}
