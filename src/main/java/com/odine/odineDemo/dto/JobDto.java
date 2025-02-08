package com.odine.odineDemo.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
	private Long id;
	private Long freelancerId;
	private Date createdDate;
	private String status;
	private String description;
}
