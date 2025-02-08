package com.odine.odineDemo.service.intf;

import java.util.List;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.dto.JobDto;
import com.odine.odineDemo.model.Job;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestCreateJob;
import com.odine.odineDemo.request.RequestGetJob;
import com.odine.odineDemo.request.RequestGetJobsOfFreelancer;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.request.RequestUpdateJob;
import com.odine.odineDemo.response.ResponseBaseApi;

public interface JobService {

	ResponseBaseApi createJob(RequestCreateJob request);

	ResponseBaseApi updateJob(RequestUpdateJob request);

	List<JobDto> getJobsOfFreelancer(Long request);
	
	JobDto getJob(RequestGetJob request);

}
