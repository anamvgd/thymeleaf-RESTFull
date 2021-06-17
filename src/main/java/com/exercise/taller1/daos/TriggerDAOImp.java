package com.exercise.taller1.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Triggertype;

@Repository
@Scope("singleton")
public class TriggerDAOImp implements TriggerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public void save(Triggerr entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Transactional
	@Override
	public void edit(Triggerr entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Transactional
	@Override
	public void delete(Triggerr entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);		
	}

	@Transactional
	@Override
	public List<Triggerr> findByScope(String scope) {
		// TODO Auto-generated method stub
		String consult = "SELECT t FROM Triggerr t WHERE t.trigScope = :scope";
		Query query = entityManager.createQuery(consult);
		query.setParameter("scope", scope);
		return query.getResultList();
	}

	@Transactional
	@Override
	public List<Triggerr> findByName(String name) {
		// TODO Auto-generated method stub
		String consult = "SELECT t FROM Triggerr t WHERE t.trigName = :name";
		Query query = entityManager.createQuery(consult);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Transactional
	@Override
	public Triggerr findById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Triggerr.class, id);
	}

	@Transactional
	@Override
	public List<Triggerr> findByTriggerType(Triggertype trtype) {
		// TODO Auto-generated method stub
		long id = trtype.getTrigtypeId();
		String consult = "SELECT t FROM Triggerr t WHERE t.triggertype.trigtypeId = :id";
		Query query = entityManager.createQuery(consult);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Transactional
	@Override
	public List<Triggerr> findAll() {
		// TODO Auto-generated method stub
		String consult = "SELECT t FROM Triggerr t";
		return entityManager.createQuery(consult).getResultList();
	}

	@Transactional
	@Override
	public List<Triggertype> findTriggerrByScope() {
		// TODO Auto-generated method stub
		String scope = "L";
		String consult = "SELECT t.trigtypeName, t.count(*) FROM Triggertype t WHERE t.triggerrs in SELECT t FROM Triggerr t WHERE t.trigScope = :scope";
		Query query = entityManager.createQuery(consult);
		query.setParameter("scope", scope);
		return query.getResultList();
	}

	@Transactional
	@Override
	public List<Triggertype> findTriggerrByUserselect() {
		// TODO Auto-generated method stub
		String consult = "SELECT t  FROM Triggertype t where (SELECT u.count(*) FROM Userselect u WHERE u.usselValueusercolumn = 1) >= 2";
		Query query = entityManager.createQuery(consult);
		return query.getResultList();
	}

}
