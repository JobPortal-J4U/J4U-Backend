package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.security.Role;
import com.hostmdy.jobPortal.repository.RoleRepository;
import com.hostmdy.jobPortal.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;
	
	@Override
	public Optional<Role> findById(Long id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return (List<Role>) roleRepository.findAll();
	}

}
