package com.somcat.cpos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.somcat.cpos.domain.ReceiptVO;

@Service
public class ReceiptService implements ReceiptServiceIntf{
	private static Logger log = LoggerFactory.getLogger(ReceiptService.class);


	@Override
	public int insertReciept(ReceiptVO rvo) {
		return 0;
	}

	@Override
	public List<ReceiptVO> selectReceiptList(ReceiptVO rvo) {
		return null;
	}

	@Override
	public ReceiptVO selectReceiptDetail(int recno) {
		return null;
	}
}
