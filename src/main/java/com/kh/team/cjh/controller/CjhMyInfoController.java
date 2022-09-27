package com.kh.team.cjh.controller;

import java.util.List;

import javax.inject.Inject;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.cjh.service.CjhCartService;
import com.kh.team.cjh.service.CjhPointService;
import com.kh.team.cjh.service.CjhUserService;
import com.kh.team.cjh.util.MyUrlUtil;
import com.kh.team.domain.CjhPagingDto;
import com.kh.team.domain.CjhPointVo;
import com.kh.team.domain.CjhUserVo;

@Controller
@RequestMapping("/cjh")
public class CjhMyInfoController { 
	
	@Inject
	private CjhUserService userService;
	@Inject
	private CjhPointService pointService;
	@Inject
	private CjhCartService cartService;
	
	@RequestMapping(value="/home")
	public String home(HttpSession session, Model model) throws Exception {
		int count = (int)session.getAttribute("count");
		model.addAttribute("count", count);
		return "redirect:/";
	}
	
	@RequestMapping(value="/index")
	public String index() throws Exception {
		return "redirect:/";
	}
	
//	@RequestMapping(value="/about")
//	public String about() throws Exception {
//		return "cjh/about";
//	}
//	
//	@RequestMapping(value="/contact")
//	public String contact() throws Exception {
//		return "cjh/contact";
//	}
//	
//	@RequestMapping(value="/shop_single")
//	public String shop_single() throws Exception {
//		return "cjh/shop_single";
//	}
//	
//	@RequestMapping(value="/shop")
//	public String shop() throws Exception {
//		return "cjh/shop";
//	}
	
	//	결제완료 폼
	@RequestMapping(value="/thankyou")
	public String thankyou() throws Exception {
		return "cjh/thankyou";
	}
	
	
	//	로그인 폼
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void loginget(String targetLocation, HttpSession session) throws Exception {
		System.out.println("targetLocation:" + targetLocation);
		session.setAttribute("targetLocation", targetLocation);
	}
	
//	로그인 처리 폼
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(String u_id, String u_pw,
							HttpSession session, RedirectAttributes rttr) throws Exception {
//		System.out.println("u_id : " + u_id);
//		System.out.println("u_pw : " + u_pw);
		boolean result = userService.login(u_id, u_pw);
		int count = cartService.getCountCart(u_id);
		if (result == true) {
			//	해당 사용자가 있다면 아이디를 세션에 저장
			session.setAttribute("u_id", u_id);
			session.setAttribute("count", count);
			String targetLocation = (String)session.getAttribute("targetLocation");
			if (targetLocation != null && !targetLocation.equals("")) {
				session.removeAttribute("targetLocation");
				return "redirect:" + targetLocation;
			}
			return "redirect:/";
		}
		rttr.addFlashAttribute("msg", "fail");
		return "redirect:/jm/jm_login";
	}
	
	//	비밀번호 확인 폼
	@RequestMapping(value = "/pwCheck", method = RequestMethod.GET)
	public void pwCheckGet() throws Exception {
	}
	
	//	비밀번호 확인 처리
	@RequestMapping(value = "/pwCheck", method = RequestMethod.POST)
	public String pwCheckPost(String u_id, String u_pw, Model model, RedirectAttributes rttr) throws Exception {
//		System.out.println("u_id : " + u_id);
//		System.out.println("u_pw : " + u_pw);
		boolean result = userService.login(u_id, u_pw);
		if (result == true) {
			CjhUserVo userVo = userService.selectUser(u_id);
			model.addAttribute("userVo", userVo);
			return "/cjh/modifyMyInfo";
		} else {
			rttr.addFlashAttribute("msg", "fail");
			return "redirect:/cjh/pwCheck";
		}
	}
	
	//	회원정보 수정 폼
	@RequestMapping(value="/modifyMyInfo", method = RequestMethod.GET)
	public void modifyMyInfoGet(Model model, HttpSession session) throws Exception {
//		System.out.println("u_id : " + u_id);
		String u_id = (String)session.getAttribute("u_id");
		CjhUserVo userVo = userService.selectUser(u_id);
//		System.out.println("userVo : " + userVo);
		model.addAttribute("userVo", userVo);
	}
	
	//	회원정보 수정처리
	@RequestMapping(value="/modifyMyInfo", method = RequestMethod.POST)
	public String modifyMyInfoPost(CjhUserVo userVo) throws Exception {
//		System.out.println("userVo : " + userVo);
		String url = MyUrlUtil.makeUrl("/cjh/modifyMyInfo", userVo.getU_id());
		userService.updateUser(userVo);
		return "redirect:" + url; 
	}
	
	//	로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();		//	세션 무효화 -> 로그아웃
		return "redirect:/cjh/index";
	}
	
	//	마이페이지
	@RequestMapping(value="/mypage", method = RequestMethod.GET)
	public void mypage(Model model, HttpSession session) throws Exception {
		String u_id = (String)session.getAttribute("u_id");
		int u_point = pointService.getUserPoint(u_id);
		int totalPoint = pointService.getTotalPoint(u_id);
		int usePoint = pointService.getUsePoint(u_id);
		int oCount = cartService.getUserOrder(u_id);
		model.addAttribute("oCount", oCount);
		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("usePoint", usePoint);
		model.addAttribute("u_point", u_point);
	}
	
	//	적립금 페이지
	@RequestMapping(value="/myPoint", method = RequestMethod.GET)
	public void myPoint(int point_code, CjhPagingDto pagingDto, Model model, HttpSession session) throws Exception {
		pagingDto.setPageInfo();
		String u_id = (String)session.getAttribute("u_id");
		int totalCount = pointService.getPointCount(u_id, point_code);
		pagingDto.setTotalCount(totalCount);
		List<CjhPointVo> list = pointService.listPoint(u_id, point_code, pagingDto);
		model.addAttribute("list", list);
		model.addAttribute("point_code", point_code);
		model.addAttribute("pagingDto", pagingDto);
	}
	
	@RequestMapping(value="/quitUser", method = RequestMethod.GET)
	public String quitUser(HttpSession session, String u_pw, RedirectAttributes rttr) throws Exception {
		String u_id = (String) session.getAttribute("u_id");
		int check = userService.checkPw(u_id, u_pw);
		if (check > 0 ) {
			userService.quitUser(u_id);
			session.invalidate();
			rttr.addFlashAttribute("msg", "success");
			return "redirect:/jm/jm_login";
		} else {
			rttr.addFlashAttribute("msg", "fail");
			return "redirect:/cjh/modifyMyInfo";
		}
	}
	
}