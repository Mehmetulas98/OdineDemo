package com.odine.odineDemo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {
	@Id
	@Column(updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "JOB_ID")
	private Long jobId;
	@Column(name = "COMMENTER_NAME")
	private String commenterName;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "COMMENT")
	private String comment;
 
 
	 
}
