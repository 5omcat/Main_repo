package com.somcat.cpos.domain;

import java.util.Date;

public class Criterion {
	private int amount; // 한 페이지에 보여줄 글의 수
	private int pageNum;
	private String keyword;
	private CategoryVO cate;
	private Date today;
	
	
	public Criterion() {
		this(1,10);
	}
	public Criterion(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public CategoryVO getCate() {
		return cate;
	}
	public void setCate(CategoryVO cate) {
		this.cate = cate;
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
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
}
