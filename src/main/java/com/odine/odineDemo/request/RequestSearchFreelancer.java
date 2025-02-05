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
public class RequestSearchFreelancer {
	private String name;
	private String city;
	private String type;
	private List<String> designTools;
	private List<String> specialties;
 
}
