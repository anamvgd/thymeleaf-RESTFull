package com.exercise.taller1.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.Taller1Application;
import com.exercise.taller1.model.Triggerr;

@SpringBootTest
@DirtiesContext
@ContextConfiguration(classes = {PersistenceContext.class, Taller1Application.class})
public class TriggerDAOSTest {

	@Autowired
	public TriggerDAO triggerDao;

	public Triggerr triggerr;

	void setup() {
		triggerr = new Triggerr();
		triggerr.setTrigScope("L");
		triggerr.setTrigName("joseee");
	}

	@Test
	@Transactional
	void saveTest() {
		setup();
		triggerDao.save(triggerr);
		assertNotNull(triggerDao.findByName("joseee"));
	}

	@Test
	@Transactional
	void deleteTest() {
		setup();
		triggerDao.save(triggerr);
		assertNotNull(triggerDao.findByName("joseee"));
		triggerDao.delete(triggerr);
		assertEquals(0, triggerDao.findByName("joseee").size());
	}

	@Test
	@Transactional
	void editTest() {
		setup();
		triggerDao.save(triggerr);
		triggerr.setTrigName("joseee");
		triggerDao.edit(triggerr);
		assertEquals("joseee", triggerDao.findByName(triggerr.getTrigName()).get(0).getTrigName());
	
	}

	@Test
	@Transactional
	void findByScopeTest() {
		setup();
		triggerDao.save(triggerr);
		assertNotNull(triggerDao.findByScope("L"));
		
	};

	@Test
	@Transactional
	void findByNameTest() {
		setup();
		triggerDao.save(triggerr);
		assertNotNull(triggerDao.findByName("joseee"));
	}

	@Test
	@Transactional
	void findAllTest() {
		setup();
		triggerDao.save(triggerr);
		assertNotNull(triggerDao.findAll());
	}
}
