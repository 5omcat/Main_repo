package com.somcat.cpos.domain;


public class Criterion {
	private int amount; // 한 페이지에 보여줄 글의 수
	private int pageNum;// 선택된 페이지 번호
	private String keyword;
	private String type;
	
	public Criterion() {
		this(1,10);
	}
	public Criterion(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public Criterion(int pageNum) {
		this.pageNum = pageNum;
		this.amount = 10;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	
}
