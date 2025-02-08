package com.odine.odineDemo.service.intf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.enums.FreelancerMapper;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.model.Language;
import com.odine.odineDemo.model.Specialties;
import com.odine.odineDemo.model.Tool;
import com.odine.odineDemo.repository.FreelancerRepository;
import com.odine.odineDemo.repository.LanguagesRepository;
import com.odine.odineDemo.repository.SpecialtiesRepository;
import com.odine.odineDemo.repository.ToolsRepository;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.response.ResponseBaseApi;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {
	@Autowired
	FreelancerRepository freelancerRepository;
	@Autowired
	ToolsRepository toolsRepository;
	@Autowired
	LanguagesRepository languagesRepository;
	@Autowired
	SpecialtiesRepository specialtiesRepository;

	private final FreelancerMapper freelancerMapper = FreelancerMapper.INSTANCE;

	@Override
	public ResponseBaseApi createFreelancer(RequestCreateFreelancer request) {

		CompletableFuture<String> future = evaluate(request);
		future.thenAccept(result -> {
			System.out.println(result);
		});

		return null;
	}

	public CompletableFuture<String> evaluate(RequestCreateFreelancer request) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				// Simule edilen işlem süresi (örneğin 2 dakika)
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			Freelancer savedFreelancer = freelancerMapper.toFreelancerEntity(request);
			if (request.getType() == "Software Developer") {
				savedFreelancer.setEvaluationScore(
						Long.valueOf(request.getSpecialties().size() * request.getSoftwareLanguages().size()));
			} else {
				savedFreelancer.setEvaluationScore(Long.valueOf(request.getDesignTools().size()));
			}
			savedFreelancer = freelancerRepository.save(savedFreelancer);

			List<Tool> toolList = new ArrayList<>();
			for (String tools : request.getDesignTools()) {
				Tool tool = new Tool();
				tool.setName(tools);
				tool.setFreelancerId(savedFreelancer.getId());
				toolList.add(tool);
			}
			toolsRepository.saveAll(toolList);

			List<Language> languageList = new ArrayList<>();
			for (String tools : request.getSoftwareLanguages()) {
				Language language = new Language();
				language.setName(tools);
				language.setFreelancerId(savedFreelancer.getId());
				languageList.add(language);
			}
			languagesRepository.saveAll(languageList);

			List<Specialties> specialtiesList = new ArrayList<>();

			for (String tools : request.getSpecialties()) {
				Specialties language = new Specialties();
				language.setName(tools);
				language.setFreelancerId(savedFreelancer.getId());
				specialtiesList.add(language);
			}
			specialtiesRepository.saveAll(specialtiesList);

			return "Değerlendirme tamamlandı!";
		});
	}

	@Override
	public List<FreelancerDto> getAllFreelancers() {
		List<Freelancer> freelancers = freelancerRepository.findAll();
		// burada 
		//"designTools": null,
	   // "softwareLanguages": null,
	    //"specialties": null, 
	    
	    //bu kısımları çekmek ve liste olarak yansıtmak lazım
		return freelancers.stream().map(freelancerMapper::toFreelancerDto)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public FreelancerDto getSpecificFreeLancer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FreelancerDto searchFreelancer(RequestSearchFreelancer request) {
		// burada named query ile ara dönüş yap mapping yap
		return null;
		 
	}

	 

}
