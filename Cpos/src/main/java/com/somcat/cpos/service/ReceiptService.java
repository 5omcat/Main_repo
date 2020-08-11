package com.somcat.cpos.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.somcat.cpos.domain.ReceiptVO;
import com.somcat.cpos.persistence.ReceiptDAOIntf;

@Service
public class ReceiptService implements ReceiptServiceIntf{
	private static Logger log = LoggerFactory.getLogger(ReceiptService.class);

	@Inject
	ReceiptDAOIntf rdao;

	@Override
	public int insertReciept(ReceiptVO rvo) {
		return rdao.insertReceipt(rvo);
	}

	@Override
	public List<ReceiptVO> selectReceiptList(ReceiptVO rvo) {
		return rdao.getReceiptList(rvo);
	}

	@Override
	public List<ReceiptVO> selectReceiptDetail(String rno) {
		return rdao.getReceiptDetail(rno);
	}
}
