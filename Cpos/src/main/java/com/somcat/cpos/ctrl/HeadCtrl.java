package com.somcat.cpos.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.somcat.cpos.service.HeadServiceIntf;

@Controller
@RequestMapping("/head/*")
public class HeadCtrl {

	private static Logger log = LoggerFactory.getLogger(HeadCtrl.class);	
	
	@Inject
	HeadServiceIntf hsv;	
	
	@GetMapping("/plist")
	public void plist() {
		
	}
	
}
