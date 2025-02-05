package com.odine.odineDemo.enums;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.request.RequestCreateFreelancer;

@Mapper
public abstract class FreelancerMapper {
	
	public static final FreelancerMapper INSTANCE = Mappers.getMapper(FreelancerMapper.class);
	
	public abstract Freelancer toFreelancerEntity(RequestCreateFreelancer input);

}
