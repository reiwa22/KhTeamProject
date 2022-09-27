package com.kh.team.kys.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.domain.Kys_BoardDto;
import com.kh.team.domain.Kys_BoardVo;
import com.kh.team.domain.Kys_ImgVo;
import com.kh.team.domain.Kys_MainVo;
import com.kh.team.domain.Kys_ServeVo;
import com.kh.team.domain.Kys_productCountVo;
import com.kh.team.kys.service.KysBoardService;
import com.kh.team.kys.service.KysServeService;
import com.kh.team.kys.service.VisitCountService;

@Controller
@RequestMapping("/manager")
public class KysBoardController {
	
	@Inject
	private KysBoardService boardService;
	
	@Inject
	private KysServeService serveService;
	
	@Inject
	private VisitCountService visitService;
	

	
	//관리자 메인 화면.
	@RequestMapping(value="/manager_main",method = RequestMethod.GET)
	public String manager_main(Model model) throws Exception {
		List<KysVisitCountVo> cartVo = visitService.orderList();
		model.addAttribute("cartVo",cartVo);
		
		
		
		return "manager/manager_main";
	}
	
	//상품 리스트  + 게시물 페이징
	@RequestMapping(value="/normal_list",method = RequestMethod.GET)
	public void normal_list(Kys_BoardDto boardDto, Model model) throws Exception{
		boardDto.setPageInfo();
		int totalCount = boardService.getCount(boardDto);
		boardDto.setTotalCount(totalCount);
		List<Kys_BoardVo> pageList = boardService.pageList(boardDto);
		
//		System.out.println("totalCount controller : "+totalCount);
//		System.out.println("boardDto controller :"+boardDto);
//		System.out.println("pageList controller :"+pageList);
		
		model.addAttribute("pageList",pageList);
		model.addAttribute("boardDto",boardDto);
		
		
	}
	
	//상품 등록 폼
	@RequestMapping(value ="/shop_single_input", method = RequestMethod.GET)
	public void board_produce(Model model) throws Exception{
		List<Kys_MainVo> mainList = serveService.mainList();
		List<Kys_ServeVo> serveList = serveService.serveList();
		model.addAttribute("mainList",mainList);
		model.addAttribute("serveList",serveList);
		
	}
	//등록 처리 
	@RequestMapping(value="/shop_single_input", method = RequestMethod.POST)
	public String shop_single_input(Kys_BoardVo boardVo,Kys_productCountVo productCountVo) throws Exception{
//		System.out.println("boardVo: " + boardVo);
		boardService.boardInsert(boardVo);
		
		return "redirect:/manager/shop_single_input";
	}
	//상품 1개 찾기
	@RequestMapping(value="oenSelect", method = RequestMethod.GET)
	public void oenSelect(Model model, int p_num) throws Exception {
		List<Kys_ImgVo> listImg = boardService.imgSelectBy(p_num);
		Kys_BoardVo boardVo = boardService.boardSelectBy(p_num);
		List<Kys_productCountVo> prodcutCountList = boardService.selectProductCount(p_num);
		List<Kys_MainVo> mainList = serveService.mainList();
		List<Kys_ServeVo> serveList = serveService.serveList();
			
		model.addAttribute("mainList",mainList);
		model.addAttribute("serveList",serveList);
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("listImg",listImg);
		model.addAttribute("prodcutCountList",prodcutCountList);
		
	}
	//상품 수정 처리
	@RequestMapping(value="/productUpdate",method = RequestMethod.POST)
	public String productUpdate(Kys_BoardVo boardVo) throws Exception{
		boardService.boardUpdate(boardVo);
		return "redirect:/manager/normal_list";
	}
	//삭제 처리된 게시물
	@RequestMapping(value = "/board_deleteList", method = RequestMethod.GET)
	public void deleteList(Kys_BoardDto deleteListDto,Model model) throws Exception{
		deleteListDto.setPageInfo();
		int totalCount = boardService.getDeleteCount(deleteListDto);
		deleteListDto.setTotalCount(totalCount);
		List<Kys_BoardVo> list = boardService.deleteList(deleteListDto);
		model.addAttribute("list",list);
		model.addAttribute("deleteListDto",deleteListDto);
	}
	//차트
	@RequestMapping(value="/NewFile", method = RequestMethod.GET)
	public void chart() throws Exception{
		
	}
	//막대 차트
	@RequestMapping(value = "/rodChart", method= RequestMethod.GET)
	public ModelAndView rodChart(Model model) throws Exception{
//		List<KysVisitCountVo> list = visitService.rodChart();
//		System.out.println(list);
//		model.addAttribute("list",list);
		return new ModelAndView("manager/rodChart");
	}
	//주문 받은 게시물
	@RequestMapping(value = "/salesAll",method = RequestMethod.GET)
	public void salesAll(Kys_BoardDto salesDto,Model model) throws Exception{
		salesDto.setPageInfo();
		int totalCount = boardService.getSalesCount(salesDto);
		salesDto.setTotalCount(totalCount);
		List<CjhCartVo> list = boardService.salesAll(salesDto);
		model.addAttribute("list",list);
		model.addAttribute("salesDto",salesDto);
	}
	
}
