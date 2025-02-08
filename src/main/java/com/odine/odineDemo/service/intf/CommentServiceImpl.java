package com.odine.odineDemo.service.intf;

import java.util.ArrayList;
import java.util.List;
 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odine.odineDemo.dto.CommentDto;
  
import com.odine.odineDemo.enums.CommentMapper;
 
import com.odine.odineDemo.model.Comment;
import com.odine.odineDemo.repository.CommentRepository;
import com.odine.odineDemo.request.RequestCreateComment;
 
import com.odine.odineDemo.request.RequestUpdateComment;
import com.odine.odineDemo.response.ResponseBaseApi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository commentRepository;

	private final CommentMapper commentMapper = CommentMapper.INSTANCE;

	@Override
	public ResponseBaseApi createComment(RequestCreateComment request) {
		ResponseBaseApi response = new ResponseBaseApi();
		if (commentRepository.save(commentMapper.toCommentEntity(request)) != null) {
			response.setSuccess(true);
			return response;
		}
		response.setSuccess(false);
		return response;
	}

	@Override
	public List<CommentDto> readCommentsOfJob(Long jobId) {
		List<Comment> comments = commentRepository.findByJobId(jobId);
		return comments.stream().map(commentMapper::toCommentDto).collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public ResponseBaseApi updateComment(RequestUpdateComment request) {
		ResponseBaseApi response = new ResponseBaseApi();
		if (commentRepository.save(commentMapper.toCommentEntity(request)) != null) {
			response.setSuccess(true);
			return response;
		}
		response.setSuccess(false);
		return response;
	}
}
