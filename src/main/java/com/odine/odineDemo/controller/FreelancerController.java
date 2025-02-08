package com.odine.odineDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.repository.FreelancerRepository;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.response.ResponseBaseApi;
import com.odine.odineDemo.service.intf.FreelancerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Freelancer Controller")
@RestController
@RequestMapping("/freelancer")
@Validated
@AllArgsConstructor
public class FreelancerController {

	@Autowired
	FreelancerService freelancerService;

	@Operation(summary = "Create New Freelancer")
	@PostMapping("/createFreelancer")
	public ResponseBaseApi createFreelancer(@RequestBody(required = true) RequestCreateFreelancer request) {
		freelancerService.createFreelancer(request);
		return null;
	}

	@Operation(summary = "Get All Freelancers")
	@GetMapping("/getAllFreelancers")
	public ResponseEntity<List<FreelancerDto>> getAllFreelancers() {
		return new ResponseEntity<>(freelancerService.getAllFreelancers(), HttpStatus.OK);
	}
	
	@Operation(summary = "Get a specific freelancer")
	@GetMapping("/getSpecificFreelancer")
	public ResponseEntity<FreelancerDto > getSpecificFreelancer() {
		return new ResponseEntity<>(freelancerService.getSpecificFreeLancer(), HttpStatus.OK);
	}

	@Operation(summary = "Search for a freelancer by name, city, freelancer type, design tools known\r\n"
			+ "and specialty.")
	@PostMapping("/searchFreelancer")
	public ResponseEntity<FreelancerDto> searchFreelancer(
			@RequestBody(required = true) RequestSearchFreelancer request) {
		return new ResponseEntity<>(freelancerService.searchFreelancer(request), HttpStatus.OK);
	}

}
