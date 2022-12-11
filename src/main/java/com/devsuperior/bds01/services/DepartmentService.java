package com.devsuperior.bds01.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	private final DepartmentRepository repository;

	public DepartmentService(DepartmentRepository repository) {
		this.repository = repository;
	}

	public List<DepartmentDTO> findAll() {
		List<Department> list = repository.findAll(Sort.by("name"));
		return list.stream().map(d -> new DepartmentDTO(d)).toList();
	}
	
}
