/**
 * 
 */
package edu.university.Services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.university.DAO.TeacherDAO;
import edu.university.Module.Assignment;
import edu.university.Module.Submission;

@Path("/teacher")
public class TeacherService {
	private TeacherDAO teacherDAO = TeacherDAO.getCMDAO();

	@GET
	@Path("/assignments")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Assignment> getAssignments() {
		return teacherDAO.getAssignments();
	}
	
	@GET
	@Path("/submissions")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Submission> getSubmissions() {
		return teacherDAO.getSubmissions();
	}

	@POST
	@Path("/assignments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Assignment> createAssignment(Assignment assignment) {
		return teacherDAO.addAssignment(assignment);
	}

	@DELETE
	@Path("/assignments/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Assignment> deleteAssignment(@PathParam("id") int id) {
		return teacherDAO.deleteAssignment(id);
	}

	@PUT
	@Path("/assignments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Assignment> updateAssignment(Assignment assignment) {
		return teacherDAO.updateAssignment(assignment);
	}
	
	@PUT
	@Path("/submissions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Submission> updateSubmission(Submission submission) {
		return teacherDAO.updateSubmission(submission);
	}
}