package com.somcat.cpos.ctrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.domain.OrderVO;
import com.somcat.cpos.domain.PagingVO;
import com.somcat.cpos.service.HeadServiceIntf;
import com.somcat.cpos.service.OrderServiceIntf;

@Controller
@RequestMapping("/order")
public class OrderCtrl {
	private static Logger log = LoggerFactory.getLogger(OrderCtrl.class);

	@Inject
	OrderServiceIntf osv;

	@Inject
	HeadServiceIntf ssv;

	@GetMapping(value = "/orderlist")
	public void list(Model model, Criterion cri,
			@RequestParam(value = "flag_hdate", required = false) String flag_hdate,
			@RequestParam(value = "flag_tdate", required = false) String flag_tdate,
			@RequestParam(value = "member_id", required = true) String member_id) {
		if (flag_hdate.length() < 1 && flag_tdate.length() < 1) {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
			flag_tdate = format1.format(System.currentTimeMillis());
			flag_hdate = String.valueOf(Integer.parseInt(flag_tdate) - 7);
		}
		if (flag_hdate.length() < 10 && flag_tdate.length() <10) {
			flag_hdate += "000000";
			flag_tdate += "235959";
		}
		OrderVO ovo = new OrderVO(member_id, flag_hdate, flag_tdate);
		log.info("cri.getPageNum:"+cri.getPageNum());
		log.info("osv.getAmount(ovo, cri.getPageNum()):"+osv.getAmount(ovo, cri.getPageNum()));
		cri.setAmount(osv.getAmount(ovo, cri.getPageNum()));
		log.info("cri.getAmount:"+cri.getAmount());
		if (cri.getPageNum() == 1) {
			cri.setUnderamount(0);
		} else {
			cri.setUnderamount(osv.getUnderAmount(ovo, cri.getPageNum()));
		}
		List<List<OrderVO>> ordWL = osv.getList(cri, ovo);
		model.addAttribute("ordWL", ordWL);
		model.addAttribute("infOvo", ovo);
		int totalCount = osv.getTotalCount(ovo);
		model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	}

	@GetMapping(value = "/getHList/{category}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<HeadVO>> getHList(@PathVariable("category") int category) throws Exception {
		List<HeadVO> hList = (List<HeadVO>) ssv.getHList(category);
		log.info("hList size:" + hList.size());
		return new ResponseEntity<>(hList, HttpStatus.OK);
	}

	@GetMapping(value = "/getMCtgs/{large}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<CategoryVO>> getMCtgs(@PathVariable("large") String large) throws Exception {
		List<CategoryVO> mCtgs = (List<CategoryVO>) osv.getMCtgs(large);
		return new ResponseEntity<>(mCtgs, HttpStatus.OK);
	}

	@GetMapping(value = "/getHVO/{barcode}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<HeadVO> getHVO(@PathVariable("barcode") int barcode) throws Exception {
		HeadVO hvo = ssv.getProduct(barcode);
		return new ResponseEntity<>(hvo, HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping(value = "/registOrder")
	public ResponseEntity<String> registOrder(@RequestBody List<OrderVO> ovos) throws Exception {
		int isOk = osv.registOrder(ovos);
		return isOk > 0 ? new ResponseEntity<>("발주등록이 완료됐습니다.", HttpStatus.OK) 
						: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@GetMapping(value = "/order")
	public void order() {
	}

	@GetMapping(value = "/ons")
	public void ons() {

	}

	
	@ResponseBody
	@GetMapping(value = "/getWrpno")
	public ResponseEntity<String> getWrpno() throws Exception {
		String wrpno = String.valueOf(osv.getWrapno());
		return new ResponseEntity<>(wrpno, HttpStatus.OK);
	}
	
	@ResponseBody
	@PostMapping(value = "/changeStatus")
	public ResponseEntity<String> changeStatus(@RequestParam("wrap_no") int wrap_no, @RequestParam("status") int status) throws Exception {
				log.info("wrap_no:"+wrap_no);
				log.info("status:"+status);
				int isOk = osv.changeOrderStatus(wrap_no, status);
		return isOk > 0 ? new ResponseEntity<>("오케이",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
