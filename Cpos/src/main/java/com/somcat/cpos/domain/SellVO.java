package com.somcat.cpos.domain;

import java.sql.Date;

public class SellVO {
	private int sell_no; //number(10,0),
	private String member_id;
	private int barcode; //number(8,0),
	private String pname;// varchar2(100),
	private int category;// number(4,0),
	private int sell_qnt; //number(4,0),
	private int get_price;// number(4,0),
	private int sell_price;// number(4,0),
	private String pay_method;
	private Date sell_date;
	private int discount_rate; //number(4,0),
	private int receipt_no; //number(14,0)
	
	public SellVO(int sell_no, int sell_qnt) {
		this.sell_no = sell_no;
		this.sell_qnt = sell_qnt;
	}

	public SellVO(int sell_no, String member_id, int barcode, int sell_qnt, String pay_method, Date sell_date,
			int discount_rate, int receipt_no) {
		this.sell_no = sell_no;
		this.member_id = member_id;
		this.barcode = barcode;
		this.sell_qnt = sell_qnt;
		this.pay_method = pay_method;
		this.sell_date = sell_date;
		this.discount_rate = discount_rate;
		this.receipt_no = receipt_no;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getGet_price() {
		return get_price;
	}

	public void setGet_price(int get_price) {
		this.get_price = get_price;
	}

	public int getSell_price() {
		return sell_price;
	}

	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
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


	public Date getSell_date() {
		return sell_date;
	}


	public void setSell_date(Date sell_date) {
		this.sell_date = sell_date;
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
