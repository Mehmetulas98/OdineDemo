package com.odine.odineDemo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.odine.odineDemo.controller.FreelancerController;
import com.odine.odineDemo.dto.JobDto;
import com.odine.odineDemo.enums.JobMapper;
import com.odine.odineDemo.model.Job;
import com.odine.odineDemo.repository.JobRepository;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestCreateJob;
import com.odine.odineDemo.response.ResponseBaseApi;
import com.odine.odineDemo.service.intf.FreelancerService;
import com.odine.odineDemo.service.intf.JobService;
import com.odine.odineDemo.service.intf.JobServiceImpl;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

	@Mock
	JobRepository jobRepository;
	@InjectMocks
	private JobServiceImpl jobService;

	@Test
	void getJobsOfFreelancer_Success() {
		List<Job> repositoryResponse = new ArrayList<Job>();
		Job job = new Job();
		job.setFreelancerId(1L);
		repositoryResponse.add(job);
		when(jobRepository.findByFreelancerId(Mockito.anyLong())).thenReturn(repositoryResponse);
		List<JobDto> response = jobService.getJobsOfFreelancer(1L);
		assertNotNull(response);	 
	}
}
