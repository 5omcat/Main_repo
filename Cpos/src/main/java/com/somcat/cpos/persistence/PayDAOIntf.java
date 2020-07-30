package com.somcat.cpos.persistence;

import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.PayVO;

public interface PayDAOIntf {
	public List<CategoryVO> selectcList();
	public List<InventoryVO> selectiList(); 
	
	public List<CategoryVO> selectmList(String large);
	public List<InventoryVO> selectilList(String large);

	public List<InventoryVO> selectlmiList(CategoryVO cvo);
	public int update(List<PayVO> pvos);
	public int selectrno(String receipt_no);
}
