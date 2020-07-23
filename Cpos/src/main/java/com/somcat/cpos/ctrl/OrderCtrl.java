package com.somcat.cpos.ctrl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/orderlist")
	public void orderlist() {
	}
	
//	@GetMapping(value = "/list/{pno}/{page}",
//			produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
//	public ResponseEntity<CommentDTO> list(@PathVariable("pno")int pno,
//			@PathVariable("page") int page){
//		//List<CommentVO> cList = (List<CommentVO>) csv.getList(pno);
//		Criterion cri = new Criterion(page, 10);
//		
//		return new ResponseEntity<CommentDTO>(csv.getList(cri, pno),HttpStatus.OK);
//	}
	
	@PostMapping("/orderlist/{member_id}/{order_date}/{page}",
		produce = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<OrderVO>> orderlist(@PathVariable("member_id")String member_id, @PathVariable("order_date")Date order_date,
			@PathVariable("page")int page){
		Criterion cri = new Criterion(page, 10);
		return new ResponseEntity<List<OrderVO>>(osv.getList(cri, member_id, order_date), HttpStatus.OK);
		
	}
	
	@GetMapping("/order")
	public void order() {
	}
	
	@PostMapping("/order")
	public void order(RequestBody reqb, OrderVO ovo){
		osv.registOrder(ovo);
	}
}
