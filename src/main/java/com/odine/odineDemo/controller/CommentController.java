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
import com.odine.odineDemo.request.RequestCreateComment;
import com.odine.odineDemo.request.RequestUpdateComment;
import com.odine.odineDemo.response.ResponseBaseApi;
import com.odine.odineDemo.service.intf.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Comment Controller")
@RestController
@RequestMapping("/comment")
@Validated
@AllArgsConstructor
public class CommentController {

	@Autowired
	CommentService commentService;

	@Operation(summary = "Create New Comment")
	@PostMapping("/createComment")
	public ResponseEntity<ResponseBaseApi> createComment(@RequestBody(required = true) RequestCreateComment request) {
		return new ResponseEntity<>(commentService.createComment(request), HttpStatus.OK);
	}
	
	@Operation(summary = "Read Comments Of Job")
	@GetMapping("/readCommentsOfJob")
	public ResponseEntity<List<CommentDto>> getAllFreelancers(Long jobId) {
		return new ResponseEntity<>(commentService.readCommentsOfJob(jobId), HttpStatus.OK);
	}
	
	@Operation(summary = "Update Comment")
	@PostMapping("/updateComment")
	public ResponseEntity<ResponseBaseApi> updateComment(@RequestBody(required = true) RequestUpdateComment request) {
		return new ResponseEntity<>(commentService.updateComment(request), HttpStatus.OK);
	}

	 

}
