package com.odine.odineDemo.request;

 

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateComment  {
	private Long jobId;
	private String commenterName;
	private Date createdDate;
	private String comment;
}
