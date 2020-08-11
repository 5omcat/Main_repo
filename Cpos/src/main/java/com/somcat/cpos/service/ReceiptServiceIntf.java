package com.somcat.cpos.service;

import java.util.List;

import com.somcat.cpos.domain.ReceiptVO;

public interface ReceiptServiceIntf {
	public int insertReciept(ReceiptVO rvo);
	
	public List<ReceiptVO> selectReceiptList(ReceiptVO rvo);
	public List<ReceiptVO> selectReceiptDetail(String rno);
}
