package com.odine.odineDemo.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateComment {
	private Long freelancerId;
	private String jobStatus;
	private String description;
}
