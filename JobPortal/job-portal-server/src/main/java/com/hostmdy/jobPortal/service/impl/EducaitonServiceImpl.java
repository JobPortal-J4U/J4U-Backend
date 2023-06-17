package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.Education;
import com.hostmdy.jobPortal.repository.EducationRepository;
import com.hostmdy.jobPortal.service.EducationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducaitonServiceImpl implements EducationService{

	private final EducationRepository educationRepository;
	
	@Override
	public List<Education> findAll() {
		// TODO Auto-generated method stub
		return (List<Education>) educationRepository.findAll();
	}

	@Override
	public Optional<Education> findById(Long id) {
		// TODO Auto-generated method stub
		return educationRepository.findById(id);
	}

	@Override
	public Education saveEducation(Education education) {
		// TODO Auto-generated method stub
		return educationRepository.save(education);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		educationRepository.deleteById(id);
	}

}
