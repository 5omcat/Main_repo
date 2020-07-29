package com.somcat.cpos.ctrl;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.persistence.StockScrapDAOIntf;

public class JDBCTest {
	private static Logger log = LoggerFactory.getLogger(JDBCTest.class);
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testConnection() {
//		try (Connection cn =
//				DriverManager.getConnection(
//						"jdbc:oracle:thin:@localhost:1521:XE", "jspuser", "oracle")){
//			log.info(">>> jdbc test ok : " + cn);
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
//	}	
//		@Inject
//		private StockScrapDAOIntf sdao;
		
//		@Test
//		public void test() {
//			Date date = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			sdf.format(date);
//			//java.util.Date u = new java.util.Date();
//			java.sql.Date sdate = new java.sql.Date(date.getTime());
//
//			for(int i=0; i<20; i++) {
//				InventoryVO ivo = new InventoryVO();
//				ivo.setMember_id("pos1");
//				ivo.setBarcode(i+1000);
//				ivo.setInv_qnt(1);
//				ivo.setPname("라면"+i);
//				ivo.setCategory(3002);
//				ivo.setGet_price(1000);
//				ivo.setSell_price(2000);
//				ivo.setExpire_date(sdate);
//				ivo.setDiscount_rate(10);
//				
//				//log.info(ivo.toString());
//				sdao.insertInventory(ivo);
//			}
//		}

}
