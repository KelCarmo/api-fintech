package com.kcarmo.capgemini.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kcarmo.capgemini.domain.Client;
import com.kcarmo.capgemini.services.ClientService;

@RestController
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="client/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Client obj = clientService.findOne(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
