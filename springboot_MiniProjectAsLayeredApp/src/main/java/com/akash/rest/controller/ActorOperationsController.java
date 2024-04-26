package com.akash.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.akash.rest.model.Actor;
import com.akash.rest.service.IActorManagementService;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationsController {
	
	@Autowired
	IActorManagementService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveActor(@RequestBody Actor actor){
		
		return new ResponseEntity<String>(service.registerActor(actor), HttpStatus.CREATED);
			
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<?> fetchAllActors(){
		try {
			return new ResponseEntity<Iterable<Actor>>(service.fetchAllActors(), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getActorById(@PathVariable int id){
		try {
			return new ResponseEntity<Actor>(service.getActorById(id), HttpStatus.OK);
		}
		catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/category/{cat1}/{cat2}")
	public ResponseEntity<?> getActorByCategory(@PathVariable String cat1, @PathVariable String cat2){
		try {
			return new ResponseEntity<List<Actor>>(service.getActorByCategory(cat1, cat2), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
