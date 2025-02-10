package com.odine.odineDemo.enums;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.odine.odineDemo.dto.CommentDto;
import com.odine.odineDemo.dto.LanguageDto;
import com.odine.odineDemo.dto.SpecialtiesDto;
import com.odine.odineDemo.dto.ToolDto;
import com.odine.odineDemo.model.Comment;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.model.Language;
import com.odine.odineDemo.model.Specialties;
import com.odine.odineDemo.model.Tool;
import com.odine.odineDemo.request.RequestCreateComment;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestUpdateComment;

@Mapper
public abstract class SpecialtiesMapper {
	
	public static final SpecialtiesMapper INSTANCE = Mappers.getMapper(SpecialtiesMapper.class);
	
	
	public abstract SpecialtiesDto toSpecialtiesDto(Specialties input);
	
 

 
}
