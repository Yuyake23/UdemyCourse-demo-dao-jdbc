package model.dao;

import java.util.List;

public interface DAO<T> {

	void insert(T obj);

	void update(T obj);

	T findById(Integer id);

	List<T> findAll();

}
