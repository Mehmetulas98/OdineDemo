package com.odine.odineDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.odine.odineDemo.model.Tool;

@RepositoryRestResource
public interface ToolsRepository extends JpaRepository<Tool, Long> {

	List<Tool> findByFreelancerId(Long freelancerID);

 
	

}
