package com.somcat.cpos.persistence;

import java.util.ArrayList;
import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.domain.OrderVO;

public interface OrderDAOIntf {
	
	public int insertOrder(List<OrderVO> ovos);

	public List<List<OrderVO>> selectOrderList(Criterion cri, OrderVO ovo);

	public List<CategoryVO> selectMediumCates(String large);

	public int selectTotalCount(OrderVO ovo);

	public int selectAmount(OrderVO ovo, int pageNum);

	public int selectUnderAmount(OrderVO ovo, int pageNum);
	
	public List<Integer> getWrapno();
}
