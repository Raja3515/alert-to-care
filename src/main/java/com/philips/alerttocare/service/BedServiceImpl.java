package com.philips.alerttocare.service;

import java.sql.Timestamp;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.alerttocare.entity.Bed;
import com.philips.alerttocare.entity.Icu;
import com.philips.alerttocare.model.AddBedModel;
import com.philips.alerttocare.model.ApiResponse;
import com.philips.alerttocare.repository.BedRepository;
import com.philips.alerttocare.repository.IcuRepository;
import com.philips.alerttocare.utils.AppUtils;

@Service
@Transactional
public class BedServiceImpl implements BedService{
	
	@Autowired
	private BedRepository bedRepository;
	
	@Autowired
	private IcuRepository icuRepository;
	
	@Override
	public ApiResponse saveBed(AddBedModel addBedModel) {
		Optional<Icu> optional = icuRepository.findById(addBedModel.getIcuId());
		if(optional.isPresent()) {
			Icu icu = optional.get();
			Bed bed=new Bed();
			bed.setBedStatus("Vacant");
			icu.setIcuId(addBedModel.getIcuId());
			Integer totalBeds = icu.getTotalBeds();
			if(totalBeds<icu.getBedLimit()) {
				icu.setTotalBeds(icu.getTotalBeds()+1);
				bed.setIcu(icu);
				bed.setTimestamp(new Timestamp(System.currentTimeMillis()));
				Bed savedBed = bedRepository.save(bed);
				return AppUtils.generateSuccessApiResponse(savedBed);
			}else {
				return AppUtils.generateFailureApiResponse("Max Bed Limit Reached", 404);
			}
		}else {
			return AppUtils.generateFailureApiResponse("Invalid ICU Id", 404);
		}
	}

}
