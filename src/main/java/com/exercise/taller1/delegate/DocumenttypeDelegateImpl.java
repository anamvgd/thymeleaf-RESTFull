package com.exercise.taller1.delegate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exercise.taller1.model.Documenttype;

@Component
public class DocumenttypeDelegateImpl implements DocumenttypeDelegate {

	private RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";

	public DocumenttypeDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Documenttype saveDocumenttype(long idDocumenttype, String nameDocumenttype, BigDecimal instId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDocumenttype(Documenttype doctype) {
		// TODO Auto-generated method stub
		Documenttype doc = restTemplate.postForObject(SERVER + "api/doctypes", doctype, Documenttype.class);
	}

	@Override
	public Documenttype editDocumenttype(long idDocumenttype, String nameDocumenttype, BigDecimal instId)
			throws RuntimeException {
		Documenttype modifiedDoctype = restTemplate.getForObject(SERVER+"api/doctypes/"+idDocumenttype, Documenttype.class);

		modifiedDoctype.setDoctypeName(nameDocumenttype);
		modifiedDoctype.setInstInstId(instId);

		restTemplate.put(SERVER+"api/doctypes", modifiedDoctype, Documenttype.class);

		return modifiedDoctype;

	}

	@Override
	public void delete(Documenttype doc) {
		restTemplate.delete(SERVER + "api/doctypes/" + doc.getDoctypeId());

	}

	@Override
	public Documenttype findById(long id) {
		Documenttype doc = restTemplate.getForObject(SERVER + "api/doctypes/" + id, Documenttype.class);
		return doc;
	}

	@Override
	public List<Documenttype> findAll() {
		Documenttype[] documents = restTemplate.getForObject(SERVER + "api/doctypes", Documenttype[].class);
		List<Documenttype> docs = Arrays.asList(documents);

		return docs;
	}

}
