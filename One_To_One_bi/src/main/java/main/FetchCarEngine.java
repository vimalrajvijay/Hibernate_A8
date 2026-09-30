package main;

import entity.Car;
import entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchCarEngine {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
//		Car c = em.find(Car.class, 1);
//		System.out.println(c);
//		System.out.println(c.getEngine());
		
		Engine e = em.find(Engine.class, 1);
		System.out.println(e);
		System.out.println(e.getCar());
	}
}
