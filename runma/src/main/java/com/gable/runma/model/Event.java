package com.gable.runma.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data

public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String location;
	private String tag;
	@Temporal(TemporalType.DATE)
	private Date raceDate;
	@Temporal(TemporalType.DATE)
	private Date openRegisDate;
	@Temporal(TemporalType.DATE)
	private Date closeRegisDate;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<RaceType> raceTypeList;
	
	@ManyToMany
	@JoinTable(name = "Event_ORGANIZER", joinColumns = @JoinColumn(name ="event_id"),inverseJoinColumns = @JoinColumn(name = "organizer_id")) 
	private List<Organizer> organizerList;
}
