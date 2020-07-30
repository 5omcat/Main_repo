package com.somcat.cpos.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.OrderVO;
import com.somcat.cpos.persistence.OrderDAOIntf;

@Service
public class OrderService implements OrderServiceIntf {
	private static Logger log = LoggerFactory.getLogger(OrderService.class);

	@Inject
	OrderDAOIntf odao;
	
	@Override
	public int registOrder(List<OrderVO> ovos) {
		return odao.insertOrder(ovos);
	}
	
	@Override
	public List<List<OrderVO>> getList(Criterion cri, OrderVO ovo) {
		return odao.selectOrderList(cri, ovo);
	}


	@Override
	public int modifyOrder(OrderVO ovo) {
		return 0;
	}

	@Override
	public int cancelOrder(int order_no) {
		return 0;
	}

	@Override
	public int getTotalCount(OrderVO ovo) {
		return odao.selectTotalCount(ovo);
	}

	@Override
	public int getAmount(OrderVO ovo, int pageNum) {
		return odao.selectAmount(ovo, pageNum);
	}

	@Override
	public int getUnderAmount(OrderVO ovo, int pageNum) {
		return odao.selectUnderAmount(ovo, pageNum);
	}

	@Override
	public List<CategoryVO> getMCtgs(String large) {
		return odao.selectMediumCates(large);
	}

	@Override
	public int getWrapno() {
		List<Integer> wrpL = odao.getWrapno();
		boolean unFlag = true;
		int rs = 0;
		while (unFlag) {
			int base = 1000;
			base += (int)(Math.random()*100);
			unFlag = wrpL.contains(base);
			if(unFlag==false) {
				rs = base;
				return rs;
			}
		}
		return 0;
	}
}
