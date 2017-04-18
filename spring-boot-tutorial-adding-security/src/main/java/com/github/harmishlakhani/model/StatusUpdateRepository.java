package com.github.harmishlakhani.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StatusUpdateRepository extends PagingAndSortingRepository<StatusUpdate, Long>{
	StatusUpdate findFirstByOrderByAddedDesc();
}
