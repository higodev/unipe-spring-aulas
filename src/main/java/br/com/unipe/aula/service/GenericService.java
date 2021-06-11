package br.com.unipe.aula.service;

import java.util.List;

public interface GenericService<T> {
	
	T findOne(final Long id);

	List<T> findAll();

	void create(T entity);

	void update(T entity);

	void delete(T entity);

	void deleteById(final Long entityId);

}
