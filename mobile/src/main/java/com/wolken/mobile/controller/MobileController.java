package com.wolken.mobile.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wolken.mobile.dto.MobileDto;
import com.wolken.mobile.entity.MobileEntity;
import com.wolken.mobile.services.MobileService;
@Controller
public class MobileController {
	@Autowired
	
	MobileService service;
	Logger logger=Logger.getLogger(MobileController.class);
	@RequestMapping(value="save", method=RequestMethod.POST)
	String save(MobileDto dto) {
		//ModelAndView view = new ModelAndView();
		logger.info(dto);
		logger.info("validating");
		String out = service.validateSave(dto);
//		view.setViewName("hello");
//		view.addObject("out", out);
		return "hi.jsp";
	}
	@RequestMapping("update-price")
	ModelAndView updatePrice(MobileDto dto) {
		ModelAndView view = new ModelAndView();
		MobileEntity out = service.updatePriceByModelNo(dto.getModelNumber(), dto.getPrice());
		view.setViewName("hello");
		if(out!=null) {
			view.addObject("out","Updated Successfully");
		}
		view.addObject("onedata", out);
		view.addObject("msg", "Data not found");
		return view;
	}

	@RequestMapping("update-availability")
	ModelAndView updateAvailability(MobileDto dto) {
		ModelAndView view = new ModelAndView();
		MobileEntity out = service.updateAvailabilityByModelNo(dto.getModelNumber(), dto.isAvailability());
		view.setViewName("hello");
		if(out!=null) {
			view.addObject("out","Updated Successfully");
		}
		view.addObject("onedata", out);
		view.addObject("msg", "Data not found");
		return view;
	}

	@RequestMapping("get-by-price")
	ModelAndView getByPrice(MobileDto dto) {
		ModelAndView view = new ModelAndView();
		List<MobileEntity> out = service.getByPrice(dto.getPrice());
		view.setViewName("hello");
		view.addObject("data", out);
		view.addObject("msg", "Data not found");
		return view;
	}

	@RequestMapping("get-by-brand")
	ModelAndView getByBrand(MobileDto dto) {
		ModelAndView view = new ModelAndView();
		List<MobileEntity> out = service.getByBrandName(dto.getBrandName());
		view.setViewName("hello");
		view.addObject("data", out);
		view.addObject("msg", "Data not found");
		return view;
	}

	}

