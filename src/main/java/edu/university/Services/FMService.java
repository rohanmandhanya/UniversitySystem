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
import edu.university.DAO.FMDAO;
import edu.university.Module.Course;
import edu.university.Module.Scholarship;

@Path("/financialmanager")
public class FMService {


	private FMDAO fmDAO = FMDAO.getFMDAO();
	
	@GET
    @Path("/scholarships")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Scholarship> getScholarships() {
        return fmDAO.getScholarships();
    }
	
	@POST
    @Path("/scholarships")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Scholarship> createScholarship(Scholarship scholarship) {
        return fmDAO.addScholarship(scholarship);
    }

    @DELETE
    @Path("/scholarships/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Scholarship> deleteScholarship(@PathParam("id")int id){
        return fmDAO.deleteScholarship(id);
    }

    @PUT
    @Path("/scholarships")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Scholarship> updateScholarship(Scholarship scholarship){
        return fmDAO.updateScholarship(scholarship);
    }
    
    @GET
	@Path("/rates")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Course> getRates() {
		return fmDAO.getRates();
    }
    
    @PUT
	@Path("/rates")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Course> addRate(Course course) {
		return fmDAO.addRate(course);
	}
}
