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
	private String str_date_s;
	private String str_date_e;
	private int division;
	private int discount_rate;
	private String receipt_no;
	private String pname;
	private int get_price;
	private int sell_price;
	
	public ReceiptVO() {
		
	}

	public ReceiptVO(String member_id, String receipt_no) {
		this.member_id = member_id;
		this.receipt_no = receipt_no;
	}

	public ReceiptVO(int sell_no, String pay_method, Date sell_date, String receipt_no, String pname) {
		this.sell_no = sell_no;
		this.pay_method = pay_method;
		this.sell_date = sell_date;
		this.receipt_no = receipt_no;
		this.pname = pname;
	}

	public ReceiptVO(String member_id, String pay_method, Date sell_date_s, Date sell_date_e, int division) {
		this.member_id = member_id;
		this.pay_method = pay_method;
		this.sell_date_s = sell_date_s;
		this.sell_date_e = sell_date_e;
		this.division = division;
	}

	
	public ReceiptVO(String member_id, int barcode, int sell_qnt, String pay_method, Date sell_date,
			int division, int discount_rate, String receipt_no, String pname, int get_price, int sell_price) {
		this.member_id = member_id;
		this.barcode = barcode;
		this.sell_qnt = sell_qnt;
		this.pay_method = pay_method;
		this.sell_date = sell_date;
		this.division = division;
		this.discount_rate = discount_rate;
		this.receipt_no = receipt_no;
		this.pname = pname;
		this.get_price = get_price;
		this.sell_price = sell_price;
	}

	public ReceiptVO(int sell_no, String member_id, int barcode, int sell_qnt, String pay_method, Date sell_date,
			Date sell_date_s, Date sell_date_e, int division, int discount_rate, String receipt_no, String pname,
			int get_price, int sell_price) {
		super();
		this.sell_no = sell_no;
		this.member_id = member_id;
		this.barcode = barcode;
		this.sell_qnt = sell_qnt;
		this.pay_method = pay_method;
		this.sell_date = sell_date;
		this.sell_date_s = sell_date_s;
		this.sell_date_e = sell_date_e;
		this.division = division;
		this.discount_rate = discount_rate;
		this.receipt_no = receipt_no;
		this.pname = pname;
		this.get_price = get_price;
		this.sell_price = sell_price;
	}

	
	
	public String getStr_date_s() {
		return str_date_s;
	}

	public void setStr_date_s(String str_date_s) {
		this.str_date_s = str_date_s;
	}

	public String getStr_date_e() {
		return str_date_e;
	}

	public void setStr_date_e(String str_date_e) {
		this.str_date_e = str_date_e;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
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

	public String getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}
	
	
}
