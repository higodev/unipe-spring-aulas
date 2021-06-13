package br.com.unipe.aula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.aula.dao.IGenericDAO;
import br.com.unipe.aula.model.Post;
import br.com.unipe.aula.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
  IGenericDAO<Post> dao;

  @Autowired
  public void setDao(IGenericDAO<Post> daoToSet) {
     dao = daoToSet;
     dao.setClazz(Post.class);
  }

	@Override
	public Post findOne(Long id) {
		return dao.findOne(id);
	}

	@Override
	public List<Post> findAll() {
		return dao.findAll();
	}

	@Override
	public void create(Post entity) {
		dao.create(entity);
	}

	@Override
	public void update(Post entity) {
		dao.update(entity);
	}

	@Override
	public void delete(Post entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteById(Long entityId) {
		dao.deleteById(entityId);
	}

}
