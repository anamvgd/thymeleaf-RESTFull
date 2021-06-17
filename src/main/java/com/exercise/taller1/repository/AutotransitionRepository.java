package com.exercise.taller1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.exercise.taller1.model.Autotransition;

@Repository
public interface AutotransitionRepository extends CrudRepository<Autotransition, Long>{
}