package com.odine.odineDemo.service.intf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.enums.CommentMapper;
import com.odine.odineDemo.enums.FreelancerMapper;
import com.odine.odineDemo.enums.JobMapper;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.model.Language;
import com.odine.odineDemo.model.Specialties;
import com.odine.odineDemo.model.Tool;
import com.odine.odineDemo.repository.FreelancerRepository;
import com.odine.odineDemo.repository.JobRepository;
import com.odine.odineDemo.repository.LanguagesRepository;
import com.odine.odineDemo.repository.SpecialtiesRepository;
import com.odine.odineDemo.repository.ToolsRepository;
import com.odine.odineDemo.request.RequestCreateComment;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestCreateJob;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.response.ResponseBaseApi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	@Autowired
	JobRepository jobRepository;
	 
	
	private final CommentMapper jobMapper = CommentMapper.INSTANCE;
	@Override
	public ResponseBaseApi createComment(RequestCreateComment request) {  
          return null;
	}
}
