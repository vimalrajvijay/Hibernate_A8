package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student(103, "MNO", 20);
		//Insert
		try {
			et.begin();
			em.persist(s1);
			et.commit();
		}catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
