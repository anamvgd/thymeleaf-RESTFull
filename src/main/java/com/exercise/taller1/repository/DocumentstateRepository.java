package com.exercise.taller1.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exercise.taller1.model.Documentstate;import com.exercise.taller1.model.Documenttype;


@Repository
public interface DocumentstateRepository extends CrudRepository<Documentstate, Long>{

}
