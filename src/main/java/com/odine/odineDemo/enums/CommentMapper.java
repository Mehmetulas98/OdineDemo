package com.odine.odineDemo.enums;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.odine.odineDemo.dto.CommentDto;
import com.odine.odineDemo.model.Comment;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.request.RequestCreateComment;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestUpdateComment;

@Mapper
public abstract class CommentMapper {
	
	public static final CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
	
	
	public abstract Comment toCommentEntity(RequestCreateComment input);
	
	public abstract Comment toCommentEntity(RequestUpdateComment input);
	
	public abstract CommentDto toCommentDto(Comment input);

 
}
