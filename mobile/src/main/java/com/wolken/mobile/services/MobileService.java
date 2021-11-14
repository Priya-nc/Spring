package com.wolken.mobile.services;


import java.util.List;

import com.wolken.mobile.dto.MobileDto;
import com.wolken.mobile.entity.MobileEntity;

public interface MobileService {

	public String validateSave(MobileDto dto);
	public List<MobileEntity> getByBrandName(String brandName);
	public List<MobileEntity> getByPrice(float price);
	public MobileEntity updatePriceByModelNo(int modelNo, float price);
	public MobileEntity updateAvailabilityByModelNo(int modelNo, boolean availability);
	

	
}
