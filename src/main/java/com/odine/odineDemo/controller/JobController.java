package com.odine.odineDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odine.odineDemo.dto.CommentDto;
import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.dto.JobDto;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.repository.FreelancerRepository;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestCreateJob;
import com.odine.odineDemo.request.RequestGetJob;
import com.odine.odineDemo.request.RequestGetJobsOfFreelancer;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.request.RequestUpdateJob;
import com.odine.odineDemo.response.ResponseBaseApi;
import com.odine.odineDemo.service.intf.FreelancerService;
import com.odine.odineDemo.service.intf.JobService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Job Controller")
@RestController
@RequestMapping("/job")
@Validated
@AllArgsConstructor
public class JobController {

	@Autowired
	JobService jobService;

	@Operation(summary = "Create New Job")
	@PostMapping("/createJob")
	public ResponseEntity<ResponseBaseApi> createJob(@RequestBody(required = true) RequestCreateJob request) {
		return new ResponseEntity<>(jobService.createJob(request), HttpStatus.OK);
	}

	@Operation(summary = "Get Jobs Of Freelancer")
	@GetMapping("/getJobsOfFreelancer")
	public ResponseEntity<List<JobDto>> getJobsOfFreelancer( Long freelancerId) {
		return new ResponseEntity<>(jobService.getJobsOfFreelancer(freelancerId), HttpStatus.OK);
	}

	@Operation(summary = "Get Job")
	@PostMapping("/getJob")
	public ResponseEntity<JobDto> getJob(@RequestBody(required = true) RequestGetJob request) {
		return new ResponseEntity<>(jobService.getJob(request), HttpStatus.OK);
	}

	@Operation(summary = "Update Job")
	@PostMapping("/updateJob")
	public ResponseEntity<ResponseBaseApi> updateJob(@RequestBody(required = true) RequestUpdateJob request) {
		return new ResponseEntity<>(jobService.updateJob(request), HttpStatus.OK);
	}
}
