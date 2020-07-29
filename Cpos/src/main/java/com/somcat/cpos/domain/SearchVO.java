package com.somcat.cpos.domain;

import java.util.Date;

public class SearchVO {
	private CategoryVO cate;
	private Date expire_date;
	
	public SearchVO() {
	}
	

	public SearchVO(CategoryVO cate) {		
		this.cate = cate;
	}


	public SearchVO(CategoryVO cate, Date expire_date) {
		this.cate = cate;
		this.expire_date = expire_date;
	}

	public CategoryVO getCate() {
		return cate;
	}

	public void setCate(CategoryVO cate) {
		this.cate = cate;
	}

	public Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}
	
	public String getLarge() {
		return cate.getLarge();
	}

	public void setLarge(String large) {
		this.cate.setLarge(large);
	}

	public String getMedium() {
		return cate.getMedium();
	}

	public void setMedium(String medium) {
		this.cate.setMedium(medium);
	}
}
