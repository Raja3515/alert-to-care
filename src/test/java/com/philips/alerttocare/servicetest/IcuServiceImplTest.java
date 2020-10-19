package com.philips.alerttocare.servicetest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.model.AddIcuModel;
import com.philips.alerttocare.repository.IcuRepository;
import com.philips.alerttocare.service.IcuServiceImpl;

public class IcuServiceImplTest {
	
	@InjectMocks
	private IcuServiceImpl icuServiceImpl;
	
	@Mock
	private IcuRepository icuRepository;
	
	@Mock
	private AddIcuModel addIcuModel;
	
	@Mock
	private Icu icu;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddIcu() {
		addIcuModel.setBedLimit(10);
		addIcuModel.setLayoutInfo("Test");
		icuServiceImpl.addIcu(addIcuModel);
		Mockito.when(icuRepository.save(Mockito.any())).thenReturn(icu);
		assertNotNull(icu);
//		assertEquals(expected, actual);		
	}
}
