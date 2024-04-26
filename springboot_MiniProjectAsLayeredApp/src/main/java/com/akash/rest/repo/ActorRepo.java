package com.akash.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.akash.rest.model.Actor;

import jakarta.transaction.Transactional;

public interface ActorRepo extends JpaRepository<Actor, Integer>{

	@Transactional
	@Query(value = "select * from REST_ACTOR where category in (:c1, :c2) order by category", nativeQuery = true)
	public List<Actor> getActorsByCategory(@Param("c1") String category1, @Param("c2") String category2);
}
