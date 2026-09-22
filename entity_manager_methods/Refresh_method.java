package entity_manager_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import query_parameters.Employee;

public class Refresh_method {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e = em.find(Employee.class, 101);
		
		try {
			et.begin();
			e.setName("vimal");
			System.out.println(e.getName());
			em.refresh(e);// Object will be reloaded
			System.out.println(e.getName());
			et.commit();
		} catch (Exception e2) {
			et.rollback();
			e2.printStackTrace();
		}
		
	}
}
