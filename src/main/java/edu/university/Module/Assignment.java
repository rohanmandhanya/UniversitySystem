package edu.university.Module;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.university.Enum.Assignmenttype;

	@Entity
	@Table(name = "assignment")
	public class Assignment {
		@Id
		@Column(name = "assign_id")
		private Integer assign_id;
		
		@ManyToOne
		@JoinColumn(name ="course_id")
		private Course course;
		
		@Column(name = "points")
		private Integer points;
		
		@Column(name = "type")
		private Assignmenttype type;
		
		public Assignment() {
		}

		public Assignment(Course course, Integer id, Integer points, String type) {
			this.course = course;
			this.assign_id = id;
			this.points = points;
			this.type =  Assignmenttype.valueOf(type);
		}
		
		public Course getCourse() {
			return course;
		}
		
		public void setCourse(Course course) {
			this.course = course;
		}

		public Integer getAssign_id() {
			return assign_id;
		}

		public void setAssign_id(Integer assign_id) {
			this.assign_id = assign_id;
		}

		public Assignmenttype getType() {
			return type;
		}

		public void setType(Assignmenttype type) {
			this.type = type;
		}

		public Integer getPoints() {
			return points;
		}

		public void setPoints(Integer points) {
			this.points = points;
		}
}
