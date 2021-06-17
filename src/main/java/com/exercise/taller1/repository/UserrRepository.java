package com.exercise.taller1.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.exercise.taller1.model.Userr;

@Repository
public interface UserrRepository extends CrudRepository<Userr, Long>{
	Optional<Userr> findByUserName(String username);
}