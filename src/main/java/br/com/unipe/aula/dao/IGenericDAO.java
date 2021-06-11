package br.com.unipe.aula.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {

	void setClazz(Class<T> clazzToSet);
	
	T findOne(final Long id);

	List<T> findAll();

	void create(T entity);

	void update(T entity);

	void delete(T entity);

	void deleteById(final Long entityId);
}
