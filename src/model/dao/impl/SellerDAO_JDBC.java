package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DBException;
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

			if (rs.next())
				return instanciateSeller(rs, instanciateDepartment(rs));
			return null;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instanciateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();

		seller.setId(rs.getInt("id"));
		seller.setName(rs.getString("name"));
		seller.setEmail(rs.getString("email"));
		seller.setBaseSalary(rs.getDouble("baseSalary"));
		seller.setBirthDate(rs.getDate("birthDate"));
		seller.setDepartment(department);
		return seller;
	}

	private Department instanciateDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("id"), rs.getString("DepName"));
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
