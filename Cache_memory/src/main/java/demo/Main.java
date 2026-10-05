package demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("vikas");
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
	
		
		Employee e1 = em1.find(Employee.class, 1);
		System.out.println(e1);
		Employee e2 = em1.find(Employee.class, 1);
		System.out.println(e2);
		
		Employee e3 = em2.find(Employee.class, 1);
		System.out.println(e3);
	}
}
