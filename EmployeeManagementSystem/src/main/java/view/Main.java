package view;

import java.util.Scanner;

import entity.Employee;
import repository.EmployeeRepository;

public class Main {

	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Add Employee");
		System.out.print("Enter the option : ");
		int option = scanner.nextInt();
		
		switch (option) {
		case 1:
			System.out.print("Enter the ID         : ");
			int id = scanner.nextInt();
			System.out.print("Enter the name       : ");
			String name = scanner.next();
			System.out.print("Enter the salary     : ");
			Double salary = scanner.nextDouble();
			System.out.print("Enter the Department : ");
			String dept = scanner.next();
			Employee employee = new Employee(id, name, salary, dept);
			repository.addEmployee(employee);
			break;

		default:
			break;
		}
	}
}
