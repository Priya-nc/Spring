package com.wolken.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Data
@Table(name = "Mobile_Details")
@NamedQueries({
	@NamedQuery(name="getByPrice", query="from UserEntity where price = :price"),
	@NamedQuery(name="getByBrandName", query="from UserEntity where brandName = :brandName"),
	@NamedQuery(name="getByModelNo", query="from UserEntity where modelNumber = :modelNo")
})
public class MobileEntity {
	@Id
	@Column
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	private int id;
	@Column
	private String brandName;
	@Column
	private String type;
	@Column
	private short RAM;
	@Column
	private short ROM;
	@Column
	private float price;
	@Column
	private int modelNumber;
	@Column
	private String modelName;
	@Column
	private boolean availability;
}
