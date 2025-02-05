package com.odine.odineDemo.model;

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
@Table(name = "Job")
public class Job {
	@Id
	@Column(updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "FREELANCER_ID")
	private Long freelancerId;
	@Column(name = "JOB_STATUS")
	private String jobStatus;
	@Column(name = "DESCRIPTION")
	private String description;
 
 
	 
}
