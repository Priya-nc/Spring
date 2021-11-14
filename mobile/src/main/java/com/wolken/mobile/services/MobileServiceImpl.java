package com.wolken.mobile.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wolken.mobile.controller.MobileController;
import com.wolken.mobile.dao.MobileDao;
import com.wolken.mobile.dto.MobileDto;
import com.wolken.mobile.entity.MobileEntity;

@Service

public class MobileServiceImpl implements MobileService{
	MobileEntity entity=new MobileEntity();
@Autowired

MobileDao dao;
	public String validateSave(MobileDto dto) {
		Logger logger=Logger.getLogger(MobileController.class);
		if(dto!=null) {
			BeanUtils.copyProperties(dto, entity);
			logger.info("Have some data");
		}
		else {
			logger.error("enter valid details");
		}
		return dao.save(entity);
	}
public List<MobileEntity> getByBrandName(String brandName) {
		
		return dao.getByBrandName(brandName);
	}

	public List<MobileEntity> getByPrice(float price) {
		// TODO Auto-generated method stub
		return dao.getByPrice(price);
	}

	public MobileEntity updatePriceByModelNo(int modelNo,float price) {
		MobileEntity entity = dao.getByModelNo(modelNo);
		return dao.updatePriceByModelNo(entity,price);
	}

	public MobileEntity updateAvailabilityByModelNo(int modelNo, boolean availability) {
		MobileEntity entity = dao.getByModelNo(modelNo);
		return dao.updateAvailabilityByModelNo(entity, availability);
	}

}
