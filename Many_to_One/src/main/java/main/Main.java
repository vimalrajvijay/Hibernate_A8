package main;

import entity.Company;
import entity.Employee;
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
		
		Company c1 = new Company();
		c1.setName("Google");
		
		Employee e1 = new Employee();
		e1.setName("abc");
		e1.setSalary(10000);
		e1.setCompany(c1);
		
		Employee e2 = new Employee();
		e2.setName("mno");
		e2.setSalary(15000);
		e2.setCompany(c1);
		
		Employee e3 = new Employee();
		e3.setName("xyz");
		e3.setSalary(20000);
		e3.setCompany(c1);
		
		try {
			et.begin();
			em.persist(c1);
			em.persist(e1);
			em.persist(e2);
			em.persist(e3);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
