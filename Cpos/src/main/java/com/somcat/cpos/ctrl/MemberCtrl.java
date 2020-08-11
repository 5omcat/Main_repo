package com.somcat.cpos.ctrl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.service.MemberServiceIntf;

@Controller
@RequestMapping({"/member/*", "/store/*"})
public class MemberCtrl {
	private static Logger log = LoggerFactory.getLogger(MemberCtrl.class);
	
	@Inject
	MemberServiceIntf msv;
	
	@GetMapping("/nav")
	public void nav() {
		
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@PostMapping("/join")
	public String join(MemberVO mvo, RedirectAttributes reAttr) {
		int isOk = msv.regist(mvo);
		log.debug(">>> isOk : "+ isOk);
		log.debug(isOk==1? "Register Success" : "Register Fail");
		reAttr.addFlashAttribute("msg", "회원 가입이 완료되었습니다");
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(MemberVO mvo, HttpServletRequest req, RedirectAttributes reAttr){
		MemberVO minfo = msv.login(mvo);
		HttpSession ses = req.getSession();
		if(minfo != null) {
			ses.setAttribute("mvo", minfo);
			log.info(">>>>"+minfo.getMember_id());
			if(minfo.getOpt()==0) {
				return "/head/fourmenu";
			}else if(minfo.getOpt()==1) {
				return "/head/headmenu";
			}
		}else {
			reAttr.addFlashAttribute("msg", "로그인에 실패했습니다");
			return "redirect:/member/login";
		}
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/dupleIdCheck")
	public String checkId(@RequestParam("member_id")String member_id) {
		log.info("idcheck start");
		int isExt = msv.checkId(member_id);
		return isExt == 1 ? "1" : "0";
	}
	
	@GetMapping("/list")
	public void list(Model model, Criterion cri) {
		List<MemberVO> list = msv.getList(cri);
		model.addAttribute("list", list);
	}
	
	@GetMapping("/resign")
	public String resign(@RequestParam("id")String id, @RequestParam("ses")String ses_id,RedirectAttributes reAttr, HttpSession ses) {
		int isRm = msv.resign(id);
		if(isRm > 0) {
			if(id.equals(ses_id)) {
				ses.invalidate();
			}
			reAttr.addFlashAttribute("msg", "회원 탈퇴가 완료되었습니다");
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession ses) {
		ses.invalidate();
		return "redirect:/";
	}
}
