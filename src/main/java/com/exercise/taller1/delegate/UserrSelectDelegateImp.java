package com.exercise.taller1.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Triggertype;
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
		Userselect userse = findById(id);
		userse.setUsselTablename(tableName);
		userse.setUsselValuekeycolumn(valuekey);
		userse.setUsselValueusercolumn(valueUser);
		userse.setUsselWherestatement(statem);
		
		restTemplate.put(SERVER+"api/userselects", userse, Userselect.class);
		
		return userse;
	}

	@Override
	public List<Userselect> findAll() {
		// TODO Auto-generated method stub
		Userselect[] tggs = restTemplate.getForObject(SERVER+"api/userselects",Userselect[].class );
		List<Userselect> nueva = Arrays.asList(tggs);
		
		return nueva;
	}

	@Override
	public void save(Userselect userselect) {
		// TODO Auto-generated method stub
		Userselect auto = restTemplate.postForObject( SERVER + "api/userselects", userselect, Userselect.class);

		
	}

	@Override
	public void delete(Userselect userselect) {
		// TODO Auto-generated method stub

		restTemplate.delete(SERVER + "api/userselects/"+ userselect.getUsselId());
		
	}

	@Override
	public Userselect findById(long id) {
		// TODO Auto-generated method stub
		Userselect tgg = restTemplate.getForObject(SERVER+"api/userselects/"+id, Userselect.class); 
		return tgg;
	}

}
