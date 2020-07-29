package com.somcat.cpos.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.HeadVO;
import com.somcat.cpos.domain.InventoryVO;
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
			reAttr.addFlashAttribute("pSign", "상품등록완료");
		}
		return "redirect:/head/plist";		
	}
	
	
	@GetMapping("/pmodify")
	   public void modify(@RequestParam("barcode") int barcode, Model model,
	                  RedirectAttributes reAttr, @ModelAttribute("cri")Criterion cri) {
	      model.addAttribute("hvo", hsv.getProduct(barcode));      
	   }
	   @PostMapping("/pmodify")
	   public String modify(Model model, HeadVO hvo, Criterion cri, RedirectAttributes reAttr) {
	      int isOk = hsv.modify(hvo);
	      log.info(">>>>>"+isOk);
	      
	      if(isOk > 0) {
	         reAttr.addFlashAttribute("pSign", "상품수정완료");
	      }
	      return "redirect:/head/plist?pSign="+isOk
	            +"&barcode="+hvo.getBarcode()
	            +"&pageNum="+cri.getPageNum()
	            +"&amount="+cri.getAmount();
	   }
	
	
	/*
	 * @GetMapping("/premove") public void remove(Model model, Criterion cri) {
	 * model.addAttribute("pList", hsv.getHeadList(cri)); int totalCount =
	 * hsv.getTotalCount(); model.addAttribute("pgvo", new PagingVO(totalCount,
	 * cri)); }
	 */
	@ResponseBody
	@PostMapping("/premove")
	public String remove(@RequestParam("barcode") int barcode, RedirectAttributes reAttr, Criterion cri) {
		log.info(">>>>>>>>>>> check remove01");
		int isRm = hsv.remove(barcode);
		if(isRm > 0) {
			reAttr.addFlashAttribute("pSign", "상품삭제완료");
		}
		return "ok";
	}
	 
		
	

	//어떤 메소드를 호출하냐에 따라 보여지는 리스트가 달라지게
	@GetMapping("/plist")
	public void list(Model model, Criterion cri) {
		model.addAttribute("pList", hsv.getHeadList(cri));
		log.info(">>>>>>>>>>> check1");
		int totalCount = hsv.getTotalCount();
		model.addAttribute("pgvo", new PagingVO(totalCount, cri));
		log.info(">>>>>>>>>>> check2");
	}
	
	
	/*
	 * @GetMapping("/large") public void largelist(Model model, Criterion cri) {
	 * model.addAttribute("plList", hsv.getLargeCate(cri)); int totalCount =
	 * hsv.getTotalCount(); model.addAttribute("pgvo", new PagingVO(totalCount,
	 * cri)); }
	 * 
	 * @GetMapping("/medium") public void mediumlist(Model model, Criterion cri) {
	 * model.addAttribute("pmList", hsv.getMediumCate(cri)); int totalCount =
	 * hsv.getTotalCount(); model.addAttribute("pgvo", new PagingVO(totalCount,
	 * cri)); }
	 */
	
	@ResponseBody
	@GetMapping("/checkPname")
	public String pnameCheck(@RequestParam("pname") String pname) {
		log.debug(pname);
		int isIn = hsv.checkPname(pname);	
		log.info(isIn+"isIn");
		return isIn == 1 ? "1":"0";
	}
	
	@ResponseBody
	@GetMapping("/checkBarcode")
	public String barcodeCheck(@RequestParam("barcode") int barcode) {
		int isIn = hsv.checkBarcode(barcode);
		return isIn == 1?"1":"0";
	}
		
	
	
	



	
}
