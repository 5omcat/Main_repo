package com.somcat.cpos.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somcat.cpos.domain.CategoryVO;
import com.somcat.cpos.domain.InventoryVO;
import com.somcat.cpos.domain.ScrapVO;
import com.somcat.cpos.domain.SearchVO;
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
	  public void add() {
		  
	  }
	  
	  @GetMapping("/inventory") 
	  public void inventory(Model model) {
	  model.addAttribute("cate", ssv.getAllCate()); 
	  CategoryVO cate = new CategoryVO(); 
	  model.addAttribute("iList", ssv.getInvenList(cate)); 
	  }
	  
	  @GetMapping("/exscrap") 
	  public void exscrap(Locale locale, Model model) {
		  model.addAttribute("cate", ssv.getAllCate());
		  SearchVO svo = new SearchVO(new CategoryVO(), new Date());
		  model.addAttribute("iList", ssv.getInvenList2(svo));
	  }
	  
	  @GetMapping(value = "/getExList/{large}", produces = {
			  MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	  public ResponseEntity<List<InventoryVO>> exlist(@PathVariable("large") String large) { 
		  CategoryVO cvo = new CategoryVO(large); // cvo.setLarge(large);
		  log.info(">>>" + cvo.getLarge()); 
		  SearchVO svo = new SearchVO(cvo, new Date());
		  List<InventoryVO> bList = ssv.getInvenList2(svo); 
		  return new ResponseEntity<>(bList, HttpStatus.OK); 
		  }
	  
	  @GetMapping(value = "/getExList/{large}/{medium}", produces = {
			  MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	  public ResponseEntity<List<InventoryVO>> exlist(
			  @PathVariable("large") String large,
			  @PathVariable("medium") String medium) { 
		  CategoryVO cvo = new CategoryVO();
		  cvo.setLarge(large); 
		  cvo.setMedium(medium);
		  SearchVO svo = new SearchVO(cvo, new Date());
		  ArrayList<InventoryVO> bList = (ArrayList<InventoryVO>) ssv.getInvenList2(svo); 
		  return new ResponseEntity<>(bList, HttpStatus.OK); 
		  }
	  
	  @ResponseBody
	  @PostMapping("/qntmodify")
		public String modqnt(InventoryVO ivo) {
			int re = ssv.modifyQuantity(ivo);
			return re==1?"1":"0";
		}
	  
	/*
	 * @PostMapping("/getIlist") public List<InventoryVO> getIlist(CategoryVO cate){
	 * log.info(">>>cate12:"+cate.getLarge()); return ssv.getInvenList(cate); }
	 */
	  
	  
	  @GetMapping(value = "/getIlist/{large}", produces = {
			  MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	  public ResponseEntity<List<InventoryVO>> list(@PathVariable("large") String large) { 
		  CategoryVO cvo = new CategoryVO(large); // cvo.setLarge(large);
		  log.info(">>>" + cvo.getLarge()); 
		  List<InventoryVO> bList = ssv.getInvenList(cvo); 
		  log.info(">>list::" + bList.get(0).getExpire_date()); 
		  return new ResponseEntity<>(bList, HttpStatus.OK); 
		  }
	  
	  @GetMapping(value = "/getIlist/{large}/{medium}", produces = {
			  MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	  public ResponseEntity<List<InventoryVO>> list(
			  @PathVariable("large") String large,
			  @PathVariable("medium") String medium) { 
		  CategoryVO cvo = new CategoryVO();
		  cvo.setLarge(large); 
		  cvo.setMedium(medium); 
		  ArrayList<InventoryVO> bList = (ArrayList<InventoryVO>) ssv.getInvenList(cvo); 
		  log.info(">>list::" + bList);
		  return new ResponseEntity<>(bList, HttpStatus.OK); 
		  }
	  
	  @ResponseBody
	  @RequestMapping(value="/allScrap")
	  public String allscrap(@RequestBody ArrayList<ScrapVO> jsonData) throws Exception{
		  log.info(">>>>>>>>>> allScrap: "+jsonData.size());
		  //log.info(">>>>>>>>>> jsonData-pname: "+jsonData.get(0).getPname());
		  //log.info(">>>>>>>>>> jsonData-exdate: "+jsonData.get(0).getExpire_date());
		  //log.info(">>>>>>>>>> jsonData-member_id: "+jsonData.get(0).getMember_id());
		  //log.info("svo가 있을까?=>>>>>>"+jsonData.toString());
		  
		  if(jsonData.size() != 0) {
		  int a = ssv.addScrap(jsonData);
		  return a==1?"1":a+"";
		  }
		  else
			  return "폐기처리할 상품 없음";
	  }
	  
	  @PostMapping("/scraplist") 
	  public String scrapAdd(List<ScrapVO> iList) {
		  ssv.addScrap(iList); 
		  return "redirect:/stockscrap/inventory"; 
		  }
	  
	  @ResponseBody
	  @PostMapping("/scrap")
	  public String scrap(ScrapVO svo) {
		  Date d = svo.getExpire_date();
		  svo.setMember_id("pos2");
		  log.info("ino="+svo.getIno());
		  log.info("date="+d);
		  int result = ssv.addScrap(svo);
		  log.info(">>>d="+result);
		  return result==1?"1":"0";
	  }
}
