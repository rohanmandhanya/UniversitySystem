/**
 * 
 */
package edu.university.Services;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import edu.university.DAO.CourseDAO;
import edu.university.DAO.StudentDAO;
import edu.university.Module.Assignment;
import edu.university.Module.Course;
import edu.university.Module.RegisterCourse;
import edu.university.Module.Submission;

@Path("/student")
public class StudentService {
	private StudentDAO studentDAO = StudentDAO.getStudentDAO();
	private CourseDAO courseDAO = CourseDAO.getCourseDAO();

	@GET
	@Path("/registercourses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	@GET
	@Path("/assignments")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Assignment> getAssignments() {
		return studentDAO.getAssignments();
	}

	@GET
	@Path("/submissions/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Submission getSubmissions(@PathParam("id") int id) {
		return studentDAO.getSubmissions(id);
	}
	@POST
	@Path("/submissions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Submission> createSubmission(Submission submit) {
		return studentDAO.addSubmission(submit);
	}


	@DELETE
	@Path("/submissions/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Submission> deleteStudent(@PathParam("id") int id) {
		return studentDAO.deleteSubmission(id);
	}
	
	@PUT
	@Path("/submissions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Submission> updateSubmission(Submission submit) {
		return studentDAO.updateSubmission(submit);
	}

	@POST
	@Path("/registercourses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RegisterCourse createCourse(RegisterCourse rc) {
		return studentDAO.addCourse(rc);
	}
	
	@PUT
	@Path("/registercourses")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RegisterCourse updateCourse(RegisterCourse rc) {
		return studentDAO.deleteCourse(rc);
	}
}
