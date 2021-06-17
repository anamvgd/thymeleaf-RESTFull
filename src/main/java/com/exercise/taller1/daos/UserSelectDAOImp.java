package com.exercise.taller1.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Userselect;

@Repository
@Scope("singleton")
public class UserSelectDAOImp implements UserSelectDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Userselect entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	@Transactional
	public void edit(Userselect entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	@Transactional
	public void delete(Userselect entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	@Transactional
	public Triggerr findByIdTrigger(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Triggerr.class, id);
	}

	@Override
	@Transactional
	public Userselect findById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Userselect.class, id);
	}

	@Override
	@Transactional
	public List<Userselect> findByName(String name) {
		// TODO Auto-generated method stub
		String consult = "SELECT u FROM Userselect u WHERE u.usselTablename = :name";
		Query query = entityManager.createQuery(consult);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Userselect> findByValuekeycolumn(String usselValuekeycolumn) {
		// TODO Auto-generated method stub
		String consult = "SELECT u FROM Userselect u WHERE u.usselValuekeycolumn = :usselValuekeycolumn";
		Query query = entityManager.createQuery(consult);
		query.setParameter("usselValuekeycolumn", usselValuekeycolumn);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Userselect> findAll() {
		// TODO Auto-generated method stub
		String consult= "SELECT u FROM Userselect u";
		return entityManager.createQuery(consult).getResultList();
	}

}
