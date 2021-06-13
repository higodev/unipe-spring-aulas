package br.com.unipe.aula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unipe.aula.dao.IGenericDAO;
import br.com.unipe.aula.model.PostComment;
import br.com.unipe.aula.service.PostCommentService;

@Service
public class PostCommentServiceImpl implements PostCommentService {
	
  IGenericDAO<PostComment> dao;

  @Autowired
  public void setDao(IGenericDAO<PostComment> daoToSet) {
     dao = daoToSet;
     dao.setClazz(PostComment.class);
  }

	@Override
	public PostComment findOne(Long id) {
		return dao.findOne(id);
	}

	@Override
	public List<PostComment> findAll() {
		return dao.findAll();
	}

	@Override
	public void create(PostComment entity) {
		dao.create(entity);
	}

	@Override
	public void update(PostComment entity) {
		dao.update(entity);
	}

	@Override
	public void delete(PostComment entity) {
		dao.delete(entity);
	}

	@Override
	public void deleteById(Long entityId) {
		dao.deleteById(entityId);
	}

}
