package com.somcat.cpos.domain;


public class PagingVO {
	private int totalCount;
	private int beginPagingNum;
	private int endPagingNum;
	private boolean prev, next;
	private Criterion cri;
	
	public PagingVO() {
	}
	
	public PagingVO(int totalCount, Criterion cri) {
		this.totalCount = totalCount;
		this.cri = cri;
		this.endPagingNum = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.beginPagingNum = this.endPagingNum-9;
		int realEndPagingNum=0;
		if(cri.getUnderamount()!=-1) {
			realEndPagingNum = (int)(Math.ceil(totalCount/10.0));
		}else {
			realEndPagingNum = (int)(Math.ceil((totalCount*1.0)/cri.getAmount()));
		}
		if(realEndPagingNum <= this.endPagingNum) {
			this.endPagingNum = realEndPagingNum;
		}
		this.prev = beginPagingNum > 1;
		this.next = this.endPagingNum < realEndPagingNum;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBeginPagingNum() {
		return beginPagingNum;
	}
	public void setBeginPagingNum(int beginPagingNum) {
		this.beginPagingNum = beginPagingNum;
	}
	public int getEndPagingNum() {
		return endPagingNum;
	}
	public void setEndPagingNum(int endPagingNum) {
		this.endPagingNum = endPagingNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public Criterion getCri() {
		return cri;
	}
	public void setCri(Criterion cri) {
		this.cri = cri;
	}
	
}
