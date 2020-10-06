package com.somcat.cpos.ctrl;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.InventoryDTO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.PagingVO;
import com.somcat.cpos.domain.ScrapVO;
import com.somcat.cpos.service.StockScrapServiceIntf;


@Controller
@RequestMapping("/stockscrap/*")
public class StockScrapCtrl {
	private static Logger log = LoggerFactory.getLogger(StockScrapCtrl.class);

	@Inject
	StockScrapServiceIntf ssv;

	  @GetMapping("/ssmenu") 
	  public void stockscrap() {
	  
	  }
	  
	  @GetMapping("/new") 
	  public void add(InventoryVO ivo) {
		  ivo.setMember_id("pos1");
	  }
	  
	  
//	  @ResponseBody
//	  @RequestMapping(value="/new")
//	  public String addInven(@RequestBody ArrayList<InventoryVO> jsonData) throws Exception{
//		  if(jsonData.size() != 0) {
//		  int a = ssv.addInventory(jsonData);
//		  return a==1?"1":a+"";
//		  }else return "Inventory add clear";
//	  }
	  
	  @GetMapping("/inventory") 
	  public void inventory(Model model, Criterion cri) {
		  //log.info(">>>cri="+cri.getPageNum());
	   	  model.addAttribute("cate", ssv.getAllCate());
	   	  cri.setCate(new CategoryVO());
		  //model.addAttribute("iList", ssv.getInvenList(cri));
		  int totalCount = ssv.getTotalCount(cri);
		  model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	  }
	  
	  @GetMapping("/exscrap") 
	  public void exscrap(Criterion cri, Model model) {
		  model.addAttribute("cate", ssv.getAllCate());
		  cri.setCate(new CategoryVO());
		  cri.setToday(new Date());
		  model.addAttribute("iList", ssv.getInvenList2(cri));
		  int totalCount = ssv.getTotalCount(cri);
		  model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	  }
	  
	  @GetMapping(value = "/getExList/{large}/{medium}/{page}", produces = {
			  MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	  public ResponseEntity<InventoryDTO> exlist(
			  @PathVariable("large") String large,
			  @PathVariable("medium") String medium,
			  @PathVariable("page")int page) { 
		  Criterion cri = new Criterion(page,7);
		  cri.setCate(new CategoryVO(large, medium));
		  cri.setToday(new Date());
		  InventoryDTO bList = ssv.getInvenList2(cri); 
		  return new ResponseEntity<>(bList, HttpStatus.OK); 
		  }
	  
	  @ResponseBody
	  @PostMapping("/qntmodify")
		public String modqnt(InventoryVO ivo) {
			int re = ssv.modifyQuantity(ivo);
			return re==1?"1":"0";
		}
	  
	  @GetMapping(value = "/getIlist/{large}/{medium}/{page}", produces = {
			  MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	  public ResponseEntity<InventoryDTO> list(
			  @PathVariable("large") String large,
			  @PathVariable("medium") String medium,
			  @PathVariable("page")int page) { 
		  Criterion cri = new Criterion(page,7);
		  cri.setCate(new CategoryVO(large, medium));
		  InventoryDTO bList = ssv.getInvenList(cri); 
		  //log.info(">>list::" + bList);
		  return new ResponseEntity<>(bList, HttpStatus.OK); 
		  }
	  
	  @ResponseBody
	  @RequestMapping(value="/allScrap")
	  public String allscrap(@RequestBody ArrayList<ScrapVO> jsonData) throws Exception{
		  if(jsonData.size() != 0) {
		  int a = ssv.addScrap(jsonData);
		  return a==1?"1":a+"";
		  }else return "Scrap clean";
	  }
	  
	  @PostMapping("/scraplist") 
	  public String scrapAdd(List<ScrapVO> iList) {
		  ssv.addScrap(iList); 
		  return "redirect:/stockscrap/inventory"; 
		  }
	  
	  @ResponseBody
	  @PostMapping("/scrap")
	  public String scrap(ScrapVO svo) {
		  int result = ssv.addScrap(svo);
		  return result==1?"1":"0";
	  }
}
