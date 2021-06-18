package com.exercise.taller1.delegate;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Documentt;
import com.exercise.taller1.model.Documenttype;
import com.exercise.taller1.model.Person;

@Component
public class DocumentDelegateImpl implements DocumentDelegate {

	private RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";
	
	public DocumentDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Documentt saveDocumentt(long idDocumentt, String nameDocumentt, long idDoctype, long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDocumentt(Documentt document) {
		// TODO Auto-generated method stub
		Documentt doc = restTemplate.postForObject( SERVER + "api/documents", document, Documentt.class);
	}

	@Override
	public Documentt editDocumentt(long idDocumentt, String newNameDocumentt, long idDoctype, long personId) throws RuntimeException{
		Documentt modifiedDoc = restTemplate.getForObject(SERVER+"api/documents/"+idDocumentt, Documentt.class);

		Person person = restTemplate.getForObject(SERVER+"api/persons/"+personId, Person.class);
		Documenttype docType = restTemplate.getForObject(SERVER+"api/docutype/"+idDoctype, Documenttype.class);;

		if (person == null) {
			throw new RuntimeException("No person - editDocumentt()");
		}
		if (docType == null) {
			throw new RuntimeException("No docutype - editDocumentt()");
		} 

		// newDocu.setDocId(idDocumentt);
		modifiedDoc.setDocName(newNameDocumentt);
		modifiedDoc.setPerson(person);
		modifiedDoc.setDocumenttype(docType);
		
		restTemplate.put(SERVER+"api/documents", modifiedDoc, Documentt.class);
		
		return modifiedDoc;

	}


	@Override
	public void delete(Documentt doc) {
		restTemplate.delete(SERVER + "api/documents/"+ doc.getDocId());

	}

	@Override
	public Documentt findById(long id) {
		Documentt doc = restTemplate.getForObject(SERVER+"api/documents/"+id, Documentt.class); 
		return doc;
	}

	@Override
	public Iterable<Documentt> findAll() {
		Documentt[] documents = restTemplate.getForObject(SERVER+"api/documents",Documentt[].class );
		Iterable<Documentt> docs = Arrays.asList(documents);
		
		return docs;
	}

}
