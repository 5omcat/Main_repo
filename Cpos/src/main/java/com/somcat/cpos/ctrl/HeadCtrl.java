package com.somcat.cpos.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.domain.PagingVO;
import com.somcat.cpos.service.HeadServiceIntf;

@Controller
@RequestMapping("/head/*")
public class HeadCtrl {

	private static Logger log = LoggerFactory.getLogger(HeadCtrl.class);	
	
	@Inject
	HeadServiceIntf hsv;	
	
	@GetMapping("/pregist")
	public void regist() {
		
	}
	@PostMapping("/pregist")
	public String regist(RedirectAttributes reAttr, HeadVO hvo) {
		int isFull = hsv.regist(hvo);
		if(isFull > 0 ) {
			reAttr.addFlashAttribute("hSign", "상품등록완료");
		}
		return "redirect:/head/plist";		
	}
	
	
	/*
	 * @GetMapping("/pmodify") public void modify(){
	 * 
	 * }
	 */
	@PostMapping("/pmodify")
	public String modify(Model model, HeadVO hvo) {
		int isOk = hsv.modify(hvo);
		if(isOk > 0) {
			model.addAttribute("hvo", hvo);
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/premove")
	public void remove() {
		
	}
	//@PostMapping("/premove")
	 
		
	

	//어떤 메소드를 호출하냐에 따라 보여지는 리스트가 달라지게
	@GetMapping("/plist")
	public void list(Model model, Criterion cri) {
		model.addAttribute("pList", hsv.getHeadList(cri));
		int totalCount = hsv.getTotalCount(cri);
		model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	}


	
}
