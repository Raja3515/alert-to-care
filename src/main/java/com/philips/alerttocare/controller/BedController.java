package com.philips.alerttocare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.alerttocare.model.AddBedModel;
import com.philips.alerttocare.model.ApiResponse;
import com.philips.alerttocare.service.BedService;

@RestController
@RequestMapping(value = "/bed-mgmt")
public class BedController {
	
	@Autowired
	private BedService bedService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/bed")
	public ApiResponse addIcu(@RequestBody AddBedModel addBedModel) {
		return bedService.saveBed(addBedModel);
	}
}
