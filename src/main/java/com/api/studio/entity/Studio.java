package com.api.studio.entity;

import com.api.movie.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Studio implements Serializable{

	private static final long serialVersionUID = -8760156722762939587L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;
	
	@ManyToOne
	@NotNull
	private Movie movie;
}