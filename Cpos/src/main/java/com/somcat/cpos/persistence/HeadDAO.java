package com.somcat.cpos.persistence;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;

@Repository
public class HeadDAO implements HeadDAOIntf{

	private static Logger log = LoggerFactory.getLogger(HeadDAO.class);
	private static String hs = "HeadMapper.";

	@Inject
	SqlSession sql;
	
	@Override
	public int insertHead(HeadVO hvo) {
		return sql.insert(hs+"regist", hvo);
	}

	@Override
	public int selectBarcode(int barcode) {
		return sql.selectOne(hs+"checkbarcode", barcode);
	}

	@Override
	public int selectPname(String pname) {
		return sql.selectOne(hs+"checkpname", pname);
	}

	@Override
	public List<HeadVO> selectHeadList(Criterion cri) {
		return sql.selectList(hs+"plist", cri);
	}

	@Override
	public List<HeadVO> selectLargeCate( Criterion cri) {
		return sql.selectList(hs+"lcate", cri);		
	}

	@Override
	public List<HeadVO> selectMediumCate(Criterion cri) {
		return sql.selectList(hs+"mcate", cri);
	}

	@Override
	public int updateHead(HeadVO hvo) {
		return sql.update(hs+"modify", hvo);
	}

	@Override
	public int deleteHead(int barcode) {
		return sql.delete(hs+"remove", barcode);
	}

	@Override
	public int selectTotalCount() {
		return sql.selectOne(hs+"total");
	}

	@Override
	public HeadVO selectProduct(int barcode) {
		return sql.selectOne(hs+"detail", barcode);
	}
}
