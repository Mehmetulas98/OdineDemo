package com.odine.odineDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.model.Freelancer;

@RepositoryRestResource
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> ,JpaSpecificationExecutor<Freelancer>{

	List<Freelancer> getByNameAndCityAndType(String name, String city, String type);

	Freelancer getByNameAndEmailAndPhoneAndCityAndTypeAndPortfolioPageUrlAndEvaluationScore(String name, String email,String phone,String city,String type,String portfolioPageUrl,Long evaluationScore);
	

}
