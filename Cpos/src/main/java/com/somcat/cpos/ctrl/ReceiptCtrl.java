package com.somcat.cpos.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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


@Controller
@RequestMapping("/receipt/*")
public class ReceiptCtrl {
	private static Logger log = LoggerFactory.getLogger(ReceiptCtrl.class);
	
	@Inject
	ReceiptServiceIntf rsv;
	
	@GetMapping("/soldlist")
	public void getReceiptList(ReceiptVO rvo, Model model) throws ParseException {
		log.info("msgmsg");
		List<ReceiptVO> list = null;
		Calendar cal = Calendar.getInstance();
		log.info("rvo 정보 생성");
		String member_id = "";
		cal.set(1999, Calendar.JANUARY, 1);
		Date sell_date_s = new Date(cal.getTimeInMillis());
		Date sell_date_e = new Date();
		int division = -1;
		rvo = new ReceiptVO(member_id, "null", sell_date_s, sell_date_e, division);
		log.info(rvo.getPay_method()+" "+rvo.getSell_date_s()+" "+rvo.getSell_date_e());
		
		list = rsv.selectReceiptList(rvo);
		if(list==null) {
			log.info(">>>> list select fail");
		}else {
			for(int i=0; i<list.size(); i++) {
				log.info(list.get(i).getPay_method());
				log.info(list.get(i).getPname());
				log.info(list.get(i).getReceipt_no());
			}
			
			model.addAttribute("list", list);
		}
	}
	
	@GetMapping("/list")
	@ResponseBody
	public String searchList(ReceiptVO rvo) throws ParseException {
		List<ReceiptVO> list = null;
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		log.info("get list 진입");
//		String sell_date_s = format.format(rvo.getSell_date_s());
//		String sell_date_e = format.format(rvo.getSell_date_e());
		Date s_date = format.parse(rvo.getStr_date_s());
		Date e_date = format.parse(rvo.getStr_date_e());
		rvo.setSell_date_s(s_date);
		rvo.setSell_date_e(e_date);
//		log.info(s_date+" : "+e_date);
		JSONObject obj = new JSONObject();
		obj.put("list", list);
		String str = JSONObject.toJSONString(obj);
		return str;
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
