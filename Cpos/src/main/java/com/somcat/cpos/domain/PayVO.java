package com.somcat.cpos.domain;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayVO {
	private static Logger log = LoggerFactory.getLogger(PayVO.class);

	private int sell_no;
	private String member_id;
	private int barcode;
	private String pname;
	private int category;
	private int sell_qnt;
	private int get_price;
	private int sell_price;
	private String pay_method;
	private Date sell_date;
	private int discount_rate;
	private String receipt_no;
	private int division;
	
	public PayVO() {}
	

	// 상품판매시
	public PayVO(String member_id, int barcode, String pname, int category, int sell_qnt, int get_price, int sell_price,
			String pay_method, int discount_rate, String receipt_no) {
		this.member_id = member_id;
		this.barcode = barcode;
		this.pname = pname;
		this.category = category;
		this.sell_qnt = sell_qnt;
		this.get_price = get_price;
		this.sell_price = sell_price;
		this.pay_method = pay_method;
		this.discount_rate = discount_rate;
		this.receipt_no = receipt_no;
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


	public int getSell_qnt() {
		return sell_qnt;
	}


	public void setSell_qnt(int sell_qnt) {
		this.sell_qnt = sell_qnt;
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


	public String getReceipt_no() {
		return receipt_no;
	}


	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}
	
	public int getDivision() {
		return division;
	}


	public void setDivision(int division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "PayVO [sell_no=" + sell_no + ", member_id=" + member_id + ", barcode=" + barcode + ", pname=" + pname
				+ ", category=" + category + ", sell_qnt=" + sell_qnt + ", get_price=" + get_price + ", sell_price="
				+ sell_price + ", pay_method=" + pay_method + ", sell_date=" + sell_date + ", discount_rate="
				+ discount_rate + ", receipt_no=" + receipt_no + ", division=" + division + "]";
	}

}
