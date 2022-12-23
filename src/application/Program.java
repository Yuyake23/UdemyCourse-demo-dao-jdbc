package application;

import model.dao.DAO;
import model.dao.DAOFactory;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		DAO<Seller> sellerDAO = DAOFactory.createSellerDAO();

		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
	}

}
