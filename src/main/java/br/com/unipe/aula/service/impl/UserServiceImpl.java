package br.com.unipe.aula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.aula.dao.IGenericDAO;
import br.com.unipe.aula.model.User;
import br.com.unipe.aula.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
  IGenericDAO<User> dao;

  @Autowired
  public void setDao(IGenericDAO<User> daoToSet) {
     dao = daoToSet;
     dao.setClazz(User.class);
  }

	@Override
	public User findOne(Long id) {
		return dao.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public void create(User entity) {
		dao.create(entity);
	}

	@Override
	public void update(User entity) {
		dao.update(entity);
	}

	@Override
	public void delete(User entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteById(Long entityId) {
		dao.deleteById(entityId);
	}
}