package com.kh.team.cjh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.cjh.service.CjhCartService;
import com.kh.team.cjh.service.CjhPointService;
import com.kh.team.cjh.service.CjhUserService;
import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.CjhPagingDto;
import com.kh.team.domain.CjhUserVo;
import com.kh.team.domain.LshBoardVo;
import com.kh.team.lsh.service.LSH_BoardService;

@Controller
@RequestMapping("/cjh")
public class CjhCartController {
	
	@Inject
	private CjhCartService cartService;
	@Inject
	private CjhPointService pointService;
	@Inject
	private LSH_BoardService boardService;
	@Inject
	private CjhUserService userService;
	
	//	장바구니에 추가
	@RequestMapping(value="/insertCart", method=RequestMethod.POST)
	@ResponseBody
	public String insertCart(@RequestParam(value="p_num") int p_num,
							 @RequestParam(value="countArr") int[] countArr,
							 @RequestParam(value="sizeArr") String[] sizeArr,
							 HttpSession session, Model model) throws Exception {
//		System.out.println("p_num : " + p_num); 
//		for (int count : countArr) {
//			System.out.println("count : " + count);
//		}
//		for (String size : sizeArr) {
//			System.out.println("size : " + size);
//		}
		LshBoardVo boardVo = boardService.single(p_num);
//		String p_serve = boardService.getServe(p_num);
//		String targetLocation = "/lsh/shop_single?p_num="+p_num+"&p_serve="+p_serve;
		System.out.println("boardVo : " + boardVo);
//		System.out.println(session.getAttribute("u_id"));
//		session.setAttribute("targetLocation", targetLocation);
		String u_id = (String)session.getAttribute("u_id");
		model.addAttribute("u_id", u_id);
		cartService.insertCart(u_id, countArr, sizeArr, boardVo);
		
		int count = cartService.getCountCart(u_id);
		session.setAttribute("count", count);
		return "success";
	}
	
	//	장바구니 목록보기
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String cart(Model model, HttpSession session) throws Exception {
		String u_id = (String)session.getAttribute("u_id");
		List<CjhCartVo> list = cartService.getCart(u_id);
//		cartService.getPCount(p_num, p_size);
		List<Integer> counts = new ArrayList<>();
		for (CjhCartVo vo : list) {
			String title_name = vo.getTitle_name();
			String front = title_name.substring(0, title_name.lastIndexOf("/") + 1);
			String rear = title_name.substring(title_name.lastIndexOf("/") + 1);
			String smTitle = front + "sm_" + rear;
			vo.setTitle_name(smTitle);
//			System.out.println("p_num : " + vo.getP_num());
//			System.out.println("p_size : " + vo.getP_size());
			counts.add(cartService.getPCount(vo.getP_num(), vo.getP_size()));
		}
		model.addAttribute("counts", counts);
		model.addAttribute("list", list);
		return "/cjh/cart";
	}
	
	//	장바구니 삭제
	@RequestMapping(value="/deleteCart", method = RequestMethod.GET)
	public String deleteCart(int c_num, HttpSession session) throws Exception {
		String u_id = (String)session.getAttribute("u_id");
		cartService.deleteCart(u_id, c_num);
		int count = cartService.getCountCart(u_id);
		session.setAttribute("count", count);
		return "redirect:/cjh/cart";
	}
	
	//	선택한 장바구니 삭제
	@RequestMapping(value="deleteCheckedCart", method = RequestMethod.GET)
	public String deleteCheckedCart(String c_num, HttpSession session) throws Exception {
		String u_id = (String)session.getAttribute("u_id");
		cartService.deleteCheckedCart(u_id, c_num);
		int count = cartService.getCountCart(u_id);
		session.setAttribute("count", count);
		return "redirect:/cjh/cart";
	}
	
	//	장바구니 수정
	@RequestMapping(value="updateCart", method = RequestMethod.GET)
	public String updateCart(int p_count, int c_num, HttpSession session) throws Exception {
		String u_id = (String)session.getAttribute("u_id");
		cartService.updateCart(u_id, p_count, c_num);
		return "redirect:/cjh/cart?u_id="+u_id;
	}
	
	//	결제 폼
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public String checkout(Model model, HttpSession session) throws Exception {
		String u_id = (String)session.getAttribute("u_id");
		List<CjhCartVo> list = cartService.getCart(u_id);
		int userPoint = pointService.getUserPoint(u_id);
		CjhUserVo userVo = userService.selectUser(u_id);
		model.addAttribute("userVo", userVo);
		model.addAttribute("userPoint", userPoint);
		model.addAttribute("list", list);
		return "cjh/checkout";
	}
	
	//	결제 처리
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public String order(int totalPrice, HttpSession session) throws Exception {
		String u_id = (String)session.getAttribute("u_id");
		pointService.minusPoint(u_id, totalPrice);
		pointService.plusPoint(u_id, totalPrice);
		pointService.usePoint(u_id, totalPrice);
		pointService.getPoint(u_id, totalPrice);

		List<CjhCartVo> list = cartService.getCart(u_id);
		int length = list.size();
		int[] p_numArr = new int[length];
		String[] p_sizeArr = new String[length];
		int[] p_countArr = new int[length];
		for(int i=0; i<list.size(); i++) {
			p_numArr[i] = list.get(i).getP_num();
			p_sizeArr[i] = list.get(i).getP_size();
			p_countArr[i] = list.get(i).getP_count();
			System.out.println(p_sizeArr[i]);
		}
		cartService.minusCount(p_numArr, p_sizeArr, p_countArr);
		cartService.orderCartUpdate(u_id);
		int count = cartService.getCountCart(u_id);
		session.setAttribute("count", count);
		return "/cjh/thankyou";
	}
	
	//	주문목록 불러오기
	@RequestMapping(value="/myOrder", method = RequestMethod.GET)
	public void getOrder(int p_status, CjhPagingDto pagingDto, HttpSession session, Model model) throws Exception {
		pagingDto.setPageInfo();
		String u_id = (String)session.getAttribute("u_id");
		int totalCount = cartService.getCountOrder(u_id, p_status);
		pagingDto.setTotalCount(totalCount);
		List<CjhCartVo> list = cartService.getOrder(u_id, p_status, pagingDto);
		for (CjhCartVo vo : list) {
			String title_name = vo.getTitle_name();
			String front = title_name.substring(0, title_name.lastIndexOf("/") + 1);
			String rear = title_name.substring(title_name.lastIndexOf("/") + 1);
			String smTitle = front + "sm_" + rear;
			vo.setTitle_name(smTitle);
		}
		model.addAttribute("p_status", p_status); 
		model.addAttribute("list", list);
		model.addAttribute("pagingDto", pagingDto);
//		return "cjh/myOrder";
	}
	
	//	주문확정하기
	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public String confirm(int c_num, int p_status) throws Exception {
		cartService.comfirmOrder(c_num);
		return "redirect:/cjh/myOrder?p_status=" + p_status;
	}
}
