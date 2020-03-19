/**
 * 
 */
package edu.university.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.university.Module.Assignment;
import edu.university.Module.Submission;


/**
 * @author rohan
 *
 */
public class TeacherDAO {
private static TeacherDAO teacherDAO;
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(edu.university.Module.Assignment.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public List<Assignment> getAssignments() {
		return read();
	}

	public static TeacherDAO getCMDAO() {
		if (teacherDAO == null) {
			teacherDAO = new TeacherDAO();
			return teacherDAO;
		} else
			return teacherDAO;
	}

	public List<Assignment> addAssignment(Assignment assignment) {
		create(assignment);
		return read();
	}

	public List<Assignment> deleteAssignment(int id) {
		delete(id);
		return read();
	}

	public Assignment getAssignment(int id) {
		return findByID(id);
	}

	public List<Assignment> updateAssignment(Assignment assignment) {
		update(assignment);
		return read();
	}
	
	public List<Submission> updateSubmission(Submission submit) {
		updatesub(submit);
		return readsub();
	}
	
	public List<Submission> getSubmissions() {
		return readsub();
	}


	public static Integer create(Assignment a) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + a.toString());
		return a.getAssign_id();

	}
	
	public static List<Assignment> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Assignment> Assignments = session.createQuery("FROM Assignment").list();
		session.close();
		System.out.println("Found " + Assignments.size() + " Assignment");
		return Assignments;
	}
	
	public static void update(Assignment a) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Assignment em = (Assignment) session.load(Assignment.class, a.getAssign_id());
		em.setCourse(a.getCourse());
		em.setPoints(a.getPoints());
		em.setType(a.getType());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + a.toString());
	}
	
	public static void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Assignment a = findByID(id);
		session.delete(a);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + a.toString());

	}
	
	public static List<Submission> readsub() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Submission> Submissions = session.createQuery("FROM Submission").list();
		session.close();
		return Submissions;
	}

	public static Assignment findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Assignment a = (Assignment) session.get(Assignment.class, id);
		session.close();
		return a;
	}
	
	public static void updatesub(Submission s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Submission em = (Submission) session.load(Submission.class, s.getId());
		em.setPoints(s.getPoints());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + s.toString());
	}
}
