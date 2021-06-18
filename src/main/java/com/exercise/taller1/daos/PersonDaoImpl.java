package com.exercise.taller1.daos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.model.Person;

@Repository
@Scope("singleton")
public class PersonDaoImpl implements PersonDao{
	
	@PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Person save(Person entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public Person edit(Person entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Transactional
    @Override
    public void delete(Person entity) {
        entityManager.remove(entity);
    }

    @Transactional
    @Override
    public Person findById(long PersonId) {
        return entityManager.find(Person.class, PersonId);
    }

    @Transactional
    @Override
    public List<Person> findAll() {
        String consulta = "SELECT a FROM Person a";
        Query q = entityManager.createQuery(consulta);
        return q.getResultList();
    }
    
    @Transactional
    public void deleteAll(){
        entityManager.clear();
    }

}
