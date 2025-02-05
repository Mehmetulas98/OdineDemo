package com.odine.odineDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.model.Job;

@RepositoryRestResource
public interface JobRepository extends JpaRepository<Job, Long>{
	

}
