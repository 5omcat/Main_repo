package com.somcat.cpos.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.OrderVO;
import com.somcat.cpos.service.OrderServiceIntf;

@Controller
@RequestMapping("/order/*")
public class OrderCtrl {
	private static Logger log = LoggerFactory.getLogger(OrderCtrl.class);

	@Inject
	OrderServiceIntf osv;
	
	@GetMapping(value = "/orderlist/{member_id}/{flag_hdate}/{flag_tdate}/{page}")
	public String orderlist(@PathVariable("member_id")String member_id, 
			@PathVariable("flag_hdate")String flag_hdate,
			@PathVariable("flag_tdate")String flag_tdate,
			@PathVariable("page")int page, Model model){
		Criterion cri = new Criterion(page, 10);
		OrderVO ovo = new OrderVO(member_id, flag_hdate, flag_tdate);
		List<OrderVO> ordL = osv.getList(cri, ovo);
		model.addAttribute("ordL", ordL);
		model.addAttribute("pgvo", ordL);
		return "order/orderlist";
	}
	
	@GetMapping("/order")
	public void order() {
	}
	
	@PostMapping("/order")
	public void order(RequestBody reqb, OrderVO ovo){
		osv.registOrder(ovo);
	}
}
