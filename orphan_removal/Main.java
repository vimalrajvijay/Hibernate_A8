package orphan_removal;

import java.util.ArrayList;
import java.util.List;

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
		
		Car c1 = em.find(Car.class, 52);
//		Engine e1 = em.find(Engine.class, 52);
		
		try {
			et.begin();
			c1.setEngine(null);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		
//		Car c1 = new Car();
//		c1.setBrand("BMW");
//		c1.setPrice(10000);
//		
//		Engine e1 = new Engine();
//		e1.setHp(1200);
//		e1.setType("Petrol");
//		
//		c1.setEngine(e1);
//		
//		try {
//			et.begin();
//			em.persist(e1);
//			em.persist(c1);
//			et.commit();
//		} catch (Exception e) {
//			et.rollback();
//			e.printStackTrace();
//		}
	}
}
