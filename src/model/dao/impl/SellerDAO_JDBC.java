package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import model.dao.DAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDAO_JDBC implements DAO<Seller> {

	private Connection conn;

	public SellerDAO_JDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("""
					SELECT s.*, d.name as DepName
					FROM seller s JOIN department d
					ON s.departmentId = d.id
					WHERE s.id = ?;""");

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Department department = new Department(id, rs.getString("DepName"));
				Seller seller = new Seller();

				seller.setId(id);
				seller.setName(rs.getString("name"));
				seller.setEmail(rs.getString("email"));
				seller.setBaseSalary(rs.getDouble("baseSalary"));
				seller.setBirthDate(rs.getDate("birthDate"));
				seller.setDepartment(department);

				return seller;
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
//			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
