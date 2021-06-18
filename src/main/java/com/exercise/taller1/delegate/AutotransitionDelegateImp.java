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
	public void edit(long id, String name, String logicalOperand, String isActive) throws Exception {
		// TODO Auto-generated method stub
		Autotransition autotransitionDummy = findById(id);
		autotransitionDummy.setAutotranName(name);
		autotransitionDummy.setAutotranIsactive(isActive);
		autotransitionDummy.setAutotranLogicaloperand(logicalOperand);
		restTemplate.put( SERVER + "api/autotransitions", autotransitionDummy, Autotransition.class);

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
		
		Autotransition auto = restTemplate.getForObject(SERVER+"api/autotransitions/"+id, Autotransition.class); 
		return auto;
	}

	@Override
	public Iterable<FevInstitution> findAllFev() {
		FevInstitution[] insts = restTemplate.getForObject(SERVER+"api/fevInstitutions",FevInstitution[].class );
		List<FevInstitution> nueva = Arrays.asList(insts);
		
		return nueva;
	}

	@Override
	public void addFev(FevInstitution fevInstitution) {
		
		FevInstitution fev = restTemplate.postForObject( SERVER + "api/fevInstitutions", fevInstitution, FevInstitution.class);
		
	}

	@Override
	public FevInstitution findByIdFev(long id) {
		
		FevInstitution fev = restTemplate.getForObject(SERVER+"api/fevInstitutions/"+id, FevInstitution.class); 
		return fev;
	}

}
