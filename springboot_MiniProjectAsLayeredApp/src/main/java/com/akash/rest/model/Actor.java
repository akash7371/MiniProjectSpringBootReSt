package com.akash.rest.model;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REST_ACTOR")
public class Actor {

	@Id
	@GeneratedValue
	private Integer actorId;
	@Column(length = 20, nullable = false)
	private String actorName;
	@Column(length = 20)
	private String category;
	private Long mobileNumber;
}
