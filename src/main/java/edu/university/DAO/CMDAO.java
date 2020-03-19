/**
 * 
 */
package edu.university.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.university.Module.Course;
/**
 * @author rohan
 *
 */
public class CMDAO {
	private static CMDAO cmDAO;
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(edu.university.Module.Course.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public List<Course> getCourses() {
		return read();
	}

	public static CMDAO getCMDAO() {
		if (cmDAO == null) {
			cmDAO = new CMDAO();
			return cmDAO;
		} else
			return cmDAO;
	}

	public List<Course> addCourse(Course course) {
		create(course);
		return read();
	}

	public List<Course> deleteCourse(int id) {
		delete(id);
		return read();
	}

	public Course getCourse(int id) {
		return findByID(id);
	}

	public List<Course> updateCourse(Course course) {
		update(course);
		return read();
	}

	public static Integer create(Course c) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + c.toString());
		return c.getId();

	}
	
	public static List<Course> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Course> Courses = session.createQuery("FROM Course").list();
		session.close();
		System.out.println("Found " + Courses.size() + " Course");
		return Courses;
	}
	
	public static void update(Course c) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Course em = (Course) session.load(Course.class, c.getId());
		em.setName(c.getName());
		em.setLocation(c.getLocation());
		em.setCredits(c.getCredits());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + c.toString());
	}
	
	public static void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Course c = findByID(id);
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + c.toString());
	}

	public static Course findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Course c = (Course) session.get(Course.class, id);
		session.close();
		return c;
	}	
}
