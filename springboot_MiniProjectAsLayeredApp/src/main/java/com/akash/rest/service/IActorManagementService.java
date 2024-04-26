package com.akash.rest.service;

import java.util.List;

import com.akash.rest.model.Actor;

public interface IActorManagementService {

	public String registerActor(Actor actor);
	
	public Iterable<Actor> fetchAllActors();
	
	public Actor getActorById(int id);
	
	public List<Actor> getActorByCategory(String cat1, String cat2);
}
