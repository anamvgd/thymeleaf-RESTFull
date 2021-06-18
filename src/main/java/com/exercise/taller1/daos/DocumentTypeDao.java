package com.exercise.taller1.daos;

import java.util.List;
import java.util.Optional;

import com.exercise.taller1.model.Documenttype;

public interface DocumentTypeDao {
	
	Documenttype save(Documenttype entity);
	Documenttype edit(Documenttype entity);
    void delete(Documenttype entity);
    Documenttype findById(long docId);
    List<Documenttype> findAll();
    
    void deleteAll();

}
