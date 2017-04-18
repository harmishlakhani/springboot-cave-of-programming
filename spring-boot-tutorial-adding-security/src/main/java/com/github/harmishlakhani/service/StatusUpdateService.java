package com.github.harmishlakhani.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.github.harmishlakhani.model.StatusUpdate;
import com.github.harmishlakhani.model.StatusUpdateRepository;

@Service
public class StatusUpdateService {

	private static final int PAGESIZE = 10;
	
	@Autowired
	private StatusUpdateRepository statusUpdateRepository;
	
	public void save(StatusUpdate statusUpdate) {
		statusUpdateRepository.save(statusUpdate);
	}
	
	public StatusUpdate getLatest() {
		return statusUpdateRepository.findFirstByOrderByAddedDesc();
	}
	
	public Page<StatusUpdate> getPage(int pageNumber) {
		PageRequest pageable = new PageRequest(pageNumber - 1, PAGESIZE, Direction.DESC, "added");
		return statusUpdateRepository.findAll(pageable);
	}

	public void delete(Long id) {
		statusUpdateRepository.delete(id);
	}

	public StatusUpdate get(Long id) {
		return statusUpdateRepository.findOne(id);
	}
}
