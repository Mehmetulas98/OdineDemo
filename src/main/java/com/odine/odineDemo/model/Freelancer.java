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
@Table(name = "Freelancer")
public class Freelancer {
	@Id
	@Column(updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "CITY")
	private String city;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "PORTFOLIO_PAGE_URL")
	private String portfolioPageUrl;
	@Column(name = "EVALUATION_SCORE")
	private Long evaluationScore;
 
	 
}
