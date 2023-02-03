package com.gable.runma.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Event;
import com.gable.runma.model.Organizer;
import com.gable.runma.repository.EventRepository;
import com.gable.runma.repository.OrganizerRepository;

@Service
public class OrganizerService {
	
	@Autowired
	private OrganizerRepository repo;
	@Autowired
	private EventRepository evtRepo;

	public List<Organizer> findAll() {
		return repo.findAll();
	}

	public Organizer newOrganizer(Organizer org) {
		return repo.save(org);
	}

	public Organizer updateOrganizer(Organizer newOrg) {
		Organizer oldOrg = repo.findById(newOrg.getId()).orElseThrow();
		oldOrg.getEventList().clear();
		
		for (Event newEvent : newOrg.getEventList()) {
			Event oldEvent = evtRepo.findById(newEvent.getId()).orElseThrow();
			if (! oldEvent.getOrganizerList().contains(newOrg)) {
				oldOrg.getEventList().add(oldEvent);
				evtRepo.save(oldEvent);
			}
		}
		
		oldOrg.setContact(newOrg.getContact());
		oldOrg.setEmail(newOrg.getEmail());
		oldOrg.setFacebook(newOrg.getFacebook());
		oldOrg.setName(newOrg.getName());
		oldOrg.setWebsite(newOrg.getWebsite());
		
		repo.save(oldOrg);
		return oldOrg;
	}

}
