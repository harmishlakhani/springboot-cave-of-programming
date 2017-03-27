package com.github.harmishlakhani.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.harmishlakhani.model.StatusUpdate;
import com.github.harmishlakhani.model.StatusUpdateRepository;

@Service
public class StatusUpdateService {

	@Autowired
	private StatusUpdateRepository statusUpdateRepository;
	
	public void save(StatusUpdate statusUpdate) {
		statusUpdateRepository.save(statusUpdate);
	}
	
	public StatusUpdate getLatest() {
		return statusUpdateRepository.findFirstByOrderByAddedDesc();
	}
}
