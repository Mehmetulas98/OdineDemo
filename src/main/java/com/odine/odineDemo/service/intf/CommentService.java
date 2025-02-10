package com.odine.odineDemo.service.intf;
import java.util.List;
import com.odine.odineDemo.dto.CommentDto;
import com.odine.odineDemo.request.RequestCreateComment;
import com.odine.odineDemo.request.RequestUpdateComment;
import com.odine.odineDemo.response.ResponseBaseApi;

public interface CommentService {
	
ResponseBaseApi createComment(RequestCreateComment request);

List<CommentDto> readCommentsOfJob(Long request);
 
ResponseBaseApi updateComment(RequestUpdateComment request);


}
