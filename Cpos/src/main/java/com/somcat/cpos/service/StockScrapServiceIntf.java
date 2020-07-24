package com.somcat.cpos.service;

import java.sql.Date;
import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.ScrapVO;
import com.somcat.cpos.domain.SearchVO;

public interface StockScrapServiceIntf {
	public int addInventory(InventoryVO ivo);
	public List<InventoryVO> getLargeCate(); //?
	public List<InventoryVO> getMediumCate(); //?
	public List<InventoryVO> getProductList(Criterion cri);
	public List<InventoryVO> getInvenList(CategoryVO cate);
	public int addScrap(List<ScrapVO> svo);
	public int addScrap(ScrapVO svo);
	public List<ScrapVO> getScrapList(Date date);
	public int modifyQuantity(InventoryVO ivo);
	public int removeInventory(int inventory_no);
	public List<CategoryVO> getAllCate();
	public List<InventoryVO> getInvenList2(SearchVO svo);
}
