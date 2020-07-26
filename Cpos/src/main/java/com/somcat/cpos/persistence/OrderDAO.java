package com.somcat.cpos.persistence;

import java.sql.Date;
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
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.domain.OrderVO;

@Repository
public class OrderDAO implements OrderDAOIntf{
	private static Logger log = LoggerFactory.getLogger(OrderDAO.class);

	String ns = "OrderMapper.";
	
	@Inject
	SqlSession sql;
	
	@Override
	public int insertOrder(OrderVO ovo) {
		return sql.insert(ns+"order", ovo);
	}
	
	@Override
	public List<OrderVO> selectOrderList(Criterion cri, OrderVO ovo) {
		Map<Object, Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("ovo",ovo);
		return sql.selectList(ns+"orderList", map);
	}
	
	@Override
	public int insertProduct(MemberVO mvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectBarcode(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectPname(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HeadVO> selectHeadlist(Criterion cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectLargeCate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectMediumCate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(HeadVO hvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int bacode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectTotalCount(Criterion cri, OrderVO ovo) {
		Map<Object, Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("ovo",ovo);
		return sql.selectOne(ns+"totalCount", map);
	}



}
