package com.somcat.cpos.domain;

import java.util.Date;

public class Criterion {
	private int amount; // 한 페이지에 보여줄 개체의 수
	private int pageNum;// 선택된 페이지 번호
	private String keyword;
	private int underamount;//order페이징에 사용되는 시작점 아래에 깔린 글의 수
	private CategoryVO cate;
	private Date today;
	
	public Criterion() {
		this(1,9);
		this.underamount=-1; 
	}
	public Criterion(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.underamount=-1;
	}
	public Criterion(int pageNum) {
		this.pageNum = pageNum;
		this.underamount=-1;
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
	public int getUnderamount() {
		return underamount;
	}
	public void setUnderamount(int underamount) {
		this.underamount = underamount;
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
