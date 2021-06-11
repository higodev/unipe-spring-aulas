package br.com.unipe.aula.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public abstract class AbstractJpaDAO<T extends Serializable> {

	private Class<T> clazz;

	@PersistenceContext
	private EntityManager entityManager;

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Transactional(readOnly=true)
	public T findOne(Long id) {
		return entityManager.find(clazz, id);
	}

	@Transactional(readOnly=true)
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	@Transactional(readOnly=false)
	public void create(T entity) {
		entityManager.persist(entity);
	}

	@Transactional(readOnly=false)
	public void update(T entity) {
		entityManager.merge(entity);
	}

	@Transactional(readOnly=false)
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Transactional(readOnly=false)
	public void deleteById(Long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}
