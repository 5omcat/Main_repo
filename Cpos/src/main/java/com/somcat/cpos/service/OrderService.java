package com.somcat.cpos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.OrderVO;

@Service
public class OrderService implements OrderServiceIntf {
	private static Logger log = LoggerFactory.getLogger(OrderService.class);

	
	
	
	
	@Override
	public List<OrderVO> getList(Criterion cri, String member_id) {
		return null;
	}

	@Override
	public int registOrder(OrderVO ovo) {
		return 0;
	}

	@Override
	public int modifyOrder(OrderVO ovo) {
		return 0;
	}

	@Override
	public int cancelOrder(int order_no) {
		return 0;
	}
}
