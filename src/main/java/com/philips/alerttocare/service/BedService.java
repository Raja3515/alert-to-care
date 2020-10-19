package com.philips.alerttocare.service;

import com.philips.alerttocare.model.AddBedModel;
import com.philips.alerttocare.model.ApiResponse;

public interface BedService {
	
	public ApiResponse saveBed(AddBedModel addBedModel);
}
