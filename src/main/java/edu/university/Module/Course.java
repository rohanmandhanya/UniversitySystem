/**
 * 
 */
package edu.university.Module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {
	@Id
	@Column(name = "course_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "credits")
	private Integer credits;
	
	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Column(name = "rate")
	private Integer rate;
	
	public Course() {
	}
	
	public Course(Integer rate) {
	this.rate = rate;
	}

	public Course(Integer id, String name, Integer credits, String location) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.location = location;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
