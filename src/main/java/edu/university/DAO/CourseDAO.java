package edu.university.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.university.Module.Course;

public class CourseDAO {
	private static CourseDAO courseDAO;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(edu.university.Module.Course.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public List<Course> getCourses() {
		return read();
	}

	public Course getCourse(Integer id) {
		return findByID(id);
	}

	public static CourseDAO getCourseDAO() {
		if (courseDAO == null) {
			courseDAO = new CourseDAO();
			return courseDAO;
		} else
			return courseDAO;
	}

	public static List<Course> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Course> Courses = session.createQuery("FROM Course").list();
		session.close();
		System.out.println("Found " + Courses.size() + " Course");
		return Courses;
	}

	public static Course findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Course c = (Course) session.get(Course.class, id);
		session.close();
		return c;
	}
}
