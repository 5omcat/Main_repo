package com.somcat.cpos.ctrl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.service.PayService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/pay/**")
public class PayCtrl {
	private static Logger log = LoggerFactory.getLogger(PayCtrl.class);

	@Inject
	PayService pssv;

	@GetMapping("/category")
	public String category(Model model, HttpSession ses) {
		List<CategoryVO> llist = pssv.getcList();
		List<InventoryVO> ilist = pssv.getiList();
		model.addAttribute("iList", ilist);
		ses.setAttribute("lList", llist); 
		return "pay/payment";
	}

	@GetMapping(value="/lmlist")
	public String lmlist(@RequestParam("large") String large, Model model, HttpSession ses) {
		List<InventoryVO> lilist = pssv.getliList(large);
		List<CategoryVO> lmlist = pssv.getmList(large);
		model.addAttribute("liList", lilist);
		ses.setAttribute("lmList", lmlist); 
		return "pay/payment";
	}
	
	@GetMapping("/lmilist")
	public String lmilist(CategoryVO cvo, Model model) {
		List<InventoryVO> lmilist = pssv.getlmiList(cvo);
		model.addAttribute("lmiList", lmilist);
		return "pay/payment";
	}
	
	@ResponseBody
	@GetMapping(value = "/shoppinglist",
				produces = {MediaType.APPLICATION_ATOM_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public void shoppinglist(@RequestBody List<Map> shoppinglist) {
		JSONObject obj = JSONObject.fromObject(shoppinglist);
	}
	

	/*
	 * @GetMapping("lmilist") public String lmilist(@RequestParam("large") String
	 * large,
	 * 
	 * @RequestParam("medium") String medium, Model model) { List<InventoryVO>
	 * lmilist = pssv.getlmiList(large, medium); model.addAttribute("lmiList",
	 * lmilist); return "pay/payment"; }
	 */
	
	

}
