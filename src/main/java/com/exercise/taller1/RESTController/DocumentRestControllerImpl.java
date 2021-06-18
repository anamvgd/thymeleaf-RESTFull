package com.exercise.taller1.RESTController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.taller1.model.Documentt;
import com.exercise.taller1.service.DocumentService;

@RestController
public class DocumentRestControllerImpl implements DocumentController{
	
	@Autowired
	public DocumentService docService;

	@Override
	@PutMapping("/api/documents")
	public Documentt edit(Documentt doc) throws Exception {
		// TODO Auto-generated method stub
		return docService.editDocumentt(doc.getDocId(), doc.getDocName(), doc.getDocumenttype().getDoctypeId(), doc.getPerson().getPersId());
	}

	@Override
	@PostMapping("/api/documents/adds")
	public Documentt add(@RequestBody Documentt doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/api/documents")
	public Iterable<Documentt> findAll() {
		// TODO Auto-generated method stub
		return docService.findAll();
	}

	@Override
	@PostMapping("/api/documents")
	public void save(@RequestBody Documentt document) {
		docService.saveDocumentt(document);
		
	}

	@Override
	@DeleteMapping("/api/documents/{id}")
	public void delete(long id) {
		docService.delete(docService.findById(id));
		
	}

	@Override
	@GetMapping("/api/documents/{id}")
	public Documentt findById(long id) {
		// TODO Auto-generated method stub
		return docService.findById(id);
	}

	
}
