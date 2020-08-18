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

import com.somcat.cpos.domain.CategoryVO;
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
	public int insertOrder(List<OrderVO> ovos) {
		return sql.insert(ns + "order", ovos);
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
	public List<CategoryVO> selectMediumCates(String large) {
		return sql.selectList(ns+"mCtgs", large);
	}

	@Override
	public int selectTotalCount(OrderVO ovo) {
		return sql.selectOne(ns + "totalCount", ovo);
	}

	@Override
	public int selectAmount(OrderVO ovo, int pageNum) {
		Map<Object, Object> map = new HashMap<>();
		map.put("pageNum", pageNum);
		map.put("ovo",ovo);
		return sql.selectOne(ns+"amountCount", map);
	}

	@Override
	public int selectUnderAmount(OrderVO ovo, int pageNum) {
		Map<Object, Object> map1 = new HashMap<>();
		map1.put("pageNum", pageNum);
		map1.put("ovo",ovo);
		return sql.selectOne(ns+"underAmountCount", map1);
	}

	@Override
	public List<Integer> getWrapno() {
		return sql.selectList(ns+"getWrapno");
	}

	@Override
	public int updateOrderStatus(int wrap_no, int status) {
		Map<Object, Object> map2 = new HashMap<>();
		map2.put("wrap_no", wrap_no);
		map2.put("status",status);
		return sql.update(ns+"changeOrderStatus",map2);
	}

}
