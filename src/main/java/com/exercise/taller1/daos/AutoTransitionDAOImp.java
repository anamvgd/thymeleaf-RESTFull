package com.exercise.taller1.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.model.Autotransition;

@Repository
@Scope("singleton")
public class AutoTransitionDAOImp implements AutoTransitionDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public void save(Autotransition entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Transactional
	@Override
	public void edit(Autotransition entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
		
	}
	

	@Transactional
	@Override
	public void delete(Autotransition entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
		
	}

	@Transactional
	@Override
	public Autotransition findById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Autotransition.class, id);
	}

	@Transactional
	@Override
	public List<Autotransition> findAll() {
		// TODO Auto-generated method stub
		String consult= "SELECT a FROM Autotransition a";
		return entityManager.createQuery(consult).getResultList();
	}

	@Transactional
	@Override
	public List<Autotransition> findByName(String name) {
		// TODO Auto-generated method stub
		String consult= "SELECT a FROM Autotransition a WHERE a.autotranName = :name";
		Query query = entityManager.createQuery(consult);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Transactional
	@Override
	public List<Autotransition> findByActive(String isActive) {
		// TODO Auto-generated method stub
		String consult= "SELECT a FROM Autotransition a WHERE a.autotranIsactive = :isActive";
		Query query = entityManager.createQuery(consult);
		query.setParameter("isActive", isActive);
		return query.getResultList();
	}

}
