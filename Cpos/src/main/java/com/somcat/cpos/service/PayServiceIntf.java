package com.somcat.cpos.service;

import java.util.List;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.PayVO;

public interface PayServiceIntf {
   public List<CategoryVO> getcList();
   public List<InventoryVO> getiList(); 

   public List<CategoryVO> getmList(String large);
   public List<InventoryVO> getliList(String large);

   public List<InventoryVO> getlmiList(CategoryVO cvo);
   public int update(List<PayVO> pvos);
   public int chkrno(String receipt_no);
}