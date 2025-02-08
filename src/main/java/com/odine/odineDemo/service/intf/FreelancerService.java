package com.odine.odineDemo.service.intf;

import java.util.List;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.response.ResponseBaseApi;

public interface FreelancerService {
	
ResponseBaseApi createFreelancer(RequestCreateFreelancer request);
	
	List<FreelancerDto> getAllFreelancers();
	
	 FreelancerDto getSpecificFreeLancer();
	
	 FreelancerDto searchFreelancer(RequestSearchFreelancer request);

}
