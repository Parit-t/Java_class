package com.gable.runma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gable.runma.model.Event;
import com.gable.runma.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService service;
	
	@GetMapping("/")
	public List<Event> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/")
	public Event newEvent (@RequestBody Event event) {
		return service.newEvent(event);	
	}
	
	@PutMapping("/{id}")
	public Event updateEvent (@RequestBody Event event){
		return null;// ned to insert something
	}
}

