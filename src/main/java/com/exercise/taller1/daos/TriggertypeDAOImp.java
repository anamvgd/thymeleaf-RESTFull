package com.exercise.taller1.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.model.Triggertype;

@Repository
@Scope("singleton")
public class TriggertypeDAOImp implements TriggerTypeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public Triggertype findById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Triggertype.class, id);
	}

	

	@Transactional
	@Override
	public void save(Triggertype entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
		
	}
	
	@Transactional
	@Override
	public void edit(Triggertype entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
		
	}
	
	@Transactional
	@Override
	public void delete(Triggertype entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);		
		
	}


	@Transactional
	@Override
	public List<Triggertype> findAll() {
		// TODO Auto-generated method stub
		String consult = "SELECT t FROM Triggertype t";
		return entityManager.createQuery(consult).getResultList();
	}

}
