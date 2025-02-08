package com.odine.odineDemo.request;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateJob {
	private Long freelancerId;
	private String status;
	private String description;
	private Date createdDate;
	
 
}
