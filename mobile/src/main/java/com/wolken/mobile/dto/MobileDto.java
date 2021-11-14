package com.wolken.mobile.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor

public class MobileDto {
    private int id;
	private String brandName;
	private String type;
	private short RAM;
	private short ROM;
	private float price;
	private int modelNumber;
	private String modelName;
	private boolean availability;
}
