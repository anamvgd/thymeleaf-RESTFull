package com.exercise.taller1.daos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.model.Documentt;
import com.exercise.taller1.model.Documenttype;

@Repository
@Scope("singleton")
public class DocumentTypeDaoImpl implements DocumentTypeDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public Documenttype save(Documenttype entity) {
		entityManager.persist(entity);
        return entity;
	}

	@Transactional
	@Override
	public Documenttype edit(Documenttype entity) {
		entityManager.merge(entity);
        return entity;
	}

	@Transactional
	@Override
	public void delete(Documenttype entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Transactional
	@Override
	public List<Documenttype> findAll() {
        String consulta = "SELECT d FROM Documenttype d";
        Query q = entityManager.createQuery(consulta);
        return q.getResultList();
	}
	
	@Transactional
    public void deleteAll(){
        entityManager.clear();
    }
	
	@Transactional
    @Override
    public Documenttype findById(long docId) {
        return entityManager.find(Documenttype.class, docId);
    }


}
