package com.api.producer.entity;

import com.api.movie.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Producer implements Serializable{

	private static final long serialVersionUID = 3090575033217931606L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;
	
	@ManyToOne
	@NotNull
	private Movie movie;
}