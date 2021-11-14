package com.wolken.mobile.dao;


import org.hibernate.query.Query;
import java.util.List;

import javax.persistence.RollbackException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.wolken.mobile.controller.MobileController;
import com.wolken.mobile.entity.MobileEntity;
@Component
public class MobileDaoImpl implements MobileDao {
	Logger logger=Logger.getLogger(MobileDaoImpl.class);
	@Autowired
	SessionFactory factory;
	public String save(MobileEntity entity) {
		Session session = null;
		try {
	    	session = factory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	logger.info(entity);
	    	session.save(entity);
	    	tx.commit();
		}
		catch(Exception e) {
			logger.error("Connection is not eshtablished");
			return "Save Failed";
		}
		finally {
			if(session!=null)
				logger.info("session closing");
				session.close();
		}
		
		return "Saved Successfully";
		
	}
	public MobileEntity updatePriceByModelNo(MobileEntity entity, float price) {
		Session session = null;
		entity.setPrice(price);
		try {
	    	session = factory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	session.saveOrUpdate(entity);
	    	tx.commit();
		}
		catch(RollbackException e) {
			System.err.println(e.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		
		return entity;
	}
	public MobileEntity updateAvailabilityByModelNo(MobileEntity entity, boolean availability) {
		Session session = null;
		entity.setAvailability(availability);
		try {
	    	session = factory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	session.saveOrUpdate(entity);
	    	tx.commit();
		}
		catch(RollbackException e) {
			System.err.println(e.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		
		return entity;
	}
	
	public List<MobileEntity> getByPrice(float price) {
		Session session = null;
		List<MobileEntity> entity= null;
		try{
	    	session = factory.openSession();
	    	Query query =session.getNamedQuery("getByPrice");
	    	query.setParameter("price", price);
	    	entity = query.list();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return entity;
	}
	
	public List<MobileEntity> getByBrandName(String brandName) {
		Session session = null;
		List<MobileEntity> entity= null;
		try{
	    	session = factory.openSession();
	    	Query query = session.getNamedQuery("getByBrandName");
	    	query.setParameter("brandName", brandName);
	    	entity = query.list();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return entity;
	}

	public MobileEntity getByModelNo(int modelNo) {
		Session session = null;
		MobileEntity entity= null;
		try{
	    	session = factory.openSession();
	    	Query query = session.getNamedQuery("getByModelNo");
	    	query.setParameter("modelNo", modelNo);
	    	entity = (MobileEntity) query.uniqueResult();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return entity;
	}
	

}
