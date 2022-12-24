package model.dao;

import db.DB;
import model.SellerDAO;
import model.dao.impl.SellerDAO_JDBC;

public class DAOFactory {

	public static SellerDAO createSellerDAO() {
		return new SellerDAO_JDBC(DB.getConnection());
	}

}
