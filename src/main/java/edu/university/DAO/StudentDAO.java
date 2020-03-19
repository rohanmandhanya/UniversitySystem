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
import edu.university.Module.RegisterCourse;
import edu.university.Module.Submission;

public class StudentDAO {

	private static StudentDAO studentDAO;

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(edu.university.student.Student.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public List<Assignment> getAssignments() {
		return readassign();
	}

	public static StudentDAO getStudentDAO() {
		if (studentDAO == null) {
			studentDAO = new StudentDAO();
			return studentDAO;
		} else
			return studentDAO;
	}
	
	public Submission getSubmissions(int id) {
		return findByID(id);
	}

	public List<Submission> addSubmission(Submission submit) {
		create(submit);
		return read();
	}

	public List<Submission> deleteSubmission(int id) {
		delete(id);
		return read();
	}


	public List<Submission> updateSubmission(Submission submit) {
		update(submit);
		return read();
	}

	public static Integer create(Submission s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + s.toString());
		return s.getId();
	}

	public static List<Assignment> readassign() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Assignment> Assignments = session.createQuery("FROM Assignment").list();
		session.close();
		System.out.println("Found " + Assignments.size() + " Students");
		return Assignments;
	}
	
	public static List<Submission> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Submission> Submissions = session.createQuery("FROM Submission").list();
		session.close();
		return Submissions;
	}

	public static void update(Submission s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Submission em = (Submission) session.load(Submission.class, s.getId());
		em.setAnswer(s.getAnswer());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + s.toString());
	}

	public static void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Submission s = findByID(id);
		session.delete(s);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + s.toString());

	}

	public static Submission findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Submission s = (Submission) session.get(Submission.class, id);
		s.getId();
		session.close();
		return s;
	}
	
	public RegisterCourse addCourse(RegisterCourse rc) {
		Integer id = createrc(rc);
		return Findbyid(id);
	}
	
	public RegisterCourse
	deleteCourse(RegisterCourse rc) {
		updaterc(rc);
		return Findbyid(rc.getId());
	}

	public static Integer createrc(RegisterCourse s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + s.toString());
		return s.getId();
	}
	
	public static void updaterc(RegisterCourse s) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		RegisterCourse em = (RegisterCourse) session.load(RegisterCourse.class, s.getId());
		em.setCourse1(s.getCourse1());
		em.setCourse2(s.getCourse2());
		em.setCourse3(s.getCourse3());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + s.toString());
	}
	
	public static RegisterCourse Findbyid(Integer id) {
		Session session = getSessionFactory().openSession();
		RegisterCourse s = (RegisterCourse) session.get(RegisterCourse.class, id);
		s.getId();
		session.close();
		return s;
	}
}
