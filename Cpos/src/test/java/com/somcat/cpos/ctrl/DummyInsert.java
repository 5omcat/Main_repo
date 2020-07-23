package com.somcat.cpos.ctrl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somcat.cpos.domain.OrderVO;
import com.somcat.cpos.persistence.OrderDAOIntf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DummyInsert {
	
	@Inject
	OrderDAOIntf odao;
	
//	@Test
//	public void insertOrdertDummy() {
//		OrderVO ovo = new OrderVO();
//		int barcodeBase = 10000000;
//		int wrap_no = 1;
//		for (int i = 1; i < 61; i++) {
//			barcodeBase = 10000000;
//			ovo.setMember_id("testMember"+i);
//			ovo.setBarcode(barcodeBase+i);
//			ovo.setPname("상품"+i);
//			ovo.setOrder_qnt(2);
//			ovo.setWrap_no(wrap_no);
//			ovo.setExpire_term(1000);
//			odao.insertOrder(ovo);
//			wrap_no++;
//		}
//	}
	
}
