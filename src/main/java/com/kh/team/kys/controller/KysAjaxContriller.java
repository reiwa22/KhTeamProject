package com.kh.team.kys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.team.domain.CjhCartVo;
import com.kh.team.domain.KysVisitCountVo;
import com.kh.team.domain.Kys_MainVo;
import com.kh.team.kys.service.KysBoardService;
import com.kh.team.kys.service.KysServeService;
import com.kh.team.kys.service.VisitCountService;

@RestController
@RequestMapping("/ajax")
public class KysAjaxContriller {
	
	private static final int HashMap = 0;
	@Inject
	private KysBoardService boardService;
	@Inject
	private KysServeService serveService;
	@Inject
	private VisitCountService visitService;
	
		//삭제 처리
		@RequestMapping(value="/productDelete", method = RequestMethod.POST)
		public String postDelete(int p_num) throws Exception{
			boardService.boardDelete(p_num);
			return "success";
		}
		@RequestMapping(value = "/restoration", method = RequestMethod.POST)
		public String restoration(int p_num) throws Exception{
			boardService.boardRestoration(p_num);
			return "success";
		}
		@RequestMapping(value="/delete",method = RequestMethod.POST)
		public String delete(int p_num) throws Exception{
			boardService.delete(p_num);
			return "success";
		}
		
		//사이즈
		@RequestMapping(value = "/dress_size", method = RequestMethod.POST)
		public List<Kys_MainVo> dress_size(String main_code,Model model) throws Exception{
			List<Kys_MainVo> derss_list = serveService.dress_size(main_code);
			model.addAttribute("derss_list",derss_list);
			return derss_list;
		}
		//배송상태 업뎃
		@RequestMapping(value="/updateStatus",method=RequestMethod.POST)
		public String updateStatus(int p_status,int p_num,String u_id) throws Exception{
			
			visitService.updateStatus(p_status,p_num,u_id);
			return "success";
		}
		
	
}
