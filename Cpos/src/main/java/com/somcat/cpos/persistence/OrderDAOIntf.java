package com.somcat.cpos.persistence;

import java.util.List;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.domain.OrderVO;

public interface OrderDAOIntf {
	public int insertProduct(MemberVO mvo);
	
	public int insertOrder(OrderVO ovo);

	public int selectBarcode(String id);

	public int selectPname(String id);

	public List<HeadVO> selectHeadlist(Criterion cri);

	public List<String> selectLargeCate();

	public List<String> selectMediumCate();

	public int updateProduct(HeadVO hvo);

	public int deleteProduct(int bacode);
}
