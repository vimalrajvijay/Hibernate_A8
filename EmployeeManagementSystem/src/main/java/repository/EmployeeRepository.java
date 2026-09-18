package repository;

import entity.Employee;
import exception.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeRepository {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	
	public void addEmployee(Employee employee) {
		try {
			et.begin();
			em.persist(employee);
			et.commit();
			System.out.println("Employee is Saved");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
	
	public Employee getEmployee(int id) {
		Employee employee =  em.find(Employee.class, id);
		if(employee!=null)
			return employee;
		else
			throw new EmployeeNotFoundException("Employee is Not Found with id "+id);
	}
	
	public void updateEmployee(int id) {
		Employee employee = getEmployee(id);
		double existingSal = employee.getSalary();
		double newSal = existingSal + (existingSal*0.1);
		employee.setSalary(newSal);
		try {
			et.begin();
			em.merge(employee);
			et.commit();
			System.out.println("Employee is Updated");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {
		Employee employee = getEmployee(id);
		try {
			et.begin();
			em.remove(employee);
			et.commit();
			System.out.println("Employee is Deleted");
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
	}
}
