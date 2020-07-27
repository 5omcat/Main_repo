package com.somcat.cpos.ctrl;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.persistence.StockScrapDAOIntf;

public class JDBCTest {
	private static Logger log = LoggerFactory.getLogger(JDBCTest.class);
	
	@Inject
	private StockScrapDAOIntf sdao;
	
	@Test
	public void test() {
		//Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//sdf.format(date);
		for(int i=0; i<20; i++) {
			InventoryVO ivo = new InventoryVO();
			ivo.setMember_id("pos1");
			ivo.setBarcode(i);
			ivo.setPname("과자"+i);
			ivo.setCategory(2002);
			ivo.setGet_price(1000);
			ivo.setSell_price(2000);
			//ivo.setExpire_date(date);
			ivo.setDiscount_rate(10);
			
			log.info(ivo.getExpire_date().toString());
		}
	}
}
