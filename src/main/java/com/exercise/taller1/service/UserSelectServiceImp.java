package com.exercise.taller1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.taller1.daos.TriggerDAO;
import com.exercise.taller1.daos.UserSelectDAO;
import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Userselect;

@Service
public class UserSelectServiceImp implements UserSelectService {

	public TriggerDAO triggerDao;
	public UserSelectDAO userSelectDao;

	@Autowired
	public UserSelectServiceImp(TriggerDAO triggerDao,UserSelectDAO userSelectDao) {
		this.triggerDao = triggerDao;
		this.userSelectDao = userSelectDao;
	}

	@Override
	public Userselect add(long idUsr, long idTrig) {
		Triggerr trigg = triggerDao.findById(idTrig);
		Userselect userDummy = new Userselect();
		userDummy.setTriggerr(trigg);
		userDummy.setUsselId(idUsr);
		userDummy.setUsselTablename("Pepe");
		userDummy.setUsselValuekeycolumn("1");
		userDummy.setUsselValueusercolumn("1");
		userDummy.setUsselWherestatement("IDK");

		return userDummy;
	}

	@Override
	public Userselect edit(long id, String tableName, String valuekey, String valueUser, String statem) {
		Userselect userDummy = new Userselect();
		userDummy.setUsselId(id);
		userDummy.setUsselTablename(tableName);
		userDummy.setUsselValuekeycolumn(valuekey);
		userDummy.setUsselValueusercolumn(valueUser);
		userDummy.setUsselWherestatement(statem);

		return userDummy;
	}

	@Override
	public List<Userselect> findAll() {
		return userSelectDao.findAll();
	}

	@Override
	public void save(Userselect userselect) {
		userSelectDao.save(userselect);
	}

	@Override
	public void delete(Userselect userselect) {
		userSelectDao.delete(userselect);
	}

	@Override
	public Userselect findById(long id) {
		return userSelectDao.findById(id);
	}
	
	@Override
	public Triggerr findByIdTrigger(long id) {
		return userSelectDao.findByIdTrigger(id);
	}
}