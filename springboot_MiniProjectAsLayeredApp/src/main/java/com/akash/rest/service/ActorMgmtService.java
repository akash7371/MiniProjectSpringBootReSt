package com.akash.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.rest.model.Actor;
import com.akash.rest.repo.ActorRepo;

@Service
public class ActorMgmtService implements IActorManagementService{

	@Autowired
	ActorRepo actorRepo;
	
	@Override
	public String registerActor(Actor actor) {
		
		Actor actor2 = actorRepo.save(actor);
		return "Actor is registered with id value: "+actor2.getActorId();
	}

	@Override
	public Iterable<Actor> fetchAllActors() {

		Iterable<Actor> actorList = actorRepo.findAll();
		List<Actor> list = (List<Actor>)actorList;
		list.sort((t1,t2) -> t1.getActorName().compareTo(t2.getActorName()));
		
		return list;
	}

	@Override
	public Actor getActorById(int id) {
		
		//Optional<Actor> actor = actorRepo.findById(id);
		return actorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public List<Actor> getActorByCategory(String cat1, String cat2) {
		
		return actorRepo.getActorsByCategory(cat1, cat2);
	}

}
