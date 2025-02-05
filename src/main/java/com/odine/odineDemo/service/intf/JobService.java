package com.odine.odineDemo.service.intf;

import java.util.List;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestCreateJob;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.response.ResponseBaseApi;

public interface JobService {
	
ResponseBaseApi createJob(RequestCreateJob request);
 

}
