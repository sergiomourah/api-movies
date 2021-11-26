package com.api.movie.entity;

import com.api.producer.entity.Producer;
import com.api.studio.entity.Studio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie implements Serializable{

	private static final long serialVersionUID = 7069165426507883340L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String title;
	
	@NotNull
	private int year;

	@NotNull
	private boolean winner;
	
	@JsonIgnore
	@OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
	private List<Studio> studios;
	
	@JsonIgnore
	@OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
	private List<Producer> producers;
}