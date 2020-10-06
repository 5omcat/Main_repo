package com.somcat.cpos.service;

import java.sql.Date;
import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.InventoryDTO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.ScrapVO;

public interface StockScrapServiceIntf {
<<<<<<< HEAD
	
	public int addInventory(int wno);
=======
>>>>>>> 30468e00518ec32b79620720d3d47f0feeb6ae67
	public List<InventoryVO> getLargeCate(); //?
	public List<InventoryVO> getMediumCate(); //?
	public InventoryDTO getInvenList(Criterion cri);
	public int addScrap(List<ScrapVO> svo);
	public int addScrap(ScrapVO svo);
	public List<ScrapVO> getScrapList(Date date);
	public int modifyQuantity(InventoryVO ivo);
	public int removeInventory(int inventory_no);
	public List<CategoryVO> getAllCate();
	public InventoryDTO getInvenList2(Criterion cri);
	public int getTotalCount(Criterion cri);
}
