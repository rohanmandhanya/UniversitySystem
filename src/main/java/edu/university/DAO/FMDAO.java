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
import edu.university.Module.Scholarship;

/**
 * @author rohan
 *
 */
public class FMDAO {

	private static FMDAO fmDAO; 
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(edu.university.Module.Course.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public static FMDAO getFMDAO() {
		if (fmDAO == null) {
			fmDAO = new FMDAO();
			return fmDAO;
		} else
			return fmDAO;
	}
	
	public List<Scholarship> getScholarships() {
		return read();
	}
	
	public List<Scholarship> addScholarship(Scholarship scholarship) {
		create(scholarship);
		return read();
	}

	public List<Scholarship> deleteScholarship(int id) {
		delete(id);
		return read();
	}

	public Scholarship getScholarship(int id) {
		return findByID(id);
	}

	public List<Scholarship> updateScholarship(Scholarship scholarship) {
		update(scholarship);
		return read();
	}
	
	public static Integer create(Scholarship c) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + c.toString());
		return c.getId();
	}
	
	public static List<Scholarship> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Scholarship> Scholarships = session.createQuery("FROM Scholarship").list();
		session.close();
		System.out.println("Found " + Scholarships.size() + " Scholarship");
		return Scholarships;
	}
	
	public static void update(Scholarship c) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Scholarship em = (Scholarship) session.load(Scholarship.class, c.getId());
		em.setScholarship(c.getScholarship());
		em.setStudent(c.getStudent());
		em.setType(c.getType());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + c.toString());
	}
	
	public static void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Scholarship c = findByID(id);
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + c.toString());
	}

	public static Scholarship findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Scholarship c = (Scholarship) session.get(Scholarship.class, id);
		session.close();
		return c;
	}
	
	
	public List<Course> addRate(Course rate) {
		updaterate(rate);
		return readcourse();
	}
	
	public List<Course> getRates() {
		return readcourse();
	}
	
	public static List<Course> readcourse() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Course> Courses = session.createQuery("FROM Course").list();
		session.close();
		System.out.println("Found " + Courses.size() + " Course");
		return Courses;
	}
	
	public static void updaterate(Course s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Course em = (Course) session.load(Course.class, s.getId());
		em.setRate(s.getRate());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + s.toString());
	}
}
