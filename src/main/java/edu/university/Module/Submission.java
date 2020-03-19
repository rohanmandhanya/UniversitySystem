package edu.university.Module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.university.student.Student;

@Entity
@Table(name = "submission")
public class Submission {
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "assign_id")
	private Assignment submit;
	
	@Id
	@Column(name = "submission_id")
	private Integer id;
	
	@Column(name = "answers")
	private String answer;
	
	@Column(name = "points")
	private Integer points;
	
	public Submission() {
		}

	public Submission(Integer points) {
		this.points = points;
	}
	
	public Submission(Student student, Assignment assignment, String answer) {
		this.answer = answer;
		this.student = student;
		this.submit = assignment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Assignment getSubmit() {
		return submit;
	}

	public void setSubmit(Assignment submit) {
		this.submit = submit;
	}
}
