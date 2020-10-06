package com.somcat.cpos.service;

import java.util.ArrayList;
import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.OrderVO;

public interface OrderServiceIntf {
	public int registOrder(List<OrderVO> ovos);	
	public int changeOrderStatus(int wrap_no, int status);
	public int cancelOrder(int order_no);
	public List<List<OrderVO>> getList(Criterion cri, OrderVO ovo);
	public int getTotalCount(OrderVO ovo);
	public int getAmount(OrderVO ovo, int pageNum);
	public int getUnderAmount(OrderVO ovo, int pageNum);
	public List<CategoryVO> getMCtgs(String large);
	public int getWrapno();
}
