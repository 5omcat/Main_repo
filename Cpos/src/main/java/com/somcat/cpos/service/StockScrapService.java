package com.somcat.cpos.service;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.ScrapVO;
import com.somcat.cpos.domain.SearchVO;
import com.somcat.cpos.persistence.StockScrapDAOIntf;

@Service
public class StockScrapService implements StockScrapServiceIntf{
	private static Logger log = LoggerFactory.getLogger(StockScrapService.class);
	
	@Inject
	StockScrapDAOIntf sdao;

	@Override
	public int addInventory(InventoryVO ivo) {
		return sdao.insertInventory(ivo);
	}

	@Override
	public List<InventoryVO> getLargeCate() {
		return sdao.selectLargeCate();
	}

	@Override
	public List<InventoryVO> getMediumCate() {
		return sdao.selectMediumCate();
	}

	@Override
	public List<InventoryVO> getProductList(Criterion cri) {
		return sdao.selectProductList(cri);
	}

	@Transactional
	@Override
	public int addScrap(List<ScrapVO> svo) {
		List<Integer> ilist = sdao.insertScrap(svo);
		return sdao.deleteInventory(ilist);
	}

	@Override
	public List<ScrapVO> getScrapList(Date date) {
		return sdao.selectScrapList(date);
	}

	@Override
	public int modifyQuantity(InventoryVO ivo) {
		return sdao.updateQuantity(ivo);
	}

	@Override
	public int removeInventory(int inventory_no) {
		return sdao.deleteInven(inventory_no);
	}

	@Override
	public List<InventoryVO> getInvenList(CategoryVO cate) {
		return sdao.selectInventoryList(cate);
	}

	@Override
	public List<CategoryVO> getAllCate() {
		return sdao.selectAllCate();
	}
	
	@Override
	public List<InventoryVO> getInvenList2(SearchVO svo) {
		return sdao.selectInventoryList(svo);
	}

	@Transactional
	@Override
	public int addScrap(ScrapVO svo) {
		sdao.insertScrap(svo);
		return sdao.deleteInven(svo.getIno());
	}
}
