package com.hostmdy.jobPortal.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.hostmdy.jobPortal.domain.jobenum.Gender;
import com.hostmdy.jobPortal.domain.jobenum.Race;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class PersonalInfo {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String nrc;
	private String dateOfBirth;
	
	private String address;
	private String city;
	private String country;
	private String phone;
	
	private Race race;
	private Gender gender;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "personalInfo")
	private List<Education> educations;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "personalInfo")
	private List<Experiences> experiences ;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
}
