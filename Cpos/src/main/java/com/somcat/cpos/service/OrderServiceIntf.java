package com.somcat.cpos.service;

import java.util.List;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.OrderVO;

public interface OrderServiceIntf {
	public List<OrderVO> getList(Criterion cri, String member_id);
	public int registOrder(OrderVO ovo);
	public int modifyOrder(OrderVO ovo);
	public int cancelOrder(int order_no);
}
