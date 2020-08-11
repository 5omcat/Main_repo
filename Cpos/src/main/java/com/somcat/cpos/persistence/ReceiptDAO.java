package com.somcat.cpos.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.somcat.cpos.domain.ReceiptVO;

@Repository
public class ReceiptDAO implements ReceiptDAOIntf{
	private static Logger log = LoggerFactory.getLogger(ReceiptDAO.class);
	private static String ns = "ReceiptMapper.";
	
	@Inject
	SqlSession sql;
	
	@Override
	public List<ReceiptVO> getReceiptList(ReceiptVO rvo) {
		return sql.selectList(ns+"rlist", rvo);
	}
	@Override
	public List<ReceiptVO> getReceiptDetail(String rno) {
		return sql.selectList(ns+"rdetail", rno);
	}
	@Override
	public int insertReceipt(ReceiptVO rvo) {
		return sql.insert(ns+"addrec", rvo);
	}
}
