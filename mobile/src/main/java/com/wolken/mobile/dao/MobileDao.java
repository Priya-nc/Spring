package com.wolken.mobile.dao;

import java.util.List;

import com.wolken.mobile.entity.MobileEntity;

public interface MobileDao {
	public String save(MobileEntity entity);
	public MobileEntity updateAvailabilityByModelNo(MobileEntity entity, boolean availability);
	public MobileEntity updatePriceByModelNo(MobileEntity entity, float price);
	public List<MobileEntity> getByPrice(float price);
	public List<MobileEntity> getByBrandName(String brandName);
	public MobileEntity getByModelNo(int modelNo);
	
}
