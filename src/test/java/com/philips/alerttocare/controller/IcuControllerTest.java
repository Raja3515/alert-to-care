package com.philips.alerttocare.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.model.AddIcuModel;
import com.philips.alerttocare.service.IcuService;

public class IcuControllerTest {

	@InjectMocks
	private IcuController icuController;

	@Mock
	private IcuService icuService;

	@Mock
	private Icu icu;

	@Mock
	private AddIcuModel addIcuModel;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddIcu() {
		Mockito.when(icuService.addIcu(addIcuModel)).thenReturn(icu);
		Icu addIcu = icuController.addIcu(addIcuModel);
		assertNotNull(addIcu);
	}

}
