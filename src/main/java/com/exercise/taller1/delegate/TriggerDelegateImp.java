package com.exercise.taller1.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.FevInstitution;
import com.exercise.taller1.model.Triggerr;

@Component
public class TriggerDelegateImp implements TriggerDelegate {

	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	
	public TriggerDelegateImp() {
		this.restTemplate = new RestTemplate();
	}	
	
	@Override
	public Triggerr add(long idAutotran, long idType, long idTrig) {
		return null;
	}

	@Override
	public Triggerr edit(long id, String name, String scope) {
		Triggerr triggerDummy = findById(id);
		triggerDummy.setTrigName(name);
		triggerDummy.setTrigScope(scope);
		
		restTemplate.put(SERVER+"api/triggers", triggerDummy, Triggerr.class);
		
		return triggerDummy;
	}

	@Override
	public Triggerr findById(long id) {
		Triggerr tgg = restTemplate.getForObject(SERVER+"api/triggers/"+id, Triggerr.class); 
		return tgg;
	}

	@Override
	public List<Triggerr> findAll() {
		Triggerr[] tggs = restTemplate.getForObject(SERVER+"api/triggers",Triggerr[].class );
		List<Triggerr> nueva = Arrays.asList(tggs);
		
		return nueva;
	}

	@Override
	public void save(Triggerr triggerr) {
		// TODO Auto-generated method stub
		Triggerr auto = restTemplate.postForObject( SERVER + "api/triggers", triggerr, Triggerr.class);

	}

	@Override
	public void delete(Triggerr triggerr) {
		// TODO Auto-generated method stub
		restTemplate.delete(SERVER + "api/triggers/"+ triggerr.getTrigId());
	}

}
