package com.mappingdemo.relationalmappingdemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Actors")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="actor_id")
	private int actorId;
	
	@Column(name="actor_name")
	private String actorName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "Actors_Movies",
			joinColumns = @JoinColumn(name="actor_id"),
			inverseJoinColumns = @JoinColumn(name="movie_id")
			)
	private List<Movie> movies;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public void addMovie(Movie movie) {
		if(movies==null)
			movies=new ArrayList<>();
		movies.add(movie);
		
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", movies=" + movies + "]";
	}
	
	
}
