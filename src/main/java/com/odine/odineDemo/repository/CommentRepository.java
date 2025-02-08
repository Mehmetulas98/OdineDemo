package com.odine.odineDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.odine.odineDemo.dto.CommentDto;
import com.odine.odineDemo.model.Comment;
import com.odine.odineDemo.model.Freelancer;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByJobId(Long jobId);
	  
	 
	
}
