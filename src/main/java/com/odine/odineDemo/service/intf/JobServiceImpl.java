package com.odine.odineDemo.service.intf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.stereotype.Service;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.dto.JobDto;
import com.odine.odineDemo.enums.FreelancerMapper;
import com.odine.odineDemo.enums.JobMapper;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.model.Job;
import com.odine.odineDemo.model.Language;
import com.odine.odineDemo.model.Specialties;
import com.odine.odineDemo.model.Tool;
import com.odine.odineDemo.repository.FreelancerRepository;
import com.odine.odineDemo.repository.JobRepository;
import com.odine.odineDemo.repository.LanguagesRepository;
import com.odine.odineDemo.repository.SpecialtiesRepository;
import com.odine.odineDemo.repository.ToolsRepository;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestCreateJob;
import com.odine.odineDemo.request.RequestGetJob;
import com.odine.odineDemo.request.RequestGetJobsOfFreelancer;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.request.RequestUpdateJob;
import com.odine.odineDemo.response.ResponseBaseApi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
	@Autowired
	JobRepository jobRepository;

	private final JobMapper jobMapper = JobMapper.INSTANCE;

	@Override
	public ResponseBaseApi createJob(RequestCreateJob request) {
		ResponseBaseApi response = new ResponseBaseApi();
		if (jobRepository.save(jobMapper.toJobEntity(request)) != null) {
			response.setSuccess(true);
			return response;
		}
		response.setSuccess(false);
		return response;
	}

	@Override
	public ResponseBaseApi updateJob(RequestUpdateJob request) {
		ResponseBaseApi response = new ResponseBaseApi();
		Optional<Job> job =jobRepository.findById(request.getId());
		job.get().setDescription(request.getDescription());
		job.get().setStatus(request.getStatus());
		if (jobRepository.save(job.get()) != null) {
			response.setSuccess(true);
			return response;
		}
		response.setSuccess(false);
		return response;
	}

	@Override
	public List<JobDto> getJobsOfFreelancer(Long request) {
		List<Job> freelancerJobs = jobRepository.findByFreelancerId(request);
		return freelancerJobs.stream().map(jobMapper::toJobDto).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public JobDto getJob(RequestGetJob request) {
		Optional<Job> job = jobRepository.findById(request.getId());
		if(job.get()!=null ) {
			return jobMapper.toJobDto(job.get());
		}
		return null;
	}
}
