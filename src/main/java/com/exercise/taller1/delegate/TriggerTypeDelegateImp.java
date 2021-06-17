package com.exercise.taller1.delegate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Triggerr;

@Component
public class TriggerTypeDelegateImp implements TriggerDelegate {
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	
	public TriggerTypeDelegateImp() {
		this.restTemplate = new RestTemplate();
	}	

	@Override
	public Triggerr add(long idAutotran, long idType, long idTrig) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Triggerr edit(long idInstitution, String name, String scope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Triggerr findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Triggerr> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Triggerr triggerr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Triggerr triggerr) {
		// TODO Auto-generated method stub
		
	}

}
