package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.Applications;

public interface ApplicationsService {

	List<Applications> findApplications();
	
	Optional<Applications> findById(Long id);
	
	Applications save(Applications applications);
	
	void deleteAppById(Long id);
}
