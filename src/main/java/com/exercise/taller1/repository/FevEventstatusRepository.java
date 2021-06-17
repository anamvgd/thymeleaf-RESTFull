package com.exercise.taller1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.exercise.taller1.model.Eventstatus;

@Repository
public interface FevEventstatusRepository extends CrudRepository<Eventstatus, Long>{
}