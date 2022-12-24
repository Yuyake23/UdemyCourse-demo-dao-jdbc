package model;

import java.util.List;

import model.dao.DAO;
import model.entities.Department;
import model.entities.Seller;

public interface SellerDAO extends DAO<Seller> {

	List<Seller> findByDepartment(Department department);

}
