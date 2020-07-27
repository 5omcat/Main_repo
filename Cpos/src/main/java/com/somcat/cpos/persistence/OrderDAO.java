package com.somcat.cpos.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.portable.ValueBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.domain.OrderVO;

@Repository
public class OrderDAO implements OrderDAOIntf {
	private static Logger log = LoggerFactory.getLogger(OrderDAO.class);

	String ns = "OrderMapper.";

	@Inject
	SqlSession sql;

	@Override
	public int insertOrder(OrderVO ovo) {
		return sql.insert(ns + "order", ovo);
	}

	@Override
	public List<List<OrderVO>> selectOrderList(Criterion cri, OrderVO ovo) {
		Map<Object, Object> map = new HashMap<>();
		map.put("cri", cri);
		map.put("ovo",ovo);
		List<OrderVO> ordL = sql.selectList(ns+"orderList", map);//DB에서온 oList
		List<List<OrderVO>> ordWL = new ArrayList<List<OrderVO>>();//Wrapping List
		List<Integer> wrpnL = new ArrayList<Integer>();//the flag items
		for (int j = 0; j < ordL.size(); j++) {
			if(!wrpnL.contains(ordL.get(j).getWrap_no())) {
				wrpnL.add(ordL.get(j).getWrap_no());
			}
		}
		for (int i = 0; i < wrpnL.size(); i++) {
			List<OrderVO> tmp = new ArrayList<OrderVO>();
			for (int u = 0; u < ordL.size(); u++) {
				if (wrpnL.get(i)==ordL.get(u).getWrap_no()) {
					tmp.add(ordL.get(u));
				}
			}
			ordWL.add(tmp);
		}
		return ordWL;
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
		map.put("ovo", ovo);
		return sql.selectOne(ns + "totalCount", map);
	}

}
