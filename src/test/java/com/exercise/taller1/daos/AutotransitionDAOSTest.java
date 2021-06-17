package com.exercise.taller1.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.Taller1Application;
import com.exercise.taller1.model.Autotransition;

@SpringBootTest
@DirtiesContext
@ContextConfiguration(classes = {PersistenceContext.class, Taller1Application.class})
public class AutotransitionDAOSTest {

	@Autowired
	public AutoTransitionDAO autotransitionDao;
	
	public Autotransition auto;
	
	void setup() {
		auto = new Autotransition();
		auto.setAutotranName("aqui");
		auto.setAutotranLogicaloperand("AND");
		auto.setAutotranIsactive("Y");
	}
	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void saveTest() {
		setup();
		autotransitionDao.save(auto);
		assertNotNull(autotransitionDao.findById(auto.getAutotranId()));
	}
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void editTest() {
		setup();
		autotransitionDao.save(auto);
		auto.setAutotranName("jose");
		autotransitionDao.edit(auto);
		assertEquals("jose", autotransitionDao.findById(auto.getAutotranId()).getAutotranName());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void deleteTest() {
		setup();
		autotransitionDao.save(auto);
		assertNotNull(autotransitionDao.findById(auto.getAutotranId()));
		autotransitionDao.delete(auto);
		assertNull(autotransitionDao.findById(auto.getAutotranId()));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByIdTest() {
		setup();
		autotransitionDao.save(auto);
		assertEquals(auto.getAutotranId(), autotransitionDao.findById(auto.getAutotranId()).getAutotranId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByNameTest() {
		setup();
		autotransitionDao.save(auto);
		assertNotNull(autotransitionDao.findByName("aqui"));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	protected void findByActiveTest() {
		setup();
		autotransitionDao.save(auto);
		assertNotNull(autotransitionDao.findByActive("Y"));
	}
	
}
