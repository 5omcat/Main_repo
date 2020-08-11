package com.somcat.cpos.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryVO {
	private static Logger log = LoggerFactory.getLogger(CategoryVO.class);
	
	private int category;
	private String large;
	private String medium;
	
	public CategoryVO() {}

	public CategoryVO(String large, String medium) {
		this.large = large;
		this.medium = medium;
	}

	public CategoryVO(int category, String large, String medium) {
		this.category = category;
		this.large = large;
		this.medium = medium;
	}


	public CategoryVO(String large) {
		this.large = large;
	}

	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public String getLarge() {
		return large;
	}


	public void setLarge(String large) {
		this.large = large;
	}


	public String getMedium() {
		return medium;
	}


	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	
}
