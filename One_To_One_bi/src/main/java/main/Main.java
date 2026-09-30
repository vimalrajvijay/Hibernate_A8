package main;

import entity.Car;
import entity.Engine;
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
		
		Car c1 = new Car();
		c1.setBrand("BMW");
		c1.setPrice(10000);
		
		Engine e1 = new Engine();
		e1.setType("petrol");
		e1.setHp(1200);
		
		c1.setEngine(e1);
		e1.setCar(c1);
		
		try {
			et.begin();
			em.persist(e1);
			em.persist(c1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
