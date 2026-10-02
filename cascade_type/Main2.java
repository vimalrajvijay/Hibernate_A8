package cascade_type;

import fetch_type.Car;
import fetch_type.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main2 {

	
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c1 = em.find(Car.class, 2);
		
		try {
			et.begin();
			em.remove(c1);// Engine also removed
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
//		e1.setType("Petrol");
//		e1.setHp(1200);
//		
//		c1.setEngine(e1);
//		
//		try {
//			et.begin();
//			em.persist(c1); Engine also persisted
//			et.commit();
//		} catch (Exception e) {
//			et.rollback();
//			e.printStackTrace();
//		}
	}
}
