package com.hostmdy.jobPortal.domain.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.jobPortal.domain.Applications;
import com.hostmdy.jobPortal.service.ApplicationsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
public class ApplicationController {
	
	private final ApplicationsService applicationsService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody Applications applications){
		Applications savedApplication = applicationsService.save(applications);
		
		return new ResponseEntity<Applications>(savedApplication,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findAppicationById(@PathVariable Long id){
		Optional<Applications> applicationOpt = applicationsService.findById(id);
		
		if(applicationOpt.isEmpty())
			return new ResponseEntity<String>("Application not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Applications>(applicationOpt.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllCategories(){
		List<Applications> applicationList = applicationsService.findApplications();
		
		if(applicationList.isEmpty())
			return new ResponseEntity<String>("no application found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Applications>>(applicationList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteApplicationById(@PathVariable Long id) {
		
		applicationsService.deleteAppById(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	
	}

}
