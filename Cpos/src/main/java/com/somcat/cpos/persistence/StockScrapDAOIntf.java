package com.somcat.cpos.persistence;

import java.sql.Date;
import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.ScrapVO;
import com.somcat.cpos.domain.SearchVO;

public interface StockScrapDAOIntf {
	public int insertInventory(InventoryVO ivo);
	public List<InventoryVO> selectLargeCate(); //?
	public List<InventoryVO> selectMediumCate(); //?
	public List<InventoryVO> selectInventoryList(CategoryVO cate);
	public List<InventoryVO> selectProductList(Criterion cri);
	public int insertScrap(ScrapVO svo);
	public List<Integer> insertScrap(List<ScrapVO> svo);
	public List<ScrapVO> selectScrapList(Date date);
	public int updateQuantity(InventoryVO ivo);
	public int deleteInven(int inventory_no);
	public int deleteInventory(List<Integer> inventory_no);
	public List<CategoryVO> selectAllCate();
	public List<InventoryVO> selectInventoryList(SearchVO svo);
}
