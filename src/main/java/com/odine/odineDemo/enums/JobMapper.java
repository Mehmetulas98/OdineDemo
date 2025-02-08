package com.odine.odineDemo.enums;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.odine.odineDemo.dto.JobDto;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.model.Job;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestCreateJob;

@Mapper
public abstract class JobMapper {
	
	public static final JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);
	
	public abstract Job toJobEntity(RequestCreateJob input);
	
	public abstract JobDto toJobDto(Job input);

	
 
}
