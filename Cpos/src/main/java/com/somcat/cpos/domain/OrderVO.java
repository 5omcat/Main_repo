package com.somcat.cpos.domain;

public class OrderVO {
	private int order_no;
	private String member_id;
	private int barcode;
	private String pname;
	private int order_qnt;
	private String order_sdate;
	private String flag_hdate;
	private String flag_tdate;
	private String get_date;
	private int wrap_no;
	private int expire_term;
	private int status;

	public OrderVO() {
	}

	//insert
	public OrderVO(String member_id, int barcode, String pname, int order_qnt, int wrap_no, int expire_term) {
		this.member_id = member_id;
		this.barcode = barcode;
		this.pname = pname;
		this.order_qnt = order_qnt;
		this.wrap_no = wrap_no;
		this.expire_term = expire_term;
	}

	
	//select all
	public OrderVO(int order_no, String member_id, int barcode, String pname, int order_qnt, String order_sdate,
			String flag_hdate, String flag_tdate, String get_date, int wrap_no, int expire_term, int status) {
		this.order_no = order_no;
		this.member_id = member_id;
		this.barcode = barcode;
		this.pname = pname;
		this.order_qnt = order_qnt;
		this.order_sdate = order_sdate;
		this.flag_hdate = flag_hdate;
		this.flag_tdate = flag_tdate;
		this.get_date = get_date;
		this.wrap_no = wrap_no;
		this.expire_term = expire_term;
		this.status = status;
	}
	
	//for obj before ord regd
	public OrderVO(String member_id, int barcode, String pname, int order_qnt, int wrap_no, int expire_term, int status) {
		this.member_id = member_id;
		this.barcode = barcode;
		this.pname = pname;
		this.order_qnt = order_qnt;
		this.wrap_no = wrap_no;
		this.expire_term = expire_term;
		this.status = status;
	}

	
	//for getList
	public OrderVO(String member_id, String flag_hdate, String flag_tdate) {
		this.member_id = member_id;
		this.flag_hdate = flag_hdate;
		this.flag_tdate = flag_tdate;
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


	public String getOrder_sdate() {
		return order_sdate;
	}


	public void setOrder_sdate(String order_sdate) {
		this.order_sdate = order_sdate;
	}


	public String getFlag_hdate() {
		return flag_hdate;
	}


	public void setFlag_hdate(String flag_hdate) {
		this.flag_hdate = flag_hdate;
	}


	public String getFlag_tdate() {
		return flag_tdate;
	}


	public void setFlag_tdate(String flag_tdate) {
		this.flag_tdate = flag_tdate;
	}


	public String getGet_date() {
		return get_date;
	}


	public void setGet_date(String get_date) {
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
