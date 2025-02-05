package com.odine.odineDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.odine.odineDemo.model.Language;
import com.odine.odineDemo.model.Tool;

@RepositoryRestResource
public interface LanguagesRepository extends JpaRepository<Language, Long> {
	

}
