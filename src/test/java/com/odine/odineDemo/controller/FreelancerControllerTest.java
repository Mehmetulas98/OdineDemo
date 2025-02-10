package com.odine.odineDemo.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.odine.odineDemo.controller.FreelancerController;
import com.odine.odineDemo.request.RequestCreateFreelancer;
import com.odine.odineDemo.response.ResponseBaseApi;
import com.odine.odineDemo.service.intf.FreelancerService;

@ExtendWith(MockitoExtension.class)
public class FreelancerControllerTest {

	@Mock
	FreelancerService freelancerService;
	@InjectMocks 
	private FreelancerController freelancerController;

	@Test
	void createFreelancer_Success() {
		RequestCreateFreelancer request = new RequestCreateFreelancer();
 		request.setName("Mehmet Ulaş");
		request.setCity("Aydın");
		// Diğer alanlar setlenmedi
 		ResponseBaseApi response = freelancerController.createFreelancer(request);
 		verify(freelancerService, times(1)).createFreelancer(request);  
		assertNull(response);  
	}
}
