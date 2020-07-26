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
import org.springframework.web.bind.annotation.RequestParam;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.OrderVO;
import com.somcat.cpos.domain.PagingVO;
import com.somcat.cpos.service.OrderServiceIntf;

@Controller
@RequestMapping("/order")
public class OrderCtrl {
	private static Logger log = LoggerFactory.getLogger(OrderCtrl.class);

	@Inject
	OrderServiceIntf osv;
	
	
	@GetMapping(value="/orderlist")
	public void list(Model model, Criterion cri, @RequestParam(value = "flag_hdate", required = false)
			String flag_hdate, @RequestParam(value = "flag_tdate", required = false)
			String flag_tdate, @RequestParam(value = "member_id", required = false)
			String member_id) {
		OrderVO ovo = new OrderVO(member_id, flag_hdate, flag_tdate);
		model.addAttribute("ordL", osv.getList(cri, ovo));
		int totalCount = osv.getTotalCount(cri, ovo);
		model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	}
	
	
	@GetMapping("/order")
	public void order() {
	}
	
	@GetMapping("/ons")
	public void ons() {
	}
	
//	@PostMapping("/order")
//	public void order(RequestBody reqb, OrderVO ovo){
//		osv.registOrder(ovo);
//	}
}
