package com.somcat.cpos.domain;

import java.sql.Date;

public class OrderVO {
	private int order_no;
	private String member_id;
	private int barcode;
	private String pname;
	private int order_qnt;
	private Date order_date;
	private Date get_date;
	private int wrap_no;
	private int expire_term;
	private int status;
	
	public OrderVO(int order_no, int barcode, int order_qnt, Date order_date, Date get_date, int wrap_no, int status) {
		this.order_no = order_no;
		this.barcode = barcode;
		this.order_qnt = order_qnt;
		this.order_date = order_date;
		this.get_date = get_date;
		this.wrap_no = wrap_no;
		this.status = status;
	}

	public OrderVO(int order_no, String member_id, int barcode, String pname, int order_qnt, Date order_date,
			Date get_date, int wrap_no, int expire_term, int status) {
		this.order_no = order_no;
		this.member_id = member_id;
		this.barcode = barcode;
		this.pname = pname;
		this.order_qnt = order_qnt;
		this.order_date = order_date;
		this.get_date = get_date;
		this.wrap_no = wrap_no;
		this.expire_term = expire_term;
		this.status = status;
	}

	public int getOrder_no() {
		return order_no;
	}


	public void setOrder_no(int order_no) {
		this.order_no = order_no;
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


	public int getOrder_qnt() {
		return order_qnt;
	}


	public void setOrder_qnt(int order_qnt) {
		this.order_qnt = order_qnt;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public Date getGet_date() {
		return get_date;
	}


	public void setGet_date(Date get_date) {
		this.get_date = get_date;
	}


	public int getWrap_no() {
		return wrap_no;
	}


	public void setWrap_no(int wrap_no) {
		this.wrap_no = wrap_no;
	}


	public int getExpire_term() {
		return expire_term;
	}


	public void setExpire_term(int expire_term) {
		this.expire_term = expire_term;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
}
