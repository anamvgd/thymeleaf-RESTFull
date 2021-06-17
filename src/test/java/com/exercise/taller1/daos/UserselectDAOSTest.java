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
import org.springframework.transaction.annotation.Transactional;

import com.exercise.taller1.Taller1Application;
import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Userselect;

@SpringBootTest
@DirtiesContext
@ContextConfiguration(classes = {PersistenceContext.class, Taller1Application.class})
public class UserselectDAOSTest {
	
	@Autowired
	public UserSelectDAO userSelectDao;
	
	@Autowired
	public TriggerDAO triggerrDao;
	
	public Userselect userselect;
	
	void setup() {
		Triggerr triggerr = new Triggerr();
		triggerr.setTrigScope("L");
		triggerr.setTrigName("joseee");
		triggerrDao.save(triggerr);
		
		userselect = new Userselect();
		userselect.setTriggerr(triggerr);
		userselect.setUsselTablename("name");
		userselect.setUsselValuekeycolumn("1");
		userselect.setUsselValueusercolumn("2");
		userselect.setUsselWherestatement("jose");
	}
	
	@Test
	@Transactional
	void saveTest() {
		setup();
		userSelectDao.save(userselect);
		assertNotNull(userSelectDao.findById(userselect.getUsselId()));
	}
	
	@Test
	@Transactional
	void deleteTest() {
		setup();
		userSelectDao.save(userselect);
		assertNotNull(userSelectDao.findById(userselect.getUsselId()));
		userSelectDao.delete(userselect);
		assertNull(userSelectDao.findById(userselect.getUsselId()));
	}
	
	@Test
	@Transactional
	void editTest() {
		setup();
		userSelectDao.save(userselect);
		userselect.setUsselTablename("joseee");
		userSelectDao.edit(userselect);
		assertEquals("joseee", userSelectDao.findById(userselect.getUsselId()).getUsselTablename());
	}
	
	@Test
	@Transactional
	void findByIdTest() {
		setup();
		userSelectDao.save(userselect);
		assertEquals(userselect.getUsselId(), userSelectDao.findById(userselect.getUsselId()).getUsselId());
	}
	
	@Test
	@Transactional
	void findByNameTest() {
		setup();
		userSelectDao.save(userselect);
		assertNotNull(userSelectDao.findByName("name"));
	}
	
	@Test
	@Transactional
	void findByValuekeycolumnTest() {
		setup();
		userSelectDao.save(userselect);
		assertNotNull(userSelectDao.findByValuekeycolumn("1"));
	}
	
	@Test
	@Transactional
	void findByIdTriggerrTest() {
		setup();
		userSelectDao.save(userselect);
		assertEquals(userselect.getUsselId(), userSelectDao.findById(userselect.getUsselId()).getUsselId());
	}
}
