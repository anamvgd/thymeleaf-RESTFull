package com.exercise.taller1.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.FevInstitution;

@Component
public class AutotransitionDelegateImp implements AutotransitionDelegate{
	
	private RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/";
	
	
	public AutotransitionDelegateImp() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Autotransition edit(long id, String name, String logicalOperand, String isActive) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autotransition add(long idInstitution, long idEventStatus) {
		
		/*Autotransition autotransitionDummy = new Autotransition();
		autotransitionDummy.setAutotranName("Mili");
		autotransitionDummy.setAutotranIsactive("Y");
		autotransitionDummy.setAutotranLogicaloperand("AND");
		
		Autotransition auto = restTemplate.postForObject( SERVER + "api/autotransitions", autotransitionDummy, Autotransition.class);
		*/
		return null;
	}

	@Override
	public List<Autotransition> findAll() {
		Autotransition[] autos = restTemplate.getForObject(SERVER+"api/autotransitions",Autotransition[].class );
		List<Autotransition> nueva = Arrays.asList(autos);
		
		return nueva;
	}

	@Override
	public void save(Autotransition autotransition) {
		
		Autotransition auto = restTemplate.postForObject( SERVER + "api/autotransitions", autotransition, Autotransition.class);
		
	}

	@Override
	public void delete(Autotransition autotransition) {
		
		restTemplate.delete(SERVER + "api/autotransitions/"+ autotransition.getAutotranId());
		
	}

	@Override
	public Autotransition findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<FevInstitution> findAllFev() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(FevInstitution fevInstitution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FevInstitution findByIdFev(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
