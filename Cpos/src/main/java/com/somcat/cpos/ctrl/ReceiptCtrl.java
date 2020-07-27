package com.somcat.cpos.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somcat.cpos.domain.ReceiptVO;
import com.somcat.cpos.service.ReceiptServiceIntf;

import net.sf.json.JSON;

@Controller
@RequestMapping("/receipt/*")
public class ReceiptCtrl {
	private static Logger log = LoggerFactory.getLogger(ReceiptCtrl.class);
	
	@Inject
	ReceiptServiceIntf rsv;
	
	@GetMapping("/soldlist")
	public void getReceiptList(ReceiptVO rvo, Model model) {
		log.info("msgmsg");
		List<ReceiptVO> list = null;
		log.info(rvo.getMember_id());
		if(rvo!=null) {
			log.info("get list 진입");
			list = rsv.selectReceiptList(rvo);
			log.info("list 불러옴");
		}
		if(list==null) {
			log.info(">>>> list select fail");
		}else {
			model.addAttribute("list", list);
		}
	}
	
	@GetMapping(value = "/detail/{rno}")
	@ResponseBody
	public String getReceiptDetail(@PathVariable("rno")int rno) {
		ReceiptVO rvo = rsv.selectReceiptDetail(rno);
		JSONObject obj = new JSONObject();
		obj.put("rvo", rvo);
		String str = JSONObject.toJSONString(obj);
		return str;
	}
}
