package com.odine.odineDemo.enums;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.request.RequestCreateFreelancer;

@Mapper
public abstract class CommentMapper {
	
	public static final CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
	
 
}
