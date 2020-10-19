package com.philips.alerttocare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.model.AddIcuModel;
import com.philips.alerttocare.model.ApiResponse;
import com.philips.alerttocare.service.IcuService;
import com.philips.alerttocare.utils.AppUtils;

@RestController
@RequestMapping(value = "/icu-mgmt")
public class IcuController {
	
	@Autowired
	private IcuService icuService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/icus")
	public ApiResponse getIcus() {
		List<Icu> icus = icuService.getIcus();
		return AppUtils.generateSuccessApiResponse(icus);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/icu")
	public Icu addIcu(@RequestBody AddIcuModel addIcuModel) {
		Icu addIcu = icuService.addIcu(addIcuModel);
		return addIcu;
	}
	
}
