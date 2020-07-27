package com.somcat.cpos.domain;

import java.util.Date;

public class ReceiptVO {
	private int sell_no;
	private String member_id;
	private int barcode;
	private int sell_qnt;
	private String pay_method;
	private Date sell_date;
	private Date sell_date_s;	//정렬 시작일
	private Date sell_date_e;	//정렬 종료일
	private String category;
	private int discount_rate;
	private int receipt_no;
	
	public ReceiptVO() {
		
	}

	public ReceiptVO(String member_id, int receipt_no) {
		super();
		this.member_id = member_id;
		this.receipt_no = receipt_no;
	}


	public ReceiptVO(String member_id, String pay_method, Date sell_date_s, Date sell_date_e, String category) {
		super();
		this.member_id = member_id;
		this.pay_method = pay_method;
		this.sell_date_s = sell_date_s;
		this.sell_date_e = sell_date_e;
		this.category = category;
	}

	public Date getSell_date() {
		return sell_date;
	}

	public void setSell_date(Date sell_date) {
		this.sell_date = sell_date;
	}

	public Date getSell_date_s() {
		return sell_date_s;
	}

	public void setSell_date_s(Date sell_date_s) {
		this.sell_date_s = sell_date_s;
	}

	public Date getSell_date_e() {
		return sell_date_e;
	}

	public void setSell_date_e(Date sell_date_e) {
		this.sell_date_e = sell_date_e;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSell_no() {
		return sell_no;
	}

	public void setSell_no(int sell_no) {
		this.sell_no = sell_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public int getSell_qnt() {
		return sell_qnt;
	}

	public void setSell_qnt(int sell_qnt) {
		this.sell_qnt = sell_qnt;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public int getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}

	public int getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(int receipt_no) {
		this.receipt_no = receipt_no;
	}
	
	
}
