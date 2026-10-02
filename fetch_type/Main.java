package fetch_type;

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
		
//		Car c1 = em.find(Car.class, 1);
//		System.out.println(c1);
		
		Library l1 = em.find(Library.class, 1);
		//List<Book> books = l1.getBooks();
		
		System.out.println(l1);
		//System.out.println(books);
	}
}
