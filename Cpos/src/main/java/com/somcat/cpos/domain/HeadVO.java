package com.somcat.cpos.domain;


public class HeadVO {
	
	private int barcode;//number(8,0)
	private String pname;
	private int category;
	private int expire_term;
	private int get_price;
	private int sell_price;
	private int discount_rate;
	private int status;
	
	//그냥
	public HeadVO() {
	}
	
	//modify
		public HeadVO(String pname, int expire_term, int get_price, int sell_price,
				int discount_rate, int status) {
			this.pname = pname;
			this.expire_term = expire_term;
			this.get_price = get_price;
			this.sell_price = sell_price;
			this.discount_rate = discount_rate;
		}
	//regist	
	public HeadVO(String pname, int expire_term, int get_price, int sell_price,
			int discount_rate, int barcode, int category, int status) {
		this(pname, expire_term, get_price, sell_price, discount_rate, status);
		this.barcode = barcode;
		this.category = category;		
	}
		
	//list
	public HeadVO(int barcode, String pname, int category) {
		this.barcode = barcode;
		this.pname = pname;
		this.category = category;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
	public int getExpire_term() {
		return expire_term;
	}
	public void setExpire_term(int expire_term) {
		this.expire_term = expire_term;
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
	public int getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}	
	
}
