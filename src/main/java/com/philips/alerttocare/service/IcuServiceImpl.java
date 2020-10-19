package com.philips.alerttocare.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.model.AddIcuModel;
import com.philips.alerttocare.repository.IcuRepository;

@Service
public class IcuServiceImpl implements IcuService {
	
	@Autowired
	private IcuRepository icuRepository;

	@Override
	public Icu addIcu(AddIcuModel addIcuModel) {
		Icu icu=new Icu();
		icu.setLayoutInfo(addIcuModel.getLayoutInfo());
		icu.setBedLimit(addIcuModel.getBedLimit());
		icu.setTotalBeds(0);
		icu.setTimestamp(new Timestamp(System.currentTimeMillis()));
		Icu save = icuRepository.save(icu);
		return save;
	}

	@Override
	public List<Icu> getIcus() {
		return icuRepository.findAll();
	}

}
