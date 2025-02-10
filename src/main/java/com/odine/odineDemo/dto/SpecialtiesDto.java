package com.odine.odineDemo.dto;

 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialtiesDto {
	private Long id;
	private Long freelancerId;
	private String name;
}
