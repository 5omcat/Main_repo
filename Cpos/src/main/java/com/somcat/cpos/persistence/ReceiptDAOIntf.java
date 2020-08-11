package com.somcat.cpos.persistence;

import java.util.List;

import com.somcat.cpos.domain.ReceiptVO;

public interface ReceiptDAOIntf {
	public int insertReceipt(ReceiptVO rvo);
	public List<ReceiptVO> getReceiptList(ReceiptVO rvo);
	public List<ReceiptVO> getReceiptDetail(String rno);
}
