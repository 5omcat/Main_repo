package com.somcat.cpos.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptDAO implements ReceiptDAOIntf{
	private static Logger log = LoggerFactory.getLogger(ReceiptDAO.class);
	private static String ns = "ReceiptMapper.";
}
