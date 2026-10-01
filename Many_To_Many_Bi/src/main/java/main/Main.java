package main;

import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c1 = new Course();
		c1.setCourseName("java");
		c1.setPrice(10000);
		
		Course c2 = new Course();
		c2.setCourseName("python");
		c2.setPrice(8000);
		
		Course c3 = new Course();
		c3.setCourseName("sql");
		c3.setPrice(5000);
		
		Student s1 = new Student();
		s1.setName("ABC");
		s1.setAge(21);
		
		Student s2 = new Student();
		s2.setName("XYZ");
		s2.setAge(22);
		
		Student s3 = new Student();
		s3.setName("MNO");
		s3.setAge(23);
		
		List<Course> courses1 = new ArrayList<>();
		courses1.add(c2);
		courses1.add(c3);
		
		List<Course> courses2 = new ArrayList<>();
		courses2.add(c1);
		courses2.add(c2);
		
		List<Course> courses3 = new ArrayList<>();
		courses3.add(c1);
		courses3.add(c3);
		
		List<Student> students1 = new ArrayList<>();
		students1.add(s2);
		students1.add(s3);
		
		List<Student> students2 = new ArrayList<>();
		students2.add(s1);
		students2.add(s2);
		
		List<Student> students3 = new ArrayList<>();
		students3.add(s1);
		students3.add(s3);
		
		s1.setCourses(courses1);
		s2.setCourses(courses2);
		s3.setCourses(courses3);
		
		c1.setStudents(students1);
		c2.setStudents(students2);
		c3.setStudents(students3);
		
		
		try {
			et.begin();
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(s1);
			em.persist(s2);
			em.persist(s3);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
