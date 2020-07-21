package com.somcat.cpos.persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.ScrapVO;

@Repository
public class StockScrapDAO implements StockScrapDAOIntf{
	private static Logger log = LoggerFactory.getLogger(StockScrapDAO.class);
	private static String ns = "StockScrapMapper.";
	
	@Inject
	SqlSession sql;

	@Override
	public int insertInventory(InventoryVO ivo) {
		return sql.insert(ns+"addinven", ivo);
	}

	@Override
	public List<InventoryVO> selectLargeCate() {
		return sql.selectList(ns+"lcate");
	}

	@Override
	public List<InventoryVO> selectMediumCate() {
		return sql.selectList(ns+"mcate");
	}

	@Override
	public List<InventoryVO> selectProductList(Criterion cri) {
		return sql.selectList(ns+"invenlist", cri);
	}

	@Override
	public List<Integer> insertScrap(List<ScrapVO> svo) {
		List<Integer> li = new ArrayList<Integer>();
		li.add(sql.insert(ns+"addsclist", svo));
		return li;
		//return svo.getBarcode();
	}

	@Override
	public List<ScrapVO> selectScrapList(Date date) {
		return sql.selectList(ns+"sclist", date);
	}

	@Override
	public int updateQuantity(InventoryVO ivo) {
		return sql.update(ns+"modqnt", ivo);
	}

	@Override
	public int deleteInventory(List<Integer> ino) {
		return sql.delete(ns+"deliv", ino);
	}

	@Override
	public List<InventoryVO> selectInventoryList(CategoryVO cate) {
		return sql.selectList(ns+"ilist", cate);
	}

	@Override
	public List<CategoryVO> selectAllCate() {
		return sql.selectList(ns+"all");
	}

	@Override
	public int insertScrap(ScrapVO svo) {
		return sql.insert(ns+"addscrap", svo);
	}

	@Override
	public int deleteInven(int inventory_no) {
		return sql.delete(ns+"delete", inventory_no);
	}

}
