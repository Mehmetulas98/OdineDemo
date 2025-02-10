package com.odine.odineDemo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.odine.odineDemo.request.RequestCreateComment;
import com.odine.odineDemo.response.ResponseBaseApi;
import com.odine.odineDemo.service.intf.CommentService;
 
@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {

	@Mock
	CommentService commentService;
	@InjectMocks 
	private CommentController commentController;

	@Test
	void createComment_Success() {
		RequestCreateComment request = new RequestCreateComment();
 		request.setJobId(1L);
		request.setCommenterName("Aydın");
		// Diğer alanlar setlenmedi
		ResponseEntity<ResponseBaseApi> response = commentController.createComment(request);
 		verify(commentService, times(1)).createComment(request);
		assertNotNull(response);  
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
