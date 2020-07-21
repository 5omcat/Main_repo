package com.somcat.cpos.persistence;

import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;

public interface PayDAOIntf {
	public List<CategoryVO> selectcList();
	public List<InventoryVO> selectiList(); 
	public List<CategoryVO> selectmList(String large);
	public List<InventoryVO> selectilList(String large);
	public List<InventoryVO> selectlmiList(String large, String medium);
}
