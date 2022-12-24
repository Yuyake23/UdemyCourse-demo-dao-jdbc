package application;

import java.util.List;
import java.util.Scanner;

import db.DBException;
import model.DepartmentDAO;
import model.dao.DAOFactory;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDAO departmentDAO = DAOFactory.creatDepartmentDAO();

		System.out.println("==== TEST 1: department findById ====");
		Department departmentByID = departmentDAO.findById(3);
		System.out.println(departmentByID);

		System.out.println("\n==== TEST 2: department findAll");
		List<Department> departmentAll = departmentDAO.findAll();
		for (Department s : departmentAll) {
			System.out.println(s);
		}

		System.out.println("\n==== TEST 3: department insert");
		Department newSeller = new Department(null, "Naris");
		departmentDAO.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n==== TEST 4: department update");
		Department department = departmentDAO.findById(newSeller.getId());
		department.setName("Nariz");
		departmentDAO.update(department);
		System.out.println("Update complete");

		System.out.println("\n==== TEST 5: department delete");
		System.out.print("Enter id for delete test: ");
		try (Scanner sc = new Scanner(System.in)) {
			try {
				departmentDAO.deleteById(sc.nextInt());
				System.out.println("Delete complete");
			} catch (DBException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
