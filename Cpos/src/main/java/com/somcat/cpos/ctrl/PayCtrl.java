package com.somcat.cpos.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.PayVO;
import com.somcat.cpos.service.PayServiceIntf;
import com.somcat.cpos.service.StockScrapServiceIntf;

@Controller
@RequestMapping("/pay/*")
public class PayCtrl {
	private static Logger log = LoggerFactory.getLogger(PayCtrl.class);

	@Inject
	PayServiceIntf pssv;
	
	@Inject
	StockScrapServiceIntf ssv;

	@GetMapping("/payment")
	public void payment(Model model, HttpSession ses) {
		List<CategoryVO> llist = pssv.getcList();
		List<InventoryVO> ilist = pssv.getiList();
		model.addAttribute("iList", ilist);
		ses.setAttribute("lList", llist);
	}
	
	@ResponseBody
	@PostMapping("/qntmodify")
	public String modqnt(InventoryVO ivo) {
		int re = ssv.modifyQuantity(ivo);
		return re==1?"1":"0";
	}
	
	@ResponseBody
	@GetMapping("/receiptNoChk")
	public String receiptNoChk(@RequestParam("receipt_no") String receipt_no) {
		int isExt = pssv.chkrno(receipt_no);
		return isExt > 0 ? "1" : receipt_no;
	}
	
	

	@ResponseBody
	@PostMapping(value = "/update")
	public ResponseEntity<String> update(@RequestBody ArrayList<PayVO> pvos) throws Exception {
		int isOk = pssv.update(pvos);
		return isOk > 0 ? new ResponseEntity<>("상품 구매 완료!!", HttpStatus.OK) 
						: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}

	@GetMapping(value = "/getilist", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<InventoryVO>> ilist() {
		log.info(">>>>>>>111");
		List<InventoryVO> liList = pssv.getiList();
		log.info(">>>>>>"+liList.size());
		return new ResponseEntity<>(liList, HttpStatus.OK);
	}

	@GetMapping(value = "/getlilist/{large}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<InventoryVO>> lilist(@PathVariable("large") String large) {
		log.info("large : " + large);
		List<InventoryVO> liList = pssv.getliList(large);
		return new ResponseEntity<>(liList, HttpStatus.OK);
	}

	@GetMapping(value = "/getlmlist/{large}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<CategoryVO>> lmlist(@PathVariable("large") String large) {
		List<CategoryVO> lmList = pssv.getmList(large);
		return new ResponseEntity<>(lmList, HttpStatus.OK);
	}

	@GetMapping(value = "/getlmilist/{large}/{medium}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<InventoryVO>> lmilist(@PathVariable("large") String large,
			@PathVariable("medium") String medium) {
		CategoryVO cvo = new CategoryVO();
		cvo.setLarge(large);
		cvo.setMedium(medium);
		List<InventoryVO> lmiList = pssv.getlmiList(cvo);
		log.info(">>list::" + lmiList);
		return new ResponseEntity<>(lmiList, HttpStatus.OK);
	}
}
