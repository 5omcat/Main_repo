package com.somcat.cpos.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.PayVO;
import com.somcat.cpos.persistence.PayDAOIntf;

@Service
public class PayService implements PayServiceIntf {
   private static Logger log = LoggerFactory.getLogger(PayService.class);

   @Inject
   PayDAOIntf psdao;

   @Override
   public List<InventoryVO> getiList() {
      return psdao.selectiList();
   }

   @Override
   public List<CategoryVO> getcList() {
      return psdao.selectcList();
   }

   @Override
   public List<CategoryVO> getmList(String large) {
      return psdao.selectmList(large);
   }

   @Override
   public List<InventoryVO> getliList(String large) {
      return psdao.selectilList(large);
   }

   @Override
   public List<InventoryVO> getlmiList(CategoryVO cvo) {
      return psdao.selectlmiList(cvo);
   }

   @Override
   public int update(List<PayVO> pvos) {
      return psdao.update(pvos);
   }

   @Override
   public int chkrno(String receipt_no) {
      return psdao.selectrno(receipt_no);
   }

}