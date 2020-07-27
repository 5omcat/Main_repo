package com.somcat.cpos.domain;

import java.sql.Date;

public class ScrapVO {
	private int scrap_no; //number(5,0),
	private String member_id;
	private int barcode; //number(8,0),
	private String pname;
	private int category; //number(4,0),
	private int scrap_qnt; //number(4,0)
	private int get_price; //number(4,0),
	private Date scrap_date;
	private Date expire_date;
	private int ino;
	
	public ScrapVO() {}
	
	public ScrapVO(String member_id, int barcode, String pname, int category, int get_price, 
			Date expire_date, int scrap_qnt, int ino) {
		this.member_id = member_id;
		this.barcode = barcode;
		this.pname = pname;
		this.category = category;
		this.get_price = get_price;
		this.expire_date = expire_date;
		this.scrap_qnt = scrap_qnt;
		this.ino = ino;
	}
	
	public ScrapVO(int scrap_no, String member_id, int barcode, int category, int get_price, Date scrap_date,
			Date expire_date, String pname, int scrap_qnt, int ino) {
		this.scrap_no = scrap_no;
		this.member_id = member_id;
		this.barcode = barcode;
		this.category = category;
		this.get_price = get_price;
		this.scrap_date = scrap_date;
		this.expire_date = expire_date;
		this.pname = pname;
		this.scrap_qnt = scrap_qnt;
		this.ino = ino;
	}

	public int getScrap_no() {
		return scrap_no;
	}
	public void setScrap_no(int scrap_no) {
		this.scrap_no = scrap_no;
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
	public Date getScrap_date() {
		return scrap_date;
	}
	public void setScrap_date(Date scrap_date) {
		this.scrap_date = scrap_date;
	}
	public Date getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getScrap_qnt() {
		return scrap_qnt;
	}

	public void setScrap_qnt(int scrap_qnt) {
		this.scrap_qnt = scrap_qnt;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}
}
