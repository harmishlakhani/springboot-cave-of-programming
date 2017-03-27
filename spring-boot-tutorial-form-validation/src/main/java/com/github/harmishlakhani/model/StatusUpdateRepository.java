package com.github.harmishlakhani.model;

import org.springframework.data.repository.CrudRepository;

public interface StatusUpdateRepository extends CrudRepository<StatusUpdate, Long>{
	StatusUpdate findFirstByOrderByAddedDesc();
}
