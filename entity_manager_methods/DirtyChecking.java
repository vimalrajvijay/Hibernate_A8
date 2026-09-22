package entity_manager_methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import query_parameters.Employee;

public class DirtyChecking {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//Object will be in Managed State
		Employee e = em.find(Employee.class, 101);
		
		try {
			et.begin();
			e.setName("xyz");// Modification will be reflected
			et.commit();
		} catch (Exception e2) {
			et.rollback();
			e2.printStackTrace();
		}
	}
}
