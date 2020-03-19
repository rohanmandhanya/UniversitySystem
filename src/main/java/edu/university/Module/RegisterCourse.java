package edu.university.Module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.university.student.Student;

@Entity
@Table(name = "register")
public class RegisterCourse {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name="course1")
	private Course course1;
	
	@ManyToOne
	@JoinColumn(name="course2")
	private Course course2;
	
	@ManyToOne
	@JoinColumn(name="course3")
	private Course course3;
	
	public RegisterCourse(){
	}
	
	public RegisterCourse(Student student){
		this.student = student;	
	}
	
	public RegisterCourse(Student student , Course course1){
		this.student = student;
		this.course1 = course1;
	}
	
	public RegisterCourse(Student student , Course course1 , Course course2){
		this.student = student;
		this.course1 = course1;
		this.course2 = course2;
	}
	
	public RegisterCourse(Student student , Course course1 , Course course2 , Course course3){
		this.student = student;
		this.course1 = course1;
		this.course2 = course2;
		this.course3 = course3;
	}

	
	public void setCourse1(Course course) {
		this.course1 = course;
	}
	
	public Course getCourse1() {
		return course1;
	}
	
	public void setCourse2(Course course) {
		this.course2 = course;
	}
	
	public Course getCourse2() {
		return course2;
	}
	
	public void setCourse3(Course course) {
		this.course3 = course;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse3() {
		return course3;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
