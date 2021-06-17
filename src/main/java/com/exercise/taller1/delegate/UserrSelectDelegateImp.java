package com.exercise.taller1.delegate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Userselect;

@Component
public class UserrSelectDelegateImp implements UserrSelectDelegate {
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	
	public UserrSelectDelegateImp() {
		this.restTemplate = new RestTemplate();
	}	

	@Override
	public Userselect add(long idUsr, long idTrig) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Userselect edit(long id, String tableName, String valuekey, String valueUser, String statem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Userselect> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Userselect userselect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Userselect userselect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Userselect findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Triggerr findByIdTrigger(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
