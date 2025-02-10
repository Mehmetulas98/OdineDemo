package com.odine.odineDemo.service.intf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.odine.odineDemo.dto.FreelancerDto;
import com.odine.odineDemo.dto.LanguageDto;
import com.odine.odineDemo.dto.SpecialtiesDto;
import com.odine.odineDemo.dto.ToolDto;
import com.odine.odineDemo.enums.FreelancerMapper;
import com.odine.odineDemo.enums.LanguagesMapper;
import com.odine.odineDemo.enums.SpecialtiesMapper;
import com.odine.odineDemo.enums.ToolMapper;
import com.odine.odineDemo.model.Freelancer;
import com.odine.odineDemo.model.Language;
import com.odine.odineDemo.model.Specialties;
import com.odine.odineDemo.model.Tool;
import com.odine.odineDemo.repository.FreelancerRepository;
import com.odine.odineDemo.repository.LanguagesRepository;
import com.odine.odineDemo.repository.SpecialtiesRepository;
import com.odine.odineDemo.repository.ToolsRepository;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.request.RequestGetSpecificFreelancer;
import com.odine.odineDemo.request.RequestSearchFreelancer;
import com.odine.odineDemo.response.ResponseBaseApi;
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
	private final ToolMapper toolMapper = ToolMapper.INSTANCE;
	private final LanguagesMapper languageMapper = LanguagesMapper.INSTANCE;
	private final SpecialtiesMapper specialtiesMapper = SpecialtiesMapper.INSTANCE;

	@Override
	public ResponseBaseApi createFreelancer(RequestCreateFreelancer request) {
		Freelancer savedFreelancer = freelancerMapper.toFreelancerEntity(request);
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

		CompletableFuture<String> future = evaluate(savedFreelancer, request);
		future.thenAccept(result -> {
			System.out.println(result);
		});

		return null;
	}

	public CompletableFuture<String> evaluate(Freelancer request, RequestCreateFreelancer requestCreateFreelancer) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.MINUTES.sleep(3);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			Optional<Freelancer> freelancer = freelancerRepository.findById(request.getId());

			if (request.getType().equals("Software Developer")) {
				freelancer.get().setEvaluationScore(Long.valueOf(requestCreateFreelancer.getSpecialties().size()
						* requestCreateFreelancer.getSoftwareLanguages().size()));
			} else if (request.getType().equals("Designer")) {
				freelancer.get().setEvaluationScore(Long.valueOf(requestCreateFreelancer.getDesignTools().size()));
			}

			freelancerRepository.save(freelancer.get());
			return "Ekleme tamamlandı!  : " + freelancer;
		});
	}

	@Override
	public List<FreelancerDto> getAllFreelancers() {
		List<Freelancer> freelancers = freelancerRepository.findAll();
		List<FreelancerDto> resultFreeelancers = freelancers.stream().map(freelancerMapper::toFreelancerDto)
				.collect(Collectors.toCollection(ArrayList::new));
		for (FreelancerDto freelancer : resultFreeelancers) {

			List<Tool> tools = toolsRepository.findByFreelancerId(freelancer.getId());
			List<ToolDto> toolDtos = tools.stream().map(toolMapper::toToolDto)
					.collect(Collectors.toCollection(ArrayList::new));
			freelancer.setDesignTools(toolDtos);

			List<Language> languages = languagesRepository.findByFreelancerId(freelancer.getId());
			List<LanguageDto> languageDtos = languages.stream().map(languageMapper::toLanguageDto)
					.collect(Collectors.toCollection(ArrayList::new));
			freelancer.setSoftwareLanguages(languageDtos);

			List<Specialties> specialties = specialtiesRepository.findByFreelancerId(freelancer.getId());
			List<SpecialtiesDto> specialtiesDtos = specialties.stream().map(specialtiesMapper::toSpecialtiesDto)
					.collect(Collectors.toCollection(ArrayList::new));
			freelancer.setSpecialties(specialtiesDtos);

		}
		return resultFreeelancers;
	}

	@Override
	public FreelancerDto getSpecificFreeLancer(RequestGetSpecificFreelancer request) {
		Freelancer freelancer = freelancerRepository
				.getByNameAndEmailAndPhoneAndCityAndTypeAndPortfolioPageUrlAndEvaluationScore(request.getName(),
						request.getEmail(), request.getPhone(), request.getCity(), request.getType(),
						request.getPortfolioPageUrl(), request.getEvaluationScore());
		List<Tool> tools = toolsRepository.findByFreelancerId(freelancer.getId());
		List<Specialties> specialties = specialtiesRepository.findByFreelancerId(freelancer.getId());
		List<Language> languages = languagesRepository.findByFreelancerId(freelancer.getId());
		tools.stream().allMatch(tool -> request.getDesignTools().contains(tool.getName()));
		if (tools.stream().allMatch(tool -> request.getDesignTools().contains(tool.getName()))
				&& tools.size() == request.getDesignTools().size()
				&& specialties.stream().allMatch(specialtie -> request.getSpecialties().contains(specialtie.getName()))
				&& specialties.size() == request.getSpecialties().size()
				&& languages.stream().allMatch(language -> request.getSoftwareLanguages().contains(language.getName()))
				&& languages.size() == request.getSoftwareLanguages().size()) {
			FreelancerDto dto = freelancerMapper.toFreelancerDto(freelancer);
			dto.setDesignTools(tools.stream().map(toolMapper::toToolDto)
					.collect(Collectors.toCollection(ArrayList::new)));
			dto.setSoftwareLanguages(languages.stream().map(languageMapper::toLanguageDto)
					.collect(Collectors.toCollection(ArrayList::new)));
			dto.setSpecialties(specialties.stream().map(specialtiesMapper::toSpecialtiesDto)
					.collect(Collectors.toCollection(ArrayList::new)));
			return dto;
		}
		return null;
	}

	@Override
	public List<FreelancerDto> searchFreelancer(RequestSearchFreelancer request) {
		List<Freelancer> freelancers = freelancerRepository.getByNameAndCityAndType(request.getName(),
				request.getCity(), request.getType());
		List<FreelancerDto> result = new ArrayList<FreelancerDto>();
		for (Freelancer freelancer : freelancers) {
			List<Tool> tools = toolsRepository.findByFreelancerId(freelancer.getId());
			List<Specialties> specialties = specialtiesRepository.findByFreelancerId(freelancer.getId());
			if (tools.stream().anyMatch(tool -> request.getDesignTools().contains(((Tool) tool).getName()))
					|| specialties.stream().anyMatch(
							specialtie -> request.getSpecialties().contains(((Specialties) specialtie).getName()))) {
				FreelancerDto dto = freelancerMapper.toFreelancerDto(freelancer);
				dto.setDesignTools(toolsRepository.findByFreelancerId(freelancer.getId()).stream()
						.map(toolMapper::toToolDto).collect(Collectors.toCollection(ArrayList::new)));
				dto.setSpecialties(specialtiesRepository.findByFreelancerId(freelancer.getId()).stream()
						.map(specialtiesMapper::toSpecialtiesDto).collect(Collectors.toCollection(ArrayList::new)));
				result.add(dto);
			}
		}
		return result;
	}
}
