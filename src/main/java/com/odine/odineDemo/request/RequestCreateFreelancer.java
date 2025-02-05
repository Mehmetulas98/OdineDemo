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
public class RequestCreateFreelancer {
	private String name;
	private String email;
	private String phone;
	private String city;
	private String type;
	private String portfolioPageUrl;
	private List<String> designTools;
	private List<String> softwareLanguages;
	private List<String> specialties;
	private Long evaluationScore;
}
