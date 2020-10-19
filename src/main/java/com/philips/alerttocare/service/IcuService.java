package com.philips.alerttocare.service;

import java.util.List;

import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.model.AddIcuModel;

public interface IcuService {
	
	public Icu addIcu(AddIcuModel addIcuModel);
	
	public List<Icu> getIcus();
}
