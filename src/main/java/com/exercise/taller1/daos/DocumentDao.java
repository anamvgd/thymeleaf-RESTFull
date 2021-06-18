package com.exercise.taller1.daos;

import java.util.List;
import java.util.Optional;

import com.exercise.taller1.model.Documentt;

public interface DocumentDao {
	
	Documentt save(Documentt entity);
	Documentt edit(Documentt entity);
    void delete(Documentt entity);
    Documentt findById(long docId);
    List<Documentt> findAll();
    
    void deleteAll();
}
