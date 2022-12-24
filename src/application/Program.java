package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DBException;
import model.SellerDAO;
import model.dao.DAOFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();

		System.out.println("==== TEST 1: seller findById ====");
		Seller sellerById = sellerDAO.findById(3);
		System.out.println(sellerById);

		System.out.println("\n==== TEST 2: seller findByDepartment");
		List<Seller> sellersByDepartment = sellerDAO.findByDepartment(new Department(2, null));
		for (Seller s : sellersByDepartment) {
			System.out.println(s);
		}

		System.out.println("\n==== TEST 3: seller findAll");
		List<Seller> sellersAll = sellerDAO.findAll();
		for (Seller s : sellersAll) {
			System.out.println(s);
		}

		System.out.println("\n==== TEST 4: seller insert");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000d, new Department(2, null));
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n==== TEST 5: seller update");
		Seller seller = sellerDAO.findById(4);
		seller.setName("Martha Waine");
		sellerDAO.update(seller);
		System.out.println("Update complete");

		System.out.println("\n==== TEST 6: seller delete");
		System.out.print("Enter id for delete test: ");
		try (Scanner sc = new Scanner(System.in)) {
			try {
				sellerDAO.deleteById(sc.nextInt());
				System.out.println("Delete complete");
			} catch (DBException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
