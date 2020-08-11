package com.somcat.cpos.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.PayVO;

@Repository
public class PayDAO implements PayDAOIntf {
   private static Logger log = LoggerFactory.getLogger(PayDAO.class);
   private static String ns = "PayMapper.";

   @Inject
   SqlSession sql;

   @Override
   public List<InventoryVO> selectiList() {
      return sql.selectList(ns + "ilist");
   }

   @Override
   public List<CategoryVO> selectcList() {
      return sql.selectList(ns + "llist");
   }

   @Override
   public List<CategoryVO> selectmList(String large) {
      return sql.selectList(ns + "lmlist", large);
   }

   @Override
   public List<InventoryVO> selectilList(String large) {
      return sql.selectList(ns + "lilist", large);
   }

   @Override
   public List<InventoryVO> selectlmiList(CategoryVO cvo) {
      return sql.selectList(ns + "lmilist", cvo);
   }

   @Override
   public int update(List<PayVO> pvos) {
      return sql.update(ns+"update", pvos);
   }

   @Override
   public int selectrno(String receipt_no) {
      return sql.selectOne(ns+"chkrno", receipt_no);
   }
}