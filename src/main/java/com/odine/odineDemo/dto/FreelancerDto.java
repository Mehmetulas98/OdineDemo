package com.odine.odineDemo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerDto {
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String city;
	private String type;
	private String portfolioPageUrl;
	private List<ToolDto> designTools;
	private List<LanguageDto> softwareLanguages;
	private List<SpecialtiesDto> specialties;
	private Long evaluationScore;

}
