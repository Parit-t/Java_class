package com.gable.runma.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id"
		)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RaceType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double price;
	private String name;
	private Integer distance;
	private String prize;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	
	@OneToMany(mappedBy = "raceType")
	private List<Ticket> ticket;
}
