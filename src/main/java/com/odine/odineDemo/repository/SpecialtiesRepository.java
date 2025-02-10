package com.odine.odineDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.odine.odineDemo.model.Specialties;
import com.odine.odineDemo.model.Tool;

@RepositoryRestResource
public interface SpecialtiesRepository extends JpaRepository<Specialties, Long> {
	
	List<Specialties> findByFreelancerId(Long freelancerID);

}
