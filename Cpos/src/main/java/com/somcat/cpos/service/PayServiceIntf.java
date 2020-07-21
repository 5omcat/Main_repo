package com.somcat.cpos.service;

import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;

public interface PayServiceIntf {
	public List<CategoryVO> getcList();
	public List<InventoryVO> getiList(); 

	public List<CategoryVO> getmList(String large);
	public List<InventoryVO> getliList(String large);

	public List<InventoryVO> getlmiList(String large, String medium);
}
