package com.exercise.taller1.delegate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Triggertype;

@Component
public class TriggerTypeDelegateImp implements TriggerTypeDelegate {
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	
	public TriggerTypeDelegateImp() {
		this.restTemplate = new RestTemplate();
	}	

	

	@Override
	public Triggertype add(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Triggertype edit(BigDecimal instInstId, long trigtypeId, String trigtypeName) {
		// TODO Auto-generated method stub
		Triggertype triggerDummy = findById(trigtypeId);
		triggerDummy.setInstInstId(instInstId);
		triggerDummy.setTrigtypeName(trigtypeName);
		
		restTemplate.put(SERVER+"api/triggerstype", triggerDummy, Triggertype.class);
		
		return triggerDummy;
	}

	@Override
	public Triggertype findById(long id) {
		// TODO Auto-generated method stub
		
		Triggertype tgg = restTemplate.getForObject(SERVER+"api/triggerstype/"+id, Triggertype.class); 
		return tgg;
	}

	@Override
	public Triggertype save(Triggertype triggertype) {
		// TODO Auto-generated method stub
		Triggertype auto = restTemplate.postForObject( SERVER + "api/triggerstype", triggertype, Triggertype.class);

		return auto;
	}

	@Override
	public void delete(Triggertype triggertype) {
		// TODO Auto-generated method stub
		restTemplate.delete(SERVER + "api/triggerstype/"+ triggertype.getTrigtypeId());

	}



	@Override
	public Iterable<Triggertype> findAll() {
		// TODO Auto-generated method stub
		Triggertype[] tggs = restTemplate.getForObject(SERVER+"api/triggerstype",Triggertype[].class );
		List<Triggertype> nueva = Arrays.asList(tggs);
		
		return nueva;
	}

}
