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


@Repository
@Scope("singleton")
public class DocumentDaoImpl implements DocumentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public Documentt save(Documentt entity) {
		entityManager.persist(entity);
        return entity;
	}

	@Transactional
	@Override
	public Documentt edit(Documentt entity) {
		entityManager.merge(entity);
        return entity;
	}

	@Transactional
	@Override
	public void delete(Documentt entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Transactional
	@Override
	public List<Documentt> findAll() {
        String consulta = "SELECT d FROM Documentt d";
        Query q = entityManager.createQuery(consulta);
        return q.getResultList();
	}
	
	@Transactional
    public void deleteAll(){
        entityManager.clear();
    }

	@Transactional
    @Override
    public Documentt findById(long docId) {
        return entityManager.find(Documentt.class, docId);
    }

}
