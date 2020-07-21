package com.somcat.cpos.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.somcat.cpos.service.OrderServiceIntf;

@Controller
@RequestMapping("/order/*")
public class OrderCtrl {
	private static Logger log = LoggerFactory.getLogger(OrderCtrl.class);

	@Inject
	OrderServiceIntf osv;

}
