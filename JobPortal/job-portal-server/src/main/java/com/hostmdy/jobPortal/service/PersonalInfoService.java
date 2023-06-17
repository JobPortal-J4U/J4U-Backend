package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.PersonalInfo;

public interface PersonalInfoService {

	List<PersonalInfo> findPersonalInfo();

	Optional<PersonalInfo> findPersonalInfoById(Long id);

	PersonalInfo save(PersonalInfo personalInfo);

	void deletePersonalInfoById(Long id);
	
}
