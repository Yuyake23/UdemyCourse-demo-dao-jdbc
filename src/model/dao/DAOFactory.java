package model.dao;

import model.dao.impl.SellerDAO_JDBC;
import model.entities.Seller;

public class DAOFactory {

	public static DAO<Seller> createSellerDAO() {
		return new SellerDAO_JDBC();
	}

}
