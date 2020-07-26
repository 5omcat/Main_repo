package com.somcat.cpos.domain;

public class MemberVO {
	private String member_id;
	private String member_pwd;
	private String store_name;
	private int opt;

	public MemberVO() {
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public MemberVO(String member_id, String member_pwd) {
		this.member_id = member_id;
		this.member_pwd = member_pwd;
	}

	public MemberVO(String member_id, String member_pwd, String store_name, int opt) {
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.store_name = store_name;
		this.opt = opt;
	}

	public String getStore_name() {
		return store_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

}
