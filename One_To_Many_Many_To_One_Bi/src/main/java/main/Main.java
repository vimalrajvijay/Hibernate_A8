package main;

import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Library;
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
		
		Book b1 = new Book();
		b1.setTitle("java");
		b1.setPrice(100);
		
		Book b2 = new Book();
		b2.setTitle("python");
		b2.setPrice(80);
		
		Book b3 = new Book();
		b3.setTitle("sql");
		b3.setPrice(50);
		
		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		Library l1 = new Library();
		l1.setName("Qspiders");
		
		l1.setBooks(books);
		b1.setLibrary(l1);
		b2.setLibrary(l1);
		b3.setLibrary(l1);
		
		try {
			et.begin();
			em.persist(b1);
			em.persist(b2);
			em.persist(b3);
			em.persist(l1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		
	}
}
