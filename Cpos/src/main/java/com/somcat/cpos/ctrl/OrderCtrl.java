package com.somcat.cpos.ctrl;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

=======
>>>>>>> a42b0b834f30d2940628d1ba2bc9ded18df5e90a
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;

import com.somcat.cpos.domain.Criterion;
import com.somcat.cpos.domain.MemberVO;
import com.somcat.cpos.domain.OrderVO;
import com.somcat.cpos.domain.PagingVO;
import com.somcat.cpos.service.OrderServiceIntf;
=======
>>>>>>> a42b0b834f30d2940628d1ba2bc9ded18df5e90a

@Controller
@RequestMapping("/order")
public class OrderCtrl {
	private static Logger log = LoggerFactory.getLogger(OrderCtrl.class);

	@Inject
	OrderServiceIntf osv;

	@GetMapping(value = "/orderlist")
	public void list(Model model, Criterion cri,
			@RequestParam(value = "flag_hdate", required = false) String flag_hdate,
			@RequestParam(value = "flag_tdate", required = false) String flag_tdate,
			@RequestParam(value = "member_id", required = false) String member_id) {
		if (flag_hdate.length() < 1 && flag_tdate.length() < 1) {
			SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
			flag_tdate = format1.format(System.currentTimeMillis());
			flag_hdate = String.valueOf(Integer.parseInt(flag_tdate)-7);
		}
		if (flag_hdate.length()<9) {
			flag_hdate += "000000";
			flag_tdate += "235959";
		}
		if (member_id.length() < 1) {
			MemberVO mvo = new MemberVO("testMember1", "1234", "신논현1호점", 0);
			member_id = mvo.getMember_id();
		}
		OrderVO ovo = new OrderVO(member_id, flag_hdate, flag_tdate);
		cri.setAmount(osv.getAmount(ovo,cri.getPageNum()));
		if (cri.getPageNum()==1) {
			cri.setUnderamount(0);
		}else {
			cri.setUnderamount(osv.getUnderAmount(ovo, cri.getPageNum()));
		}
		List<List<OrderVO>> ordWL = osv.getList(cri, ovo);
		model.addAttribute("ordWL", ordWL);
		model.addAttribute("infOvo", ovo);
		int totalCount = osv.getTotalCount(ovo);
		model.addAttribute("pgvo", new PagingVO(totalCount, cri));
	}

	@GetMapping("/order")
	public void order() {
	}

	@GetMapping("/ons")
	public void ons() {

	}

	@GetMapping("/cal")
	public void cal() {

	}

//	@PostMapping("/order")
//	public void order(RequestBody reqb, OrderVO ovo){
//		osv.registOrder(ovo);
//	}
}
