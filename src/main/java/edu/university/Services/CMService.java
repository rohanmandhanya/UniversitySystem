/**
 * 
 */
package edu.university.Services;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import edu.university.DAO.CMDAO;
import edu.university.Module.Course;

@Path("/coursemanager")
public class CMService {

	private CMDAO cmDAO = CMDAO.getCMDAO();
	
	@GET
    @Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses() {
        return cmDAO.getCourses();
    }
	
	@POST
    @Path("/courses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> createCourse(Course course) {
        return cmDAO.addCourse(course);
    }

    @DELETE
    @Path("/courses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> deleteCourse(@PathParam("id")int id){
        return cmDAO.deleteCourse(id);
    }

    @PUT
    @Path("/courses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> updateCourse(Course course){
        return cmDAO.updateCourse(course);
    }
}
