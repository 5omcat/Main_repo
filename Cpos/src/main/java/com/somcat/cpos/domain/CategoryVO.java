package com.somcat.cpos.domain;

public class CategoryVO {
	
	private int category; // number(4,0),
	private String large;
	private String medium;
	
	public CategoryVO() {}


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
