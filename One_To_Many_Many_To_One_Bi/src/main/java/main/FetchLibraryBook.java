package main;

import entity.Book;
import entity.Library;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchLibraryBook {

	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		
//		Library l1 = em.find(Library.class, 2);
//		System.out.println(l1);
//		System.out.println(l1.getBooks());
		
		Book b1 = em.find(Book.class, 52);
		
		System.out.println(b1);
		System.out.println(b1.getLibrary());
	}
}
