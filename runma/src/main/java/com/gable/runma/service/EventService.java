package com.gable.runma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Event;
import com.gable.runma.model.RaceType;
import com.gable.runma.repository.EventRepository;
import com.gable.runma.repository.RaceTypeRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repo;
	@Autowired RaceTypeRepository rtRepo;
	
	public List<Event> findAll() {
		return repo.findAll();
	}
	
	public Event newEvent(Event event) {
		Event e = repo.save(event);
		//e.getId();
		for (RaceType rt : event.getRaceTypeList()) {
			rt.setEvent(event);rtRepo.save(rt);
		}
		return repo.save(event);
	}
	
	public Event update(Event uevent, int id) {
		return repo.findById(id)
			.map(x->{
				return repo.save(x);
			}).orElseGet(()->{
				throw new RuntimeException("Notfound Book");
			});
	}
}
